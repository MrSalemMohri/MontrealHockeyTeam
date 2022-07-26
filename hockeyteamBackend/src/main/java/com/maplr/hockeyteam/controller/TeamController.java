package com.maplr.hockeyteam.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import com.maplr.hockeyteam.model.Team;
import com.maplr.hockeyteam.model.dto.TeamDto;
import com.maplr.hockeyteam.service.TeamService;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class TeamController {

    @Autowired
    private TeamService teamService;
       
    @GetMapping(path = "/api/team", produces = "application/json")
    public List<TeamDto> GetAllTeam() {
        return teamService.GetAllTeam().stream().map(team -> new TeamDto(team)).collect(Collectors.toList());
    }

    @GetMapping(path = "/api/team/{year}", produces = "application/json")
    public ResponseEntity<TeamDto> listPlayersTeam(@PathVariable Integer year) {
        Team team = teamService.GetTeam(year);
        return new ResponseEntity<>(new TeamDto(team), HttpStatus.OK);
    }
    
}