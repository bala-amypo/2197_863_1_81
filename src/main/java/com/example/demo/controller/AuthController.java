package com.example.demo.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import com.example.demo.dto.LoginRequest;
import com.example.demo.dto.RegisterRequest;
import com.example.demo.entity.User;
import com.example.demo.security.JwtUtil;
import com.example.demo.service.UserService;

@RestController
@RequestMapping("/auth")
public class AuthController {

    private final UserService userService;
    private final JwtUtil jwtUtil;
    private final PasswordEncoder passwordEncoder;

    public AuthController(UserService userService,
                          JwtUtil jwtUtil,
                          PasswordEncoder passwordEncoder) {
        this.userService = userService;
        this.jwtUtil = jwtUtil;
        this.passwordEncoder = passwordEncoder;
    }

    // ✅ REGISTER
    @PostMapping("/register")
    public ResponseEntity<User> register(@RequestBody RegisterRequest request) {

        User user = new User();
        user.setFullName(request.getFullName());
        user.setEmail(request.getEmail());
        user.setDepartment(request.getDepartment());
        user.setPassword(request.getPassword());

        return ResponseEntity.ok(userService.registerUser(user));
    }
    @PostMapping("/login")
public ResponseEntity<?> login(@RequestBody LoginRequest request) {

    try {
        User user = userService.getUserByEmail(request.getEmail());

        // 🔍 DEBUG PRINTS (TEMP)
        System.out.println("EMAIL = " + request.getEmail());
        System.out.println("RAW PASSWORD = " + request.getPassword());
        System.out.println("DB PASSWORD = " + user.getPassword());
        System.out.println("MATCH = " +
            passwordEncoder.matches(request.getPassword(), user.getPassword()));

        if (!passwordEncoder.matches(request.getPassword(), user.getPassword())) {
            return ResponseEntity.status(401).body("Invalid credentials");
        }

        String token = jwtUtil.generateTokenForUser(user);
        return ResponseEntity.ok(token);

    } catch (Exception e) {
        return ResponseEntity.status(401).body("Invalid credentials");
    }
}

   
}
