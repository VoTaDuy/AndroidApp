package com.example.ProjectJAVA.Controller;

import com.example.ProjectJAVA.Entity.Users;
import com.example.ProjectJAVA.Jwts.JwtUtilHelper;
import com.example.ProjectJAVA.Payloads.ResponseData;
import com.example.ProjectJAVA.Payloads.Resquest.RegisterRequest;
import com.example.ProjectJAVA.Service.Imp.LoginServiceImp;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.web.csrf.CsrfToken;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@CrossOrigin("*")
@RestController()
@RequestMapping("/login")
public class LoginController {
    @Autowired
    JwtUtilHelper jwtUtilHelper;

    @Autowired
    LoginServiceImp loginServiceImp;

    @GetMapping("/csrf-token")
    public CsrfToken getCsrfToken(HttpServletRequest request){
        return (CsrfToken) request.getAttribute("_csrf");
    }

    @PostMapping("/sign_up")
    public ResponseEntity<?> Signup(@RequestParam String username, @RequestParam String password){

        System.out.println("username : " + username );
        System.out.println("password : " + password);

        ResponseData responseData = new ResponseData();
        Users users = loginServiceImp.CheckLogin(username,password);
        if (users != null){
            String token = jwtUtilHelper.GenerateToken(users.getUsername());
            Map<String, Object> data = new HashMap<>();
            data.put("userId", users.getUser_id());
            data.put("username", users.getUsername());
            data.put("token",token);
            responseData.setData(data);
            responseData.setSuccess(true);
        }else {
            responseData.setData("Wrong username or password");
            responseData.setSuccess(false);
        }

        return new ResponseEntity<>(responseData, HttpStatus.OK);

    }

    @PostMapping("/register")
    public ResponseEntity<?> Register(@RequestBody RegisterRequest registerRequest){

        ResponseData responseData = new ResponseData();
        boolean isRegister = loginServiceImp.isRegister(registerRequest);
        if (isRegister){
            responseData.setSuccess(true);
            responseData.setData("Register success ");
        }else {
            responseData.setSuccess(false);
            responseData.setData("Register failed ");
        }

        return new ResponseEntity<>(responseData,HttpStatus.OK);
    }
}
