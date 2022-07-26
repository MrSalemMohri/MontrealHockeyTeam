package com.maplr.hockeyteam.controller;

import javax.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import com.maplr.hockeyteam.model.Player;
import com.maplr.hockeyteam.model.dto.PlayerDto;
import com.maplr.hockeyteam.service.PlayerService;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class PlayerController {

    @Autowired
    private PlayerService playerService;
       
    @PostMapping(path = "/api/team/{year}", consumes = "application/json", produces = "application/json")
    public ResponseEntity<PlayerDto> createPlayer(@PathVariable Integer year,@RequestBody Player newPlayer) {
        Player player = playerService.createPlayer(year, newPlayer);
        return new ResponseEntity<>(new PlayerDto(player), HttpStatus.CREATED);
    }

    @PutMapping("/api/player/{id}/captain")
    public ResponseEntity<PlayerDto> updateEmployee(@PathVariable Integer id) {;
        Player updatedplayer = playerService.updatePlayer(id);
        return new ResponseEntity<>(new PlayerDto(updatedplayer), HttpStatus.OK);
    }

    @ExceptionHandler({ EntityNotFoundException.class })
    public ResponseEntity<Object> handleAccessDeniedException(
      Exception ex, WebRequest request) {
        return new ResponseEntity<Object>(
          "Entity Not Found", new HttpHeaders(), HttpStatus.NOT_FOUND);
    }
}