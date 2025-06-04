package com.example.ProjectJAVA.Service.Imp;

import com.example.ProjectJAVA.Entity.Users;
import com.example.ProjectJAVA.Payloads.Resquest.RegisterRequest;

public interface LoginServiceImp {
    public Users CheckLogin(String username, String password);
    public Boolean isRegister(RegisterRequest registerRequest);
}
