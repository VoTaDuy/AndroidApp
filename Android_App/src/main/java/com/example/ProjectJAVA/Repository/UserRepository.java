package com.example.ProjectJAVA.Repository;

import com.example.ProjectJAVA.Entity.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<Users, Integer> {
    Users findUserByUsername(String username);


}
