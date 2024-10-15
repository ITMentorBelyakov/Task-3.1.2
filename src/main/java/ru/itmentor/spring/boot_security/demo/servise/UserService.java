package ru.itmentor.spring.boot_security.demo.servise;

import ru.itmentor.spring.boot_security.demo.models.User;

import java.util.List;

public interface UserService {

    List<User> showAllUsers();

    User showUserForId(Long id);

    void saveUser(User user);

    void updateUser(User user);

    void deleteUser(Long id);
}