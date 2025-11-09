package practice.springboot.features.springboot_practice.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;
import practice.springboot.features.springboot_practice.config.JwtUtil;
import practice.springboot.features.springboot_practice.entity.AppUser;
import practice.springboot.features.springboot_practice.repo.UserRepository;

import java.util.Map;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    @Autowired private UserRepository userRepo;
    @Autowired private PasswordEncoder encoder;
    @Autowired private JwtUtil jwtUtil;

    @PostMapping("/register")
    public ResponseEntity<?> register(@RequestBody AppUser user) {
        user.setPassword(encoder.encode(user.getPassword()));
        user.setRole(user.getRole());
        user.setUsername(user.getUsername());
        userRepo.save(user);
        return ResponseEntity.ok(Map.of("message", "User registered successfully"));
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody Map<String, String> req) {
        String username = req.get("username");
        String password = req.get("password");
        AppUser user = userRepo.findByUsername(username).orElse(null);

        if (user != null && encoder.matches(password, user.getPassword())) {
            String token = jwtUtil.generateToken(username);
            return ResponseEntity.ok(Map.of("token", token));
        }
        return ResponseEntity.status(401).body(Map.of("error", "Invalid credentials"));
    }
}
