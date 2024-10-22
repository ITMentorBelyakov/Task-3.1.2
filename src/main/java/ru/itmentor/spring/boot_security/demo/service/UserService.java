package ru.itmentor.spring.boot_security.demo.service;

import ru.itmentor.spring.boot_security.demo.models.User;

import java.util.List;

public interface UserService {
    List<User> getAllUsers();
    User getUserById(Long id);
    User saveUser(User user);
    User updateUser(User user);
    void deleteUser(Long id);
    User findByUsername(String username);
}