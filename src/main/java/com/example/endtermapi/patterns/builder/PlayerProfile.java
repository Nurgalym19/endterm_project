package com.example.endtermapi.patterns.builder;

public class PlayerProfile {

    private final String name;
    private final int age;
    private final String position;
    private final int number;

    private PlayerProfile(Builder builder) {
        this.name = builder.name;
        this.age = builder.age;
        this.position = builder.position;
        this.number = builder.number;
    }

    public static class Builder {

        private String name;
        private int age;
        private String position;
        private int number;

        public Builder name(String name) {
            this.name = name;
            return this;
        }

        public Builder age(int age) {
            this.age = age;
            return this;
        }

        public Builder position(String position) {
            this.position = position;
            return this;
        }

        public Builder number(int number) {
            this.number = number;
            return this;
        }

        public PlayerProfile build() {
            return new PlayerProfile(this);
        }
    }
}
