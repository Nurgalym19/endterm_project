package com.example.endtermapi.service;

import com.example.endtermapi.model.Player;

import java.util.List;

public interface PlayerService {

    Player create(Player player);

    List<Player> getAll();

    Player getById(Long id);

    Player update(Long id, Player player);

    void delete(Long id);
}
