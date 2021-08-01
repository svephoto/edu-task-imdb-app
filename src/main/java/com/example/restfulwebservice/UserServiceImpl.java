package com.example.restfulwebservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    private UserRepository userRepository;

//    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Autowired
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public void createAndSaveUser(String username) {
        User user = new User();
        user.setUsername(username);

        userRepository.save(user);
    }

    @Override
    public void save(User user) {

    }

    @Override
    public User findByUserName(String username) {
        return userRepository.findByUsername(username);
    }
}
