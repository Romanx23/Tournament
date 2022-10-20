package ru.netology.domain;

import lombok.*;

@AllArgsConstructor

public class Player {
    public String getName() {
        return name;
    }

    public int getStrength() {
        return strength;
    }

    private int id;
    private String name;
    private int strength;

}