package com.example.Exams.project.Services;

import com.example.Exams.project.Model.Admin;
import com.example.Exams.project.Repository.AdminRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AdminService {

    @Autowired
    private AdminRepository adminRepository;

    public ResponseEntity<String> loginAdmin(String email, String password) {
        // Retrieve the admin by email from the database
        Optional<Admin> existingAdmin = adminRepository.findByEmail(email);

        if (!existingAdmin.isPresent()) {
            // Return a 404 status code if the email is not found
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Email not found.");
        }

        // Retrieve the existing admin
        Admin existing = existingAdmin.get();

        // Verify the password
        if (!existing.getPassword().equals(password)) {
            // Return a 401 status code if the password does not match
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED)
                    .body("Incorrect password.");
        }

        // Successful login
        return ResponseEntity.status(HttpStatus.OK)
                .body("Login successful!");
    }
}
