package com.example.endtermapi.patterns;

import com.example.endtermapi.model.Player;

public class PlayerBuilder {

    private String name;
    private int age;
    private String position;
    private int number;

    public PlayerBuilder name(String name) {
        this.name = name;
        return this;
    }

    public PlayerBuilder age(int age) {
        this.age = age;
        return this;
    }

    public PlayerBuilder position(String position) {
        this.position = position;
        return this;
    }


    public PlayerBuilder number(int number) {
        this.number = number;
        return this;
    }

    public Player build() {

        return new Player(name, age, position, number);
    }
}
