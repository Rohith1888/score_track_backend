package com.example.demo;

public class UserResponse {
    private String email;
    private String fullName;

    public UserResponse(String email, String fullName) {
        this.email = email;
        this.fullName = fullName;
    }

    public String getEmail() {
        return email;
    }

    public String getFullName() {
        return fullName;
    }
}
