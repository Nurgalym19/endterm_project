package com.example.endtermapi.patterns;

import com.example.endtermapi.model.Player;

public class PlayerFactory {

    public static Player createPlayer(PlayerType type, String name, int age) {
        Player player = new Player();

        if (type == PlayerType.FOOTBALL) {
            player.setName(name + " (Football)");

        } else {
            throw new IllegalArgumentException("Unknown player type");
        }

        player.setAge(age);
        return player;
    }
}
