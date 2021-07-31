package com.example.restfulwebservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    UserRepository userRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public void createAndSaveUser(String username) {
        User user = new User();
        user.setUsername(username);

        userRepository.save(user);
    }
}
