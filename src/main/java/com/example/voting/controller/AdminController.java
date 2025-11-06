package com.example.voting.controller;

import com.example.voting.model.Candidate;
import com.example.voting.repo.CandidateRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/admin")
@CrossOrigin(origins = "*")
public class AdminController {
    // Simple demo admin: username=admin password=admin123 (handled client-side for demo)
    @Autowired
    private CandidateRepository candidateRepository;

    @PostMapping("/addCandidate")
    public ResponseEntity<?> addCandidate(@RequestBody Candidate c){
        candidateRepository.save(c);
        return ResponseEntity.ok(Map.of("message","Candidate added"));
    }

    @GetMapping("/candidates")
    public List<Candidate> listCandidates(){
        return candidateRepository.findAll();
    }

    @GetMapping("/results")
    public List<Candidate> results(){
        // candidates with vote counts
        return candidateRepository.findAll();
    }

    @DeleteMapping("/candidates/{id}")
    public ResponseEntity<?> deleteCandidate(@PathVariable Long id) {
        if (!candidateRepository.existsById(id)) {
            return ResponseEntity.status(404).body(Map.of("error", "Candidate not found"));
        }
        candidateRepository.deleteById(id);
        return ResponseEntity.ok(Map.of("message", "Candidate deleted successfully"));
    }

}
