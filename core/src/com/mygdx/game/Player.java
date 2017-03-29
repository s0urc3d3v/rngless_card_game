package com.mygdx.game;

import com.mygdx.game.Cards.Commander;

public class Player {

    public int Health,Fatigue, mana;
    public Deck myDeck;
    public Commander myCommander;
    private int Health,Fatigue,Mana;
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

    public int getMana() {
        return Mana;
    }

    public Commander getMyCommander() {
        return myCommander;
    }
    public Deck getMyDeck() {
        return myDeck;
    }
    public void startTurn(){
    }
    public int getMana(){
        return mana;
    }
    public void increaseMana(){

    }
}

