package com.example.demo;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserDAO {

    @Autowired
    private UserRepo userrepo;

    public User registerUser(User user) {
        return userrepo.save(user);
    }

    public boolean existsByEmail(String email) {
        return userrepo.existsByEmail(email);
    }

    public UserResponse loginUser(String email, String password) {
        Optional<User> user = userrepo.findById(email);
        if (user.isPresent() && user.get().getPassword().equals(password)) {
            return new UserResponse(user.get().getEmail(), user.get().getFullName());
        }
        return null;
    }

    public User updateUser(String email, String newName, String newPassword) {
        Optional<User> optionalUser = userrepo.findById(email);
        if (optionalUser.isPresent()) {
            User user = optionalUser.get();
            if (newName != null && !newName.isEmpty()) {
                user.setFullName(newName);
            }
            if (newPassword != null && !newPassword.isEmpty()) {
                user.setPassword(newPassword);
            }
            return userrepo.save(user);
        }
        return null;
    }

    public boolean deleteUser(String email) {
        if (userrepo.existsById(email)) {
            userrepo.deleteById(email);
            return true;
        }
        return false;
    }
    // ✅ Get all users
    public List<User> getAllUsers() {
        return userrepo.findAll();
    }
}
