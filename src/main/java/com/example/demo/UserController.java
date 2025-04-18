package com.example.demo;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import io.swagger.v3.oas.annotations.tags.Tag;
import io.swagger.v3.oas.annotations.Operation;

@RestController
@RequestMapping("/user")
@CrossOrigin
@Tag(name = "User", description = "User authentication and registration APIs")
public class UserController {

    @Autowired
    private UserDAO userDAO;

    @Operation(summary = "Register a new user")
    @PostMapping("/register")
    public ResponseEntity<?> registerUser(@RequestBody User user) {
        if (userDAO.existsByEmail(user.getEmail())) {
            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body("Error: Email already exists.");
        }
        User savedUser = userDAO.registerUser(user);
        return ResponseEntity.ok(savedUser);
    }

    @Operation(summary = "User login")
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

    @Operation(summary = "Update user's name or password")
    @PutMapping("/update")
    public ResponseEntity<?> updateUser(@RequestParam String email,
                                        @RequestParam(required = false) String newName,
                                        @RequestParam(required = false) String newPassword) {

        if ((newName == null || newName.isEmpty()) && (newPassword == null || newPassword.isEmpty())) {
            return ResponseEntity.badRequest().body("Error: No fields to update.");
        }

        User updatedUser = userDAO.updateUser(email, newName, newPassword);
        if (updatedUser != null) {
            return ResponseEntity.ok(updatedUser);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("User not found.");
        }
    }
    @Operation(summary = "Delete a user")
    @DeleteMapping("/delete")
    public ResponseEntity<?> deleteUser(@RequestParam String email) {
        boolean deleted = userDAO.deleteUser(email);
        if (deleted) {
            return ResponseEntity.ok("User deleted successfully.");
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("User not found.");
        }
    }
    @Operation(summary = "Get all users")
    @GetMapping("/all")
    public ResponseEntity<List<User>> getAllUsers() {
        List<User> users = userDAO.getAllUsers();
        return ResponseEntity.ok(users);
    }

}

