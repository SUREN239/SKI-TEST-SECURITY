package com.kenny.springsecurity.controller;


import com.kenny.springsecurity.auth.UserResponse;
import com.kenny.springsecurity.repo.UserRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/test")
@RequiredArgsConstructor
@CrossOrigin(origins = "http://localhost:3000")
public class UserController {

    @Autowired
    private UserRepo userRepo;
    @GetMapping
    public ResponseEntity<UserResponse> getUserDetails(@AuthenticationPrincipal UserDetails userDetails) {
        var user = userRepo.findByEmail(userDetails.getUsername()).orElseThrow();
        return ResponseEntity.ok(UserResponse.builder()
                .email(user.getEmail())
                .name(user.getName())
                .role(user.getRole().name())
                .build());
    }
}
