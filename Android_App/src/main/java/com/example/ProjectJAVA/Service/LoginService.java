package com.example.ProjectJAVA.Service;

import com.example.ProjectJAVA.Entity.Roles;
import com.example.ProjectJAVA.Entity.Users;
import com.example.ProjectJAVA.Jwts.JwtUtilHelper;
import com.example.ProjectJAVA.Payloads.Resquest.RegisterRequest;
import com.example.ProjectJAVA.Repository.UserRepository;
import com.example.ProjectJAVA.Service.Imp.LoginServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class LoginService implements LoginServiceImp {
    @Autowired
    JwtUtilHelper jwtUtilHelper;

    @Autowired
    UserRepository userRepository;

    @Autowired
    PasswordEncoder passwordEncoder;

    @Override
    public Users CheckLogin(String username, String password) {
        Users users = userRepository.findUserByUsername(username);

        if (users == null){
            System.out.println("User not found");
        }

        System.out.println("Input password " + password);
        System.out.println("Right password " + users.getPassword());

        if (users.getPassword().equals(password)){
            System.out.println("Login successful");
            return users;
        }else {
            System.out.println("Invalid password");
            return null;
        }

    }

    @Override
    public Boolean isRegister(RegisterRequest registerRequest) {
        if(userRepository.findUserByUsername(registerRequest.getUsername()) != null){
            System.out.println("User already exist");
            return false;
        }

        Users users = new Users();

        users.setUsername(registerRequest.getUsername());
        users.setPassword(registerRequest.getPassword());

        Roles roles = new Roles();
        roles.setRole_id(registerRequest.getRole_id());
        users.setRoles(roles);

        try {
            System.out.println("Inserting users");
            userRepository.save(users);
            System.out.println("Inserted Users");

            String Token = jwtUtilHelper.GenerateToken(users.getUsername());
            System.out.println("Jwt Token " + Token);
            return true;
        }catch (Exception e){
            e.printStackTrace();
            return false;

        }

    }
}
