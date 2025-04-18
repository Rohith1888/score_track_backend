package com.example.demo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BowlingStatsRepo extends JpaRepository<BowlingStats, Integer> {
    Optional<BowlingStats> findById(int id);
}
