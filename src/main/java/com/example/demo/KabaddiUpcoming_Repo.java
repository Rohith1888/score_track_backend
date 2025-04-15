package com.example.demo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface KabaddiUpcoming_Repo extends JpaRepository<Kabaddi_UpComing, Integer> {

    Optional<Kabaddi_UpComing> findById(Integer id);

}
