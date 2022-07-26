package com.maplr.hockeyteam.repository;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import com.maplr.hockeyteam.model.Player;

public interface PlayerRepository extends JpaRepository<Player, Integer> {

    Optional<Player> findById (Integer id);

}
