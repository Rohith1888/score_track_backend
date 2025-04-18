package com.example.demo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Batting_StatsRepo extends JpaRepository<Batting_Stats, Integer> {
    Optional<Batting_Stats> findById(int id);
}

