package com.maplr.hockeyteam.model;

import javax.persistence.Entity;
import javax.persistence.Table;
import lombok.Data;
import javax.persistence.*;

@Entity
@Table(name = "player_team")
@Data
public class PlayerTeam {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "playerteam_generator")
    @SequenceGenerator(name = "playerteam_generator", sequenceName = "playerteam_sequence", allocationSize = 1)
    private Integer id;
    @ManyToOne
    @MapsId("player_id")
    private Player player;
    @ManyToOne
    @MapsId("team_id")
    private Team team;
}