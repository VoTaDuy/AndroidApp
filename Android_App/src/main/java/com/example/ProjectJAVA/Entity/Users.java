package com.example.ProjectJAVA.Entity;


import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.util.Date;

@Entity(name = "users")
public class Users {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long user_id;

    @Column(name = "created_Date")
    private Date created_Date;

    @Column(name ="password")
    private String password;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name= "role_id")
    private Roles roles;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name ="user_id", referencedColumnName = "user_id")
    private User_Details userDetails;


    @Column(name="username")
    private String username;

    public long getUser_id() {
        return user_id;
    }

    public void setUser_id(long user_id) {
        this.user_id = user_id;
    }

    public Date getCreated_Date() {
        return created_Date;
    }

    public void setCreated_Date(Date created_Date) {
        this.created_Date = created_Date;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Roles getRoles() {
        return roles;
    }

    public void setRoles(Roles roles) {
        this.roles = roles;
    }

    public User_Details getUserDetails() {
        return userDetails;
    }

    public void setUserDetails(User_Details userDetails) {
        this.userDetails = userDetails;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
