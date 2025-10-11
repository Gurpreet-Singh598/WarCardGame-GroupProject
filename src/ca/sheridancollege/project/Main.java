/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ca.sheridancollege.project;

import java.util.ArrayList;

/**
 *
 * @author sandh
 */
public class Main {
        public static void main(String[] args) {
        WarGame game = new WarGame("Classic War");

        ArrayList<Player> players = new ArrayList<>();
        players.add(new WarPlayer("Alice"));
        players.add(new WarPlayer("Bob"));

        game.setPlayers(players);

        game.play();
        game.declareWinner();
    }
}
