package com.example.restfulwebservice;

public interface UserService {
    void save(User user);

    User findByUserName(String username);
}
