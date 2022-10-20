package ru.netology.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.netology.manager.GameManager;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class GameTest {

    private GameManager game = new GameManager();
    private Player player1 = new Player(1, "Petya", 100);
    private Player player2 = new Player(2, "Vasya", 50);
    private Player player3 = new Player(3, "Ivan", 150);
    private Player player4 = new Player(4, "Oleg", 100);

    @BeforeEach
    void setPlayer() {
        game.register(player1);
        game.register(player2);
        game.register(player4);

    }

    @Test
    void roundWhenFirstStrongerThenSecond() {
        int actual = game.round(player1.getName(), player2.getName());

        assertEquals(1, actual);
    }

    @Test
    void roundWhenSecondStrongerThenFirst() {
        int actual = game.round(player2.getName(), player4.getName());

        assertEquals(2, actual);
    }

    @Test
    void roundWhenDraw() {
        int actual = game.round(player1.getName(), player4.getName());

        assertEquals(0, actual);
    }

    @Test
    void roundWhenPlayerUnregistered() {
        assertThrows(NotRegisteredException.class,
                () -> game.round(player1.getName(), player3.getName()));

    }

    @Test
    void roundWhenPlayerUnregistered2() {
        assertThrows(NotRegisteredException.class,
                () -> game.round(player3.getName(), player4.getName()));

    }

}