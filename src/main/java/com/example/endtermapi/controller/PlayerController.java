package com.example.endtermapi.controller;

import com.example.endtermapi.model.Player;
import com.example.endtermapi.service.PlayerService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/players")
public class PlayerController {

    private final PlayerService playerService;

    public PlayerController(PlayerService playerService) {
        this.playerService = playerService;
    }

    @PostMapping
    public Player create(@RequestBody Player player) {
        return playerService.create(player);
    }

    @GetMapping
    public List<Player> getAll() {
        return playerService.getAll();
    }
    @GetMapping("/{id}")
    public Player getById(@PathVariable Long id) {
        return playerService.getById(id);
    }


    @PutMapping("/{id}")
    public Player update(@PathVariable Long id,
                         @RequestBody Player player) {
        return playerService.update(id, player);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        playerService.delete(id);
    }
}
