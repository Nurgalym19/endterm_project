package com.example.endtermapi.repository;

import com.example.endtermapi.model.Player;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PlayerRepository extends JpaRepository<Player, Long> {
}
