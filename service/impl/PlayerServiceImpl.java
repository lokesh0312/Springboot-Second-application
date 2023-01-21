package com.example.secondapp.secondapplication.service.impl;

import com.example.secondapp.secondapplication.exception.ResourceNotFoundException;
import com.example.secondapp.secondapplication.model.Player;
import com.example.secondapp.secondapplication.repository.PlayerRepository;
import com.example.secondapp.secondapplication.service.PlayerService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PlayerServiceImpl implements PlayerService {
    private PlayerRepository playerRepository;

    public PlayerServiceImpl(PlayerRepository playerRepository) {
        this.playerRepository = playerRepository;
    }

    @Override
    public Player savePlayer(Player player) {

        return playerRepository.save(player);
    }

    @Override
    public List<Player> getAllPlayers() {
        return playerRepository.findAll();
    }

    @Override
    public Player getPlayerByJersey(Integer jersey) {
       Optional<Player> player =playerRepository.findById(jersey);
       if(player.isPresent()){
           return player.get();
       }
       else{
           throw new ResourceNotFoundException("Product", "ID", "id");
       }
    }

    @Override
    public Player updatePlayer(Player player, Integer jersey) {
        Player existingPlayer=playerRepository.findById(jersey).orElseThrow(
                ()->new ResourceNotFoundException("Product", "ID", "id")
        );
        existingPlayer.setFirstName(player.getFirstName());
        existingPlayer.setLastName(player.getLastName());
        existingPlayer.setTeamName(player.getTeamName());
        playerRepository.save(existingPlayer);
        return existingPlayer;
    }

    @Override
    public void deletePlayer(Integer jersey) {
        playerRepository.findById(jersey).orElseThrow(
                ()->new ResourceNotFoundException("Product", "ID", "id"));
        playerRepository.deleteById(jersey);
    }
}
