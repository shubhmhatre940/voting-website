package com.example.voting.controller;

import com.example.voting.model.Voter;
import com.example.voting.repo.VoterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/api/auth")
@CrossOrigin(origins = "*")
public class AuthController {
    @Autowired
    private VoterRepository voterRepository;

    @PostMapping("/register")
    public ResponseEntity<?> register(@RequestBody Voter voter){
        if (voterRepository.findByEmail(voter.getEmail()).isPresent()){
            return ResponseEntity.badRequest().body(Map.of("error","Email already registered"));
        }
        // Note: passwords stored plaintext for demo only — in production hash them.
        voterRepository.save(voter);
        return ResponseEntity.ok(Map.of("message","Registered"));
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody Map<String,String> body){
        String email = body.get("email");
        String password = body.get("password");
        Optional<Voter> v = voterRepository.findByEmail(email);
        if (v.isPresent() && v.get().getPassword().equals(password)){
            return ResponseEntity.ok(Map.of("message","OK","voterId", v.get().getId()));
        }
        return ResponseEntity.status(401).body(Map.of("error","Invalid credentials"));
    }
}
