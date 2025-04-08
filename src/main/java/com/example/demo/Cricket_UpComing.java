package com.example.demo;

import jakarta.persistence.CascadeType;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

import java.util.ArrayList;
import java.util.List;

@Entity
public class Cricket_UpComing {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String team1;
    private String team2;
    private String stadium;
    private String date;
    private String time;
    private String sportType;
    

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Players> team1Players = new ArrayList<>();

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Players> team2Players = new ArrayList<>();

    // Getters and setters
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }
    public String getTeam1() { return team1; }
    public void setTeam1(String team1) { this.team1 = team1; }
    public String getTeam2() { return team2; }
    public void setTeam2(String team2) { this.team2 = team2; }
    public String getStadium() { return stadium; }
    public void setStadium(String stadium) { this.stadium = stadium; }
    public String getDate() { return date; }
    public void setDate(String date) { this.date = date; }
    public String getTime() { return time; }
    public void setTime(String time) { this.time = time; }
    public String getSportType() { return sportType; }
    public void setSportType(String sportType) { this.sportType = sportType; }
    public List<Players> getTeam1Players() { return team1Players; }
    public void setTeam1Players(List<Players> team1Players) { this.team1Players = team1Players; }
    public List<Players> getTeam2Players() { return team2Players; }
    public void setTeam2Players(List<Players> team2Players) { this.team2Players = team2Players; }
}
