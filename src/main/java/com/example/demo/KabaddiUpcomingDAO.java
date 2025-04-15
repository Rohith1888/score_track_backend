package com.example.demo;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class KabaddiUpcomingDAO {

    @Autowired
    private KabaddiUpcoming_Repo kabaddiUpcomingRepo;

    public List<Kabaddi_UpComing> getAllMatches() {
        return kabaddiUpcomingRepo.findAll();
    }

    public Kabaddi_UpComing addMatch(Kabaddi_UpComing match) {
        return kabaddiUpcomingRepo.save(match);
    }

    public Optional<Kabaddi_UpComing> getMatchById(int id) {
        return kabaddiUpcomingRepo.findById(id);
    }
}
