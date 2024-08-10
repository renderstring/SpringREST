package ru.itmentor.spring.boot_security.demo.service;

import ru.itmentor.spring.boot_security.demo.model.User;

import java.util.List;
import java.util.Optional;

public interface UserService {

    List<User> getAllUsers();

    void addUser(User user);

    void updateUser(User user);

    User getUserById(long id);

    void deleteUserById(long id);

    User findUserByEmail(String email);
}
