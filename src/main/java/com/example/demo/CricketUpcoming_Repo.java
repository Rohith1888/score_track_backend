package com.example.demo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CricketUpcoming_Repo extends JpaRepository<Cricket_UpComing, Integer> {
	
	Optional<Cricket_UpComing> findById(Integer id);

	
}
