package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/live-matches")
@CrossOrigin(origins = "*")
public class CricketLiveMatchController {

    @Autowired
    private CricketLiveDAO cricketLiveDAO;

    // Get all live matches
    @GetMapping
    public List<LiveCricketMatch> getAllLiveMatches() {
        return cricketLiveDAO.getAllLiveMatches();
    }

    // Get a live match by ID
    @GetMapping("/{id}")
    public ResponseEntity<LiveCricketMatch> getLiveMatchById(@PathVariable int id) {
        Optional<LiveCricketMatch> match = cricketLiveDAO.getLiveMatchById(id);
        return match.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    // Add a new live match
    @PostMapping
    public LiveCricketMatch addLiveMatch(@RequestBody LiveCricketMatch match) {
        return cricketLiveDAO.addLiveMatch(match);
    }

    // Update scores for a live match
    @PutMapping("/{id}/score")
    public ResponseEntity<LiveCricketMatch> updateMatchScore(
            @PathVariable int id,
            @RequestParam String team1Score,
            @RequestParam String team2Score,
            @RequestParam String matchDecision) {

        Optional<LiveCricketMatch> updatedMatch = cricketLiveDAO.updateScore(id, team1Score, team2Score, matchDecision);
        return updatedMatch.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    // Update Batting Stats for a player
    @PutMapping("/{id}/batting")
    public ResponseEntity<LiveCricketMatch> updateBattingStats(
            @PathVariable int id,
            @RequestParam int teamNumber,
            @RequestParam String playerName,
            @RequestParam int runs,
            @RequestParam int balls,
            @RequestParam int fours,
            @RequestParam int sixes,
            @RequestParam double strikeRate) {

        Optional<LiveCricketMatch> updatedMatch = cricketLiveDAO.updateBattingStats(id, teamNumber, playerName, runs, balls, fours, sixes, strikeRate);
        return updatedMatch.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    // Update Bowling Stats for a player
    @PutMapping("/{id}/bowling")
    public ResponseEntity<LiveCricketMatch> updateBowlingStats(
            @PathVariable int id,
            @RequestParam int teamNumber,
            @RequestParam String playerName,
            @RequestParam double overs,
            @RequestParam int maidens,
            @RequestParam int runs,
            @RequestParam int wickets,
            @RequestParam double economy) {

        Optional<LiveCricketMatch> updatedMatch = cricketLiveDAO.updateBowlingStats(id, teamNumber, playerName, overs, maidens, runs, wickets, economy);
        return updatedMatch.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }
    @PutMapping("/live-match/{id}")
    public ResponseEntity<LiveCricketMatch> updateMatch(@PathVariable int id, @RequestBody LiveCricketMatch match) {
        Optional<LiveCricketMatch> updatedMatch = cricketLiveDAO.updateLiveMatch(id, match);
        return updatedMatch.map(ResponseEntity::ok)
                           .orElseGet(() -> ResponseEntity.notFound().build());
    }
    @DeleteMapping("/live-matches/{id}")
    public ResponseEntity<Void> deleteMatch(@PathVariable int id) {
        boolean deleted = cricketLiveDAO.deleteMatchById(id);
        if (deleted) {
            return ResponseEntity.noContent().build(); // HTTP 204
        } else {
            return ResponseEntity.notFound().build();  // HTTP 404
        }
    }


}
