package ru.itmentor.spring.boot_security.demo.service;

import ru.itmentor.spring.boot_security.demo.models.Role;
import java.util.List;

public interface RoleService {
    List<Role> getAllRoles();
    Role getRoleById(Long id);
    Role saveRole(Role role);
    void deleteRole(Long id);
    Role findByName(String name);
}