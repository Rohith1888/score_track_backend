package com.example.demo;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/upcoming/kabaddi")
@CrossOrigin
public class KabaddiScoreTrackController {

    @Autowired
    private KabaddiUpcomingDAO kabaddiUpcomingDAO;

    @GetMapping("/")
    public String test() {
        return "this is kabaddi testing";
    }

    @GetMapping("/matches")
    public List<Kabaddi_UpComing> getUpcomingMatches() {
        return kabaddiUpcomingDAO.getAllMatches();
    }

    @PostMapping("/match")
    public Kabaddi_UpComing addMatch(@RequestBody Kabaddi_UpComing match) {
        return kabaddiUpcomingDAO.addMatch(match);
    }

    @GetMapping("/match/{id}")
    public ResponseEntity<Kabaddi_UpComing> getMatchById(@PathVariable int id) {
        return kabaddiUpcomingDAO.getMatchById(id)
            .map(ResponseEntity::ok)
            .orElseGet(() -> ResponseEntity.status(HttpStatus.NOT_FOUND).build());
    }

}
