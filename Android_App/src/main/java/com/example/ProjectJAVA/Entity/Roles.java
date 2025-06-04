package com.example.ProjectJAVA.Entity;

import jakarta.persistence.*;

import java.util.List;

@Entity(name = "roles")
public class Roles {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int role_id;

    @Column(name = "role_name")
    private String role_name;

    @OneToMany(mappedBy = "roles")
    List<Users> usersList;

    public int getRole_id() {
        return role_id;
    }

    public void setRole_id(int role_id) {
        this.role_id = role_id;
    }

    public String getRole_name() {
        return role_name;
    }

    public void setRole_name(String role_name) {
        this.role_name = role_name;
    }

    public List<Users> getUsersList() {
        return usersList;
    }

    public void setUsersList(List<Users> usersList) {
        this.usersList = usersList;
    }
}
