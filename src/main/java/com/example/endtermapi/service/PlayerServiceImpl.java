package com.example.endtermapi.service;

import com.example.endtermapi.exception.PlayerNotFoundException;
import com.example.endtermapi.model.Player;
import com.example.endtermapi.model.Team;
import com.example.endtermapi.repository.PlayerRepository;
import com.example.endtermapi.repository.TeamRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PlayerServiceImpl implements PlayerService {

    private final PlayerRepository playerRepository;
    private final TeamRepository teamRepository;

    public PlayerServiceImpl(PlayerRepository playerRepository,
                             TeamRepository teamRepository) {
        this.playerRepository = playerRepository;
        this.teamRepository = teamRepository;
    }

    @Override
    public Player create(Player player) {

        if (player.getTeam() != null && player.getTeam().getId() != null) {
            Team team = teamRepository.findById(player.getTeam().getId())
                    .orElseThrow(() -> new RuntimeException("Team not found"));
            player.setTeam(team);
        }

        return playerRepository.save(player);
    }

    @Override
    public List<Player> getAll() {
        return playerRepository.findAll();
    }

    @Override
    public Player getById(Long id) {
        return playerRepository.findById(id)
                .orElseThrow(() -> new PlayerNotFoundException(id));
    }

    @Override
    public Player update(Long id, Player player) {
        Player existing = getById(id);
        existing.setNumber(player.getNumber());

        existing.setName(player.getName());
        existing.setAge(player.getAge());
        existing.setPosition(player.getPosition());
        if (player.getTeam() != null && player.getTeam().getId() != null) {
            Team team = teamRepository.findById(player.getTeam().getId())
                    .orElseThrow(() -> new RuntimeException("Team not found"));
            existing.setTeam(team);
        }

        return playerRepository.save(existing);
    }

    @Override
    public void delete(Long id) {
        playerRepository.deleteById(id);
    }
}
