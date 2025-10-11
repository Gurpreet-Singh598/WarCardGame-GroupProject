/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ca.sheridancollege.project;

import java.util.ArrayList;

/**
 * Controls the flow of the War card game.
 */
public class WarGame extends Game {

    private Deck deck;

    public WarGame(String name) {
        super(name);
        deck = new Deck();
        deck.shuffle();
    }

    @Override
    public void play() {
        ArrayList<Player> players = getPlayers();
        if (players.size() != 2) {
            System.out.println(" War requires exactly 2 players.");
            return;
        }

        WarPlayer player1 = (WarPlayer) players.get(0);
        WarPlayer player2 = (WarPlayer) players.get(1);

        // Deal cards alternately
        boolean turn = true;
        for (Card card : deck.getCards()) {
            if (turn) player1.addCard((WarCard) card);
            else player2.addCard((WarCard) card);
            turn = !turn;
        }

        System.out.println("Game starts between " + player1.getName() + " and " + player2.getName() + "!\n");

        int round = 0;
        int maxRounds = 200; // prevent infinite loop

        while (player1.getHandSize() > 0 && player2.getHandSize() > 0 && round < maxRounds) {
            WarCard c1 = player1.drawCard();
            WarCard c2 = player2.drawCard();

            System.out.println("Round " + (round + 1));
            System.out.println(player1.getName() + " plays: " + c1);
            System.out.println(player2.getName() + " plays: " + c2);

            if (c1.getRank() > c2.getRank()) {
                player1.addCard(c1);
                player1.addCard(c2);
                System.out.println(  player1.getName() + " wins the round!\n");
            } else if (c2.getRank() > c1.getRank()) {
                player2.addCard(c1);
                player2.addCard(c2);
                System.out.println(player2.getName() + " wins the round!\n");
            } else {
                // Tie — both keep their cards (simple version)
                player1.addCard(c1);
                player2.addCard(c2);
                System.out.println("️ Round is a tie!\n");
            }

            round++;
        }
    }

    @Override
    public void declareWinner() {
        ArrayList<Player> players = getPlayers();
        if (players.size() != 2) return;

        WarPlayer player1 = (WarPlayer) players.get(0);
        WarPlayer player2 = (WarPlayer) players.get(1);

        System.out.println("Game Over!");
        System.out.println(player1.getName() + " has " + player1.getHandSize() + " cards.");
        System.out.println(player2.getName() + " has " + player2.getHandSize() + " cards.");

        if (player1.getHandSize() > player2.getHandSize()) {
            System.out.println("Winner: " + player1.getName());
        } else if (player2.getHandSize() > player1.getHandSize()) {
            System.out.println("Winner: " + player2.getName());
        } else {
            System.out.println("It's a tie!");
        }
    }
}

