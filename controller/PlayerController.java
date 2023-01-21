package com.example.secondapp.secondapplication.controller;

import com.example.secondapp.secondapplication.model.Player;
import com.example.secondapp.secondapplication.service.PlayerService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/players")
public class PlayerController {
    private PlayerService playerService;

    public PlayerController(PlayerService playerService) {
        this.playerService = playerService;
    }
    @PostMapping()
    public ResponseEntity<Player> savePlayer(@RequestBody Player player){
        return new ResponseEntity<Player>(playerService.savePlayer(player), HttpStatus.CREATED);
    }
    @GetMapping
    public List<Player> getAllPlayers(){
        return playerService.getAllPlayers();
    }
    @GetMapping("{jersey}")
    public ResponseEntity<Player> getPlayerByJersey(@PathVariable("jersey") Integer id){
        return new ResponseEntity<Player>(playerService.getPlayerByJersey(id), HttpStatus.OK);

    }
    @PutMapping("{jersey}")
    public ResponseEntity<Player> updatePlayer(@PathVariable("jersey")Integer id, @RequestBody Player player)
    {
        return new ResponseEntity<>(playerService.updatePlayer(player,id), HttpStatus.OK);
    }
    @DeleteMapping("{jersey}")
    public ResponseEntity<String> deletePlayer(@PathVariable("jersey")Integer id){
        playerService.deletePlayer(id);
        return new ResponseEntity<String>("Player Deleted", HttpStatus.OK);
    }
}
