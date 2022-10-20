package ru.netology.manager;

import ru.netology.domain.NotRegisteredException;
import ru.netology.domain.Player;

import java.util.ArrayList;
import java.util.List;

public class GameManager {

    private List<Player> players = new ArrayList<>();

    public void register(Player player) {
        this.players.add(player);

    }

    private Player findPlayer(String name) {
        for (Player player : players) {
            if (matches(player, name)) {
                return player;
            }
        }
        return null;
    }

    public boolean matches(Player player, String searchName) {
        if (player.getName().contains(searchName)) {
            return true;
        } else {
            return false;
        }
    }

    public int round(String playerName1, String playerName2) {
        Player player1 = findPlayer(playerName1);
        Player player2 = findPlayer(playerName2);
        if (player1 == null || player2 == null) {
            throw new NotRegisteredException(playerName1);
        }

        int result = player1.getStrength() - player2.getStrength();
        if (result > 0) {
            return 1;
        } else if (result < 0) {
            return 2;
        }
        return 0;
    }
}