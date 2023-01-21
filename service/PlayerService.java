package com.example.secondapp.secondapplication.service;

import com.example.secondapp.secondapplication.model.Player;
import org.hibernate.id.IntegralDataTypeHolder;

import java.util.List;

public interface PlayerService {
    Player savePlayer(Player player);
    List<Player> getAllPlayers();
    Player getPlayerByJersey(Integer jersey);
    Player updatePlayer(Player player, Integer jersey);
    void deletePlayer(Integer jersey);
}
