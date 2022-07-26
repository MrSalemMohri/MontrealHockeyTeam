package com.maplr.hockeyteam.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.maplr.hockeyteam.model.PlayerTeam;

public interface PlayerTeamRepository extends JpaRepository<PlayerTeam, Integer>{
    
}
