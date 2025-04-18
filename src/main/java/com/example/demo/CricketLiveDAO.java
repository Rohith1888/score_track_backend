package com.example.demo;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CricketLiveDAO {

    @Autowired
    private LiveCricketMatchRepo liveCricketMatchRepo;

    // Get all live matches
    public List<LiveCricketMatch> getAllLiveMatches() {
        return liveCricketMatchRepo.findAll();
    }

    // Add a new live match
    public LiveCricketMatch addLiveMatch(LiveCricketMatch match) {
        return liveCricketMatchRepo.save(match);
    }

    // Get a live match by ID
    public Optional<LiveCricketMatch> getLiveMatchById(int id) {
        return liveCricketMatchRepo.findById(id);
    }

    // Update the score of a live match
    public Optional<LiveCricketMatch> updateScore(int matchId, String team1Score, String team2Score, String matchDecision) {
        Optional<LiveCricketMatch> optionalMatch = liveCricketMatchRepo.findById(matchId);
        
        if (optionalMatch.isPresent()) {
            LiveCricketMatch match = optionalMatch.get();
            match.setTeam1Score(team1Score);
            match.setTeam2Score(team2Score);
            match.setMatchDecision(matchDecision);
            liveCricketMatchRepo.save(match);  // Save the updated match object
        }

        return optionalMatch;  // Return the updated match
    }

    // Update Batting Stats for a player
    public Optional<LiveCricketMatch> updateBattingStats(int matchId, int teamNumber, String playerName, int runs, int balls, int fours, int sixes, double strikeRate) {
        Optional<LiveCricketMatch> optionalMatch = liveCricketMatchRepo.findById(matchId);

        if (optionalMatch.isPresent()) {
            LiveCricketMatch match = optionalMatch.get();

            if (teamNumber == 1) {
                // Update team 1 batting stats
                match.getTeam1BattingStats().forEach(battingStat -> {
                    if (battingStat.getPlayerName().equals(playerName)) {
                        battingStat.setRuns(runs);
                        battingStat.setBalls(balls);
                        battingStat.setFours(fours);
                        battingStat.setSixes(sixes);
                        battingStat.setStrikeRate(strikeRate);
                    }
                });
            } else {
                // Update team 2 batting stats
                match.getTeam2BattingStats().forEach(battingStat -> {
                    if (battingStat.getPlayerName().equals(playerName)) {
                        battingStat.setRuns(runs);
                        battingStat.setBalls(balls);
                        battingStat.setFours(fours);
                        battingStat.setSixes(sixes);
                        battingStat.setStrikeRate(strikeRate);
                    }
                });
            }

            liveCricketMatchRepo.save(match);  // Save the updated match object
        }

        return optionalMatch;  // Return the updated match
    }

    // Update Bowling Stats for a player
    public Optional<LiveCricketMatch> updateBowlingStats(int matchId, int teamNumber, String playerName, double overs, int maidens, int runs, int wickets, double economy) {
        Optional<LiveCricketMatch> optionalMatch = liveCricketMatchRepo.findById(matchId);

        if (optionalMatch.isPresent()) {
            LiveCricketMatch match = optionalMatch.get();

            if (teamNumber == 1) {
                // Update team 1 bowling stats
                match.getTeam1BowlingStats().forEach(bowlingStat -> {
                    if (bowlingStat.getPlayerName().equals(playerName)) {
                        bowlingStat.setOvers(overs);
                        bowlingStat.setMaidens(maidens);
                        bowlingStat.setRuns(runs);
                        bowlingStat.setWickets(wickets);
                        bowlingStat.setEconomy(economy);
                    }
                });
            } else {
                // Update team 2 bowling stats
                match.getTeam2BowlingStats().forEach(bowlingStat -> {
                    if (bowlingStat.getPlayerName().equals(playerName)) {
                        bowlingStat.setOvers(overs);
                        bowlingStat.setMaidens(maidens);
                        bowlingStat.setRuns(runs);
                        bowlingStat.setWickets(wickets);
                        bowlingStat.setEconomy(economy);
                    }
                });
            }

            liveCricketMatchRepo.save(match);  // Save the updated match object
        }

        return optionalMatch;  // Return the updated match
    }
 // Update entire match object
    public Optional<LiveCricketMatch> updateLiveMatch(int matchId, LiveCricketMatch updatedMatch) {
        Optional<LiveCricketMatch> optionalMatch = liveCricketMatchRepo.findById(matchId);

        if (optionalMatch.isPresent()) {
            LiveCricketMatch existingMatch = optionalMatch.get();

            // Update fields (you can customize this based on your entity fields)
            existingMatch.setTeam1(updatedMatch.getTeam1());
            existingMatch.setTeam2(updatedMatch.getTeam2());
            existingMatch.setTeam1Score(updatedMatch.getTeam1Score());
            existingMatch.setTeam2Score(updatedMatch.getTeam2Score());
            existingMatch.setMatchDecision(updatedMatch.getMatchDecision());
            existingMatch.setTeam1BattingStats(updatedMatch.getTeam1BattingStats());
            existingMatch.setTeam2BattingStats(updatedMatch.getTeam2BattingStats());
            existingMatch.setTeam1BowlingStats(updatedMatch.getTeam1BowlingStats());
            existingMatch.setTeam2BowlingStats(updatedMatch.getTeam2BowlingStats());

            liveCricketMatchRepo.save(existingMatch);  // Save the updated match
        }

        return optionalMatch;
    }
 // Delete a match by ID
    public boolean deleteMatchById(int matchId) {
        if (liveCricketMatchRepo.existsById(matchId)) {
            liveCricketMatchRepo.deleteById(matchId);
            return true;  // Successfully deleted
        }
        return false;  // Match not found
    }


}
