package com.mygdx.game;

import com.mygdx.game.Cards.Commander;

public class Player {

    public int Health,Fatigue,Mana;
    public Deck myDeck;
    public Commander myCommander;

   public Player(Deck d, Commander c ){
       myDeck = d;
       myCommander = c;
       Health = 30;
       Fatigue = 0;
       Mana = 0;

    }

    public void startTurn(){

    }
}
