package com.maplr.hockeyteam.model.dto;

import com.maplr.hockeyteam.model.Player;
import lombok.Data;

@Data
public class PlayerDto {

    private Integer id;
    private Integer number;
    private String name;
    private String lastname;
    private String position;
    private Boolean is_captain;

    public PlayerDto (Player player){
        this.id = player.getId();
        this.number = player.getNumber();
        this.name = player.getName();
        this.lastname = player.getLastname();
        this.position = player.getPosition();
        this.is_captain = player.getIs_captain();
    }
}
