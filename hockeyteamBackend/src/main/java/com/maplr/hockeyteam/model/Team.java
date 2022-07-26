package com.maplr.hockeyteam.model;

import javax.persistence.Entity;
import javax.persistence.Table;
import lombok.Data;
import java.util.List;
import javax.persistence.*;

@Entity
@Table(name = "teams")
@Data
public class Team {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "team_generator")
    @SequenceGenerator(name = "team_generator", sequenceName = "team_sequence", allocationSize = 1)
    @Column(name = "id")
    private Integer id;
    @Column(name = "coach")
    private String coach;
    @Column(name = "year")
    private Integer year;
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "player_team", 
            joinColumns = { @JoinColumn(name = "team_id") },
            inverseJoinColumns = { @JoinColumn(name = "player_id") })
    private List <Player> players;

}
