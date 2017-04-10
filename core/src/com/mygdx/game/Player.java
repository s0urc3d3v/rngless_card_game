package com.mygdx.game;

import com.mygdx.game.Cards.Commander;

public class Player {

    private int Health,Fatigue, mana;
    private Deck myDeck;
    private Commander myCommander;

   public Player(Deck d, Commander c ){
       myDeck = d;
       myCommander = c;
       Health = 30;
       Fatigue = 0;
       mana = 0;
    }

    public int getHealth() {
        return Health;
    }

    public int getFatigue() {
        return Fatigue;
    }

    public void setHealth(int n) {
        Health = n;
    }

    public int getMana() {
        return mana;
    }

    public Commander getMyCommander() {
        return myCommander;
    }
    public Deck getMyDeck() {
        return myDeck;
    }
    public void startTurn(){
    }

    public void increaseMana(){
    }
}

