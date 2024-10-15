package ru.itmentor.spring.boot_security.demo.repository;

import org.springframework.stereotype.Repository;
import ru.itmentor.spring.boot_security.demo.models.User;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;
import java.util.Optional;

@Repository
public class DAOImpl implements DAO {

    @PersistenceContext
    private EntityManager entityManager;

    public List<User> showAllUsers() {
        return entityManager.createQuery("FROM User", User.class).getResultList();
    }

    public User showUserForId(Long id) {
        return entityManager.find(User.class, id);
    }

    public void saveUser(User user) {
        entityManager.merge(user);
    }

    public void updateUser(User user) {
        entityManager.merge(user);
    }

    public void deleteUser(Long id) {
        entityManager.remove(entityManager.find(User.class, id));
    }

    public Optional<User> findByUsername(String username) {
        TypedQuery<User> query = entityManager.createQuery(
                "SELECT u FROM User u WHERE u.username = :username", User.class);
        query.setParameter("username", username);
        List<User> results = query.getResultList();
        return results.isEmpty() ? Optional.empty() : Optional.of(results.get(0));
    }
}