package com.maplr.hockeyteam.service;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.maplr.hockeyteam.model.Player;
import com.maplr.hockeyteam.model.Team;
import com.maplr.hockeyteam.repository.PlayerRepository;
import com.maplr.hockeyteam.repository.TeamRepository;

@Configuration
public class TeamCommandLineRunner implements CommandLineRunner{
    
    @Autowired
    private TeamRepository teamRepository;
    @Autowired
    private PlayerRepository playerRepository;
    
    private final String TEAM_JSON = "/json/data.json";

    @Override
    public void run(String... args) throws Exception {
        
        //You can uncomment this method to Insert all players of /json/data.json in DB
        /*try {
            TypeReference<List<Team>> typeReference = new TypeReference<List<Team>>(){};
			InputStream inputStream = TypeReference.class.getResourceAsStream(TEAM_JSON);
			List<Team> team = new ObjectMapper().readValue(inputStream,typeReference);
			
            for (Team teams:team){
                playerRepository.saveAll(teams.getPlayers());
            }

            //teamRepository.saveAll(team);
			System.out.println("Users Saved!");
		} catch (IOException e){
			System.out.println("Unable to save users: " + e.getMessage());
		}*/
        
    }
}

