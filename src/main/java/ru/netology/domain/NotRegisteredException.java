package ru.netology.domain;

public class NotRegisteredException extends RuntimeException {
    public NotRegisteredException(String name) {
        super("one of the players is not registered");
    }
}
