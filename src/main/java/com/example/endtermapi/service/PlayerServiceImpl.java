package com.example.endtermapi.service;

import com.example.endtermapi.Cache.PlayerCache;
import com.example.endtermapi.exception.PlayerNotFoundException;
import com.example.endtermapi.model.Player;
import com.example.endtermapi.model.Team;
import com.example.endtermapi.repository.PlayerRepository;
import com.example.endtermapi.repository.TeamRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PlayerServiceImpl implements PlayerService {

    private static final Logger log =
            LoggerFactory.getLogger(PlayerServiceImpl.class);
    private final PlayerRepository playerRepository;
    private final TeamRepository teamRepository;
    private final PlayerCache playerCache = PlayerCache.getInstance();

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

        Player saved = playerRepository.save(player);
        playerCache.clear();
        log.info("CACHE CLEARED AFTER CREATE");

        return saved;
    }
    @Override
    public List<Player> getAll() {

        List<Player> cachedPlayers = playerCache.get("players");

        if (cachedPlayers != null) {
            log.info("PLAYERS FROM CACHE");
            return cachedPlayers;
        }

        log.info("PLAYERS FROM DATABASE");
        List<Player> players = playerRepository.findAll();
        playerCache.put("players", players);

        return players;
    }
    @Override
    public Player getById(Long id) {
        return playerRepository.findById(id)
                .orElseThrow(() -> new PlayerNotFoundException(id));
    }
    @Override
    public Player update(Long id, Player player) {

        Player existing = getById(id);

        existing.setName(player.getName());
        existing.setAge(player.getAge());
        existing.setPosition(player.getPosition());
        existing.setNumber(player.getNumber());

        if (player.getTeam() != null && player.getTeam().getId() != null) {
            Team team = teamRepository.findById(player.getTeam().getId())
                    .orElseThrow(() -> new RuntimeException("Team not found"));
            existing.setTeam(team);
        }
        Player updated = playerRepository.save(existing);
        playerCache.clear();
        log.info("CACHE CLEARED AFTER UPDATE");

        return updated;
    }
    @Override
    public void delete(Long id) {
        playerRepository.deleteById(id);

        playerCache.clear();
        log.info("CACHE CLEARED AFTER DELETE");
    }
}
