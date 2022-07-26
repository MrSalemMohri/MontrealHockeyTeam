package com.maplr.hockeyteam.repository;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import com.maplr.hockeyteam.model.Team;

public interface TeamRepository extends JpaRepository<Team, Integer>{

    Optional <Team> findByYear(Integer year);
    
}
