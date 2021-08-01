package com.example.restfulwebservice;

public interface SecurityService {
    String findLoggedInUsername();

    void autoLogin(String username, String password);
}
