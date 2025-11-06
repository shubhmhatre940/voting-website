package com.example.voting.controller;

import com.example.voting.model.Candidate;
import com.example.voting.model.Voter;
import com.example.voting.repo.CandidateRepository;
import com.example.voting.repo.VoterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/api/vote")
@CrossOrigin(origins = "*")
public class VoteController {
    @Autowired
    private CandidateRepository candidateRepository;
    @Autowired
    private VoterRepository voterRepository;

    @PostMapping("/cast")
    public ResponseEntity<?> castVote(@RequestBody Map<String,String> body){
        Long voterId = Long.valueOf(body.get("voterId"));
        Long candidateId = Long.valueOf(body.get("candidateId"));
        Optional<Voter> vOpt = voterRepository.findById(voterId);
        Optional<Candidate> cOpt = candidateRepository.findById(candidateId);
        if (vOpt.isEmpty() || cOpt.isEmpty()) return ResponseEntity.badRequest().body(Map.of("error","Invalid ids"));
        Voter v = vOpt.get();
        if (v.isHasVoted()) return ResponseEntity.badRequest().body(Map.of("error","Already voted"));
        Candidate c = cOpt.get();
        c.setVotes(c.getVotes() + 1);
        v.setHasVoted(true);
        candidateRepository.save(c);
        voterRepository.save(v);
        return ResponseEntity.ok(Map.of("message","Vote cast" ));
    }
}
