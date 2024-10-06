package com.example.UserLoginProjectService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.UserLoginProjectEntity.User;
import com.example.UserLoginProjectRepository.UserRepository;

@Service
public class UserService {

	@Autowired
	private UserRepository userRepository;

    public void save(User user) {
        userRepository.save(user);
    }

    public User findByUsername(String username) {
        return userRepository.findByUsername(username);
    }
}
