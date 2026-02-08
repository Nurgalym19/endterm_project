package com.example.endtermapi.patterns.factory;

public abstract class AbstractPlayer {

    protected String name;

    public abstract String getSport();

    public String getName() {
        return name;
    }
}
