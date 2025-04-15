package com.example.demo;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CricketUpcomingDAO {
    
    @Autowired
    private CricketUpcoming_Repo cricketUpcomingRepo;

    public List<Cricket_UpComing> getAllMatches() {
        return cricketUpcomingRepo.findAll();
    }

    public Cricket_UpComing addMatch(Cricket_UpComing match) {
        return cricketUpcomingRepo.save(match);
    }

    public Optional<Cricket_UpComing> getMatchById(int id) {
        return cricketUpcomingRepo.findById(id);
    }
}
