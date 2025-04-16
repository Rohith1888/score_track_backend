package com.example.demo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import io.swagger.v3.oas.annotations.tags.Tag;

@Tag(name = "Cricket Upcoming Matches", description = "APIs to manage upcoming cricket matches")
@RestController
@RequestMapping("/upcoming")
@CrossOrigin
public class ScoreTrackController {

    @Autowired
    private CricketUpcomingDAO cricketUpcomingDAO;

    @GetMapping("/")
    public String test() {
        return "this is testing";
    }

    @GetMapping("/matches")
    public List<Cricket_UpComing> getUpcomingMatches() {
        return cricketUpcomingDAO.getAllMatches();
    }

    @PostMapping("/match")
    public Cricket_UpComing addMatch(@RequestBody Cricket_UpComing match) {
        return cricketUpcomingDAO.addMatch(match);
    }

    @GetMapping("/match/{id}")
    public ResponseEntity<Cricket_UpComing> getMatchById(@PathVariable int id) {
        return cricketUpcomingDAO.getMatchById(id)
            .map(ResponseEntity::ok)
            .orElseGet(() -> ResponseEntity.status(HttpStatus.NOT_FOUND).build());
    }

    
}
