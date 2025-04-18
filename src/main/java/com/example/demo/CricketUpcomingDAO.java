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

    public Optional<Cricket_UpComing> updateMatch(int id, Cricket_UpComing updatedMatch) {
        return cricketUpcomingRepo.findById(id).map(existingMatch -> {
            existingMatch.setTeam1(updatedMatch.getTeam1());
            existingMatch.setTeam2(updatedMatch.getTeam2());
            existingMatch.setStadium(updatedMatch.getStadium());
            existingMatch.setDate(updatedMatch.getDate());
            existingMatch.setTime(updatedMatch.getTime());
            existingMatch.setSportType(updatedMatch.getSportType());
            existingMatch.setTeam1Logo(updatedMatch.getTeam1Logo());
            existingMatch.setTeam2Logo(updatedMatch.getTeam2Logo());
            existingMatch.setTeam1Players(updatedMatch.getTeam1Players());
            existingMatch.setTeam2Players(updatedMatch.getTeam2Players());
            return cricketUpcomingRepo.save(existingMatch);
        });
    }
}
