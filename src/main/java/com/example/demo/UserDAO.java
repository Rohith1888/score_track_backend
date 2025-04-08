package com.example.demo;

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

}
