package ru.itmentor.spring.boot_security.demo.dao;

import org.springframework.stereotype.Repository;
import ru.itmentor.spring.boot_security.demo.model.User;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;
import java.util.Optional;

@Repository
public class UserDaoImpl implements UserDao {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<User> getAllUsers() {
        return entityManager
                .createQuery("from User order by id", User.class)
                .getResultList();
    }

    @Override
    public void addUser(User user) {
        entityManager.persist(user);
    }

    @Override
    public void updateUser(User user) {
        entityManager.merge(user);
    }

    @Override
    public User getUserById(long id) {
        return entityManager.find(User.class, id);
    }

    @Override
    public void deleteUserById(long id) {
        entityManager.createQuery("delete from User where id =: id")
                .setParameter("id", id)
                .executeUpdate();
    }

    @Override
    public Optional<User> findUserByEmail(String email) {
        return getAllUsers()
                .stream()
                .filter(u -> u.getEmail().equals(email))
                .findFirst();
    }
}
