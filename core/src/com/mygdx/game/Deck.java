package com.mygdx.game;

import com.badlogic.gdx.utils.Pool;
import com.mygdx.game.Cards.Card;

import java.util.List;
import java.util.Random;

public class Deck {
    private List<Card> cards;
    private Pool<Card> cardPool;

    public Deck(Pool<Card> cardPool) {
        this.cardPool = cardPool;
    }

    public int getCurrentDeckSize(){
        return cards.size();
    }

    public void addCard(Card newCard){
        cards.add(newCard);
    }
    public void destroyCard(int index){
        cards.remove(index);
    }
    public void shuffleDeck(){
        //puts random cards at the end of the deck 30 size times
        Random random = new Random();
        int low = 0;
        int high = cards.size();

        for (int i = 0; i < high; i++) {
            int x = random.nextInt(high - low) + low;
            Card card = cards.get(x);
            cards.remove(x);
            cards.add(card);

        }
    }

    public void sortByCost(){
        int startSize = cards.size();
        for (int i = 0; i < cards.size(); i++) {
            int x = cards.get(i).getCost();
            int y = cards.get(i + 1).getCost();
            if (x > y){
                Card card = cards.get(i + 1);
                cards.add(i + 1, cards.get(i));
                cards.add(i, card);
            }
            if (!(cards.size() == startSize)){
                System.out.println("Error in sort, cards where added in process");
            }
        }
    }

}
