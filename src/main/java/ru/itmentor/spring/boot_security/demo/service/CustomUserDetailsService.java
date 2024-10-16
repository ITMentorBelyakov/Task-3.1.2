package ru.itmentor.spring.boot_security.demo.service;

import org.hibernate.Hibernate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.itmentor.spring.boot_security.demo.models.User;
import ru.itmentor.spring.boot_security.demo.repository.DAO;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    private final DAO userDAO;

    @Autowired
    public CustomUserDetailsService(DAO userDAO) {
        this.userDAO = userDAO;
    }

    @Override
    @Transactional(readOnly = true)
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userDAO.findByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException("Пользователь не найден: " + username));
        Hibernate.initialize(user.getRoles());
        return user;
    }
}