package com.example.demo;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class LiveCricketMatch {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    private String stadium;
    private String date;
    private String team1;
    private String team2;
    private String team1Score;
    private String team2Score;
    private String matchDecision;
    private String team1Logo;
    private String team2Logo;
    private boolean isLive = true;

    public boolean isLive() {
		return isLive;
	}

	public void setLive(boolean isLive) {
		this.isLive = isLive;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<Batting_Stats> team1BattingStats = new ArrayList<>();

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<BowlingStats> team1BowlingStats = new ArrayList<>();

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<Batting_Stats> team2BattingStats = new ArrayList<>();

    public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getStadium() {
		return stadium;
	}

	public void setStadium(String stadium) {
		this.stadium = stadium;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getTeam1() {
		return team1;
	}

	public void setTeam1(String team1) {
		this.team1 = team1;
	}

	public String getTeam2() {
		return team2;
	}

	public void setTeam2(String team2) {
		this.team2 = team2;
	}

	public String getTeam1Score() {
		return team1Score;
	}

	public void setTeam1Score(String team1Score) {
		this.team1Score = team1Score;
	}

	public String getTeam2Score() {
		return team2Score;
	}

	public void setTeam2Score(String team2Score) {
		this.team2Score = team2Score;
	}

	public String getMatchDecision() {
		return matchDecision;
	}

	public void setMatchDecision(String matchDecision) {
		this.matchDecision = matchDecision;
	}

	public String getTeam1Logo() {
		return team1Logo;
	}

	public void setTeam1Logo(String team1Logo) {
		this.team1Logo = team1Logo;
	}

	public String getTeam2Logo() {
		return team2Logo;
	}

	public void setTeam2Logo(String team2Logo) {
		this.team2Logo = team2Logo;
	}

	public List<Batting_Stats> getTeam1BattingStats() {
		return team1BattingStats;
	}

	public void setTeam1BattingStats(List<Batting_Stats> team1BattingStats) {
		this.team1BattingStats = team1BattingStats;
	}

	public List<BowlingStats> getTeam1BowlingStats() {
		return team1BowlingStats;
	}

	public void setTeam1BowlingStats(List<BowlingStats> team1BowlingStats) {
		this.team1BowlingStats = team1BowlingStats;
	}

	public List<Batting_Stats> getTeam2BattingStats() {
		return team2BattingStats;
	}

	public void setTeam2BattingStats(List<Batting_Stats> team2BattingStats) {
		this.team2BattingStats = team2BattingStats;
	}

	public List<BowlingStats> getTeam2BowlingStats() {
		return team2BowlingStats;
	}

	public void setTeam2BowlingStats(List<BowlingStats> team2BowlingStats) {
		this.team2BowlingStats = team2BowlingStats;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<BowlingStats> team2BowlingStats = new ArrayList<>();

    // Add getters and setters
}
