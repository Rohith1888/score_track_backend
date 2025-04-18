package com.example.demo;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class BowlingStats {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String playerName;
    private double overs;
    private int maidens;
    private int runs;
    private int wickets;
    private double economy;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getPlayerName() {
		return playerName;
	}
	public void setPlayerName(String playerName) {
		this.playerName = playerName;
	}
	public double getOvers() {
		return overs;
	}
	public void setOvers(double overs) {
		this.overs = overs;
	}
	public int getMaidens() {
		return maidens;
	}
	public void setMaidens(int maidens) {
		this.maidens = maidens;
	}
	public int getRuns() {
		return runs;
	}
	public void setRuns(int runs) {
		this.runs = runs;
	}
	public int getWickets() {
		return wickets;
	}
	public void setWickets(int wickets) {
		this.wickets = wickets;
	}
	public double getEconomy() {
		return economy;
	}
	public void setEconomy(double economy) {
		this.economy = economy;
	}

    // Getters and setters
}
