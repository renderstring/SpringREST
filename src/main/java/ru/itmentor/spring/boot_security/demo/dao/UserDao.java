package ru.itmentor.spring.boot_security.demo.dao;

import ru.itmentor.spring.boot_security.demo.model.User;

import java.util.List;
import java.util.Optional;

public interface UserDao {

    List<User> getAllUsers();

    void addUser(User user);

    void updateUser(User user);

    User getUserById(long id);

    void deleteUserById(long id);

    Optional<User> findUserByEmail(String email);

}
