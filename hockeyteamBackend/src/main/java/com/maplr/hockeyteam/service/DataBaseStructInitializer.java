package com.maplr.hockeyteam.service;
 
import javax.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
 
@Service
public class DataBaseStructInitializer {
 
    @Autowired
    private JdbcTemplate jdbcTemplate;
    
    @PostConstruct
    public void createDbStruct() {
        String sql = "CREATE SEQUENCE IF NOT EXISTS player_sequence; CREATE SEQUENCE IF NOT EXISTS team_sequence; CREATE SEQUENCE IF NOT EXISTS playerteam_sequence; CREATE TABLE IF NOT EXISTS teams (id serial PRIMARY KEY, coach TEXT NOT NULL, year INT NOT NULL UNIQUE); CREATE TABLE IF NOT EXISTS players (id serial PRIMARY KEY, number INT DEFAULT NULL, name TEXT DEFAULT NULL, lastname TEXT DEFAULT NULL, position TEXT DEFAULT NULL, is_captain boolean DEFAULT false); CREATE TABLE IF NOT EXISTS player_team (id serial PRIMARY KEY, player_id int REFERENCES players(id) ON DELETE CASCADE, team_id int REFERENCES teams(id) ON DELETE CASCADE);";
         
        int rows = jdbcTemplate.update(sql);
        if (rows > 0) {
            System.out.println("A new row has been inserted.");
        }
    }
 
}