package com.example.demo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LiveCricketMatchRepo extends JpaRepository<LiveCricketMatch, Integer> {

    Optional<LiveCricketMatch> findById(Integer id);
    
}
