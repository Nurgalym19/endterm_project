package com.example.endtermapi.patterns.factory;

public class FootballPlayer extends AbstractPlayer {

    public FootballPlayer(String name) {
        this.name = name;
    }

    @Override
    public String getSport() {
        return "Football";
    }
}
