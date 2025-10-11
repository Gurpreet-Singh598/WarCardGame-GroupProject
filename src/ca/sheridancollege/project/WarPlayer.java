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
public class WarPlayer extends Player{
    private ArrayList<WarCard> hand;

    public WarPlayer(String name) {
        super(name);
        hand = new ArrayList<>();
    }

    public ArrayList<WarCard> getHand() {
        return hand;
    }

    public void addCard(WarCard card) {
        hand.add(card);
    }

    public WarCard drawCard() {
        if (!hand.isEmpty()) {
            return hand.remove(0); // draw the top card
        }
        return null;
    }

    @Override
    public void play() {
        // In War, play logic is handled in Game class
        // This method can remain empty or just draw a card
    }

    public int getHandSize() {
        return hand.size();
    }
}
