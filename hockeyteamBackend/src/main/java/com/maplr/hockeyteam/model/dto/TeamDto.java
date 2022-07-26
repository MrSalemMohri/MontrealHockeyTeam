package com.maplr.hockeyteam.model.dto;

import java.util.List;
import java.util.stream.Collectors;
import com.maplr.hockeyteam.model.Team;

import lombok.Data;

@Data
public class TeamDto {

    private Integer id;
    private String coach;
    private Integer year;
    private List <PlayerDto> players;

     public TeamDto (Team team){
        this.id = team.getId();
        this.coach = team.getCoach();
        this.year = team.getYear();
        this.players = team.getPlayers().stream().map(player -> new PlayerDto(player)).collect(Collectors.toList());
     }
    
}
