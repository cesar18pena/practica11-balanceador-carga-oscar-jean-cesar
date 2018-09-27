package com.oscarjeancesar.pucmm.practica10oscarjeancesar.service;

public interface SecurityService {
    String findLoggedInUsername();

    void autoLogin(String username, String password);
}