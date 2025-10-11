/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ca.sheridancollege.project;
import java.util.ArrayList;
import java.util.Collections;

/**
 *
 * @author sandh
 */
public class Deck extends GroupOfCards{
    public Deck() {
        super(52);
        super.cards = new ArrayList<>();

        String[] suits = {"Hearts", "Diamonds", "Clubs", "Spades"};

        for (String suit : suits) {
            for (int rank = 2; rank <= 13; rank++) {
                super.cards.add(new WarCard(rank, suit));
            }
        }

        shuffle(); // now works
    }

    @Override
    public void shuffle() {
        Collections.shuffle(cards); // requires import
    }
}
