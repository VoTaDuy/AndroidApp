package com.example.ProjectJAVA.Service.Imp;

import com.example.ProjectJAVA.Entity.Users;
import com.example.ProjectJAVA.Payloads.Resquest.RegisterRequest;

public interface LoginServiceImp {
    Users CheckLogin(String username, String password);
    Boolean isRegister(RegisterRequest registerRequest);
}
