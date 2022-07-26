package com.maplr.hockeyteam.model;

import javax.persistence.Entity;
import javax.persistence.Table;
import lombok.Data;
import java.util.List;
import javax.persistence.*;

@Entity
@Table(name = "players")
@Data
public class Player {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "player_generator")
    @SequenceGenerator(name = "player_generator", sequenceName = "player_sequence", allocationSize = 1)
    @Column(name = "id")
    private Integer id;
    @Column(name = "number")
    private Integer number;
    @Column(name = "name")
    private String name;
    @Column(name = "lastname")
    private String lastname;
    @Column(name = "position")
    private String position;
    @Column(name = "is_captain")
    private Boolean is_captain; 
    @ManyToMany
    @JoinTable(name = "player_team", 
            joinColumns = { @JoinColumn(name = "player_id") }, 
            inverseJoinColumns = { @JoinColumn(name = "team_id") })
    private List <Team> teams;

}