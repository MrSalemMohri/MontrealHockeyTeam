package com.maplr.hockeyteam.service;

import java.util.ArrayList;
import java.util.Optional;
import javax.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.maplr.hockeyteam.model.Player;
import com.maplr.hockeyteam.model.Team;
import com.maplr.hockeyteam.repository.PlayerRepository;
import com.maplr.hockeyteam.repository.TeamRepository;

@Service
public class PlayerService {

    @Autowired
    private PlayerRepository playerRepo;
    @Autowired
    private TeamRepository teamRepo;

    public Player createPlayer(Integer year ,Player newPlayer) {

        Optional<Team> team = teamRepo.findByYear(year);

        if (!team.isPresent()) {
            throw new EntityNotFoundException();
        }

        newPlayer.setTeams(new ArrayList<>());
        newPlayer.getTeams().add(team.get());
        Player player = playerRepo.save(newPlayer);

        return player;
    }

    public Player updatePlayer(Integer id) {

        Player player = playerRepo.findById(id).orElseThrow();
        player.setIs_captain(true);
        final Player updatedplayer = playerRepo.save(player);

        return updatedplayer;
    }
    
}
