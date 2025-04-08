package com.example.demo;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
@CrossOrigin
public class UserController {

    @Autowired
    private UserDAO userDAO;

    @PostMapping("/register")
    public ResponseEntity<?> registerUser(@RequestBody User user) {
    	System.out.println(userDAO.existsByEmail(user.getEmail()));
        if (userDAO.existsByEmail(user.getEmail())) {
            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body("Error: Email already exists.");
        }
        User savedUser = userDAO.registerUser(user);
        return ResponseEntity.ok(savedUser);
    }

    @PostMapping("/login")
    public ResponseEntity<?> loginUser(@RequestBody Map<String, String> credentials) {
        String email = credentials.get("email");
        String password = credentials.get("password");

        UserResponse response = userDAO.loginUser(email, password);

        if (response != null) {
            return ResponseEntity.ok(response);
        } else {
            Map<String, String> errorResponse = new HashMap<>();
            errorResponse.put("message", "Invalid credentials or user not found");
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(errorResponse);
        }
    }
}
