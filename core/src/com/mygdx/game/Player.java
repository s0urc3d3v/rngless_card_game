package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.Pool;
import com.mygdx.game.Cards.Card;
import com.mygdx.game.Cards.Commander;

public class Player {

    private int Health,Fatigue, mana;
    private Deck myDeck;
    private Commander myCommander;
    private Card holdingCard;
    //Used for signing the cards in this deck
    private String deckSignature;

    public Player(Commander c, Pool<Card> cardPool){
        myCommander = c;
        Health = 100;
        Fatigue = 0;
        mana = 0;
        myDeck = new Deck(cardPool);
        deckSignature = Math.random() + " " + Math.random() + " " + Math.random() + this.toString();
    }

    public void cardClicked(Card card) {
        holdingCard = card;
        getMyDeck().getCardsInPlay().remove(card);
    }

    public String getDeckSignature() {
        return deckSignature;
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

    //Render the current card that the player is holding
    public void renderCurrentCard(SpriteBatch batch) {
        if(holdingCard != null) {
            batch.draw(holdingCard.getTexture(), Gdx.input.getX(), Gdx.graphics.getHeight() - Gdx.input.getY(), holdingCard.getWidth(), holdingCard.getHeight());
        }
    }

    public void addCard(String hash) {
        myDeck.addCard(hash, deckSignature);
    }

    public void startTurn(){
    }

    public void increaseMana(){
    }
}

