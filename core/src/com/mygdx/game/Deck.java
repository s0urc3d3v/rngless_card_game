package com.mygdx.game;

import com.badlogic.gdx.utils.Pool;
import com.mygdx.game.Cards.Card;

import java.util.List;

/**
 * Created by matthewelbing on 06.02.17.
 */
public class Deck {
    List<Card> cards;
    Pool<Card> cardPool;

    public Deck(Pool<Card> cardPool) {
        this.cardPool = cardPool;
    }
}
