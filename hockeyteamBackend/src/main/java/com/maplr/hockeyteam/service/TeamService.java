package com.maplr.hockeyteam.service;

import java.util.List;
import java.util.Optional;
import javax.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.maplr.hockeyteam.model.Team;
import com.maplr.hockeyteam.repository.TeamRepository;

@Service
public class TeamService {

    @Autowired
    private TeamRepository teamRepo;
    
    public Team GetTeam(Integer year) {

        Optional<Team> team = teamRepo.findByYear(year);
        
        if (!team.isPresent()) {
            throw new EntityNotFoundException();
        }

        return team.get();
    }
    
    public List<Team> GetAllTeam() {
        
        List<Team> team = teamRepo.findAll();
        
        if (team.size() == 0) {
            throw new EntityNotFoundException();
        }

        return team;
    }  
}
