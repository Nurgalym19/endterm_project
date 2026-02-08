package com.example.endtermapi.factory;

import com.example.endtermapi.model.Player;

public class PlayerFactory {
    public static Player createPlayer(String name, int age, String position,int number) {
        return new Player(name, age, position,number);
    }
}
