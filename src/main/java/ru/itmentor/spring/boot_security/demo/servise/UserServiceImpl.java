package ru.itmentor.spring.boot_security.demo.servise;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.itmentor.spring.boot_security.demo.models.User;
import ru.itmentor.spring.boot_security.demo.repository.DAO;

import java.util.List;

@Service
@Transactional(readOnly = true)
public class UserServiceImpl implements UserService {

    private final DAO userDAO;

    @Autowired
    public UserServiceImpl(DAO userDAO) {
        this.userDAO = userDAO;
    }

    @Override
    public List<User> showAllUsers() {
        return userDAO.showAllUsers();
    }

    @Override
    public User showUserForId(Long id) {
        return userDAO.showUserForId(id);
    }

    @Transactional
    @Override
    public void saveUser(User user) {
        userDAO.saveUser(user);
    }

    @Transactional
    @Override
    public void updateUser(User user) {
        userDAO.updateUser(user);
    }

    @Transactional
    @Override
    public void deleteUser(Long id) {
        userDAO.deleteUser(id);
    }

    @Override
    public User findByUsername(String username) {
        return userDAO.findByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException("Пользователь не найден: " + username));
    }
}