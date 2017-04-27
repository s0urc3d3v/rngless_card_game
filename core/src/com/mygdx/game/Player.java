package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.Event;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.utils.Pool;
import com.mygdx.game.Cards.Card;
import com.mygdx.game.Cards.Commander;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class Player {

    private int Health,Fatigue, mana;
    private Deck myDeck;
    private Commander myCommander;
    private Card holdingCard;

    public Player(Commander c, Pool<Card> cardPool){
        myCommander = c;
        Health = 30;
        Fatigue = 0;
        mana = 0;
        myDeck = new Deck(cardPool);
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
            batch.draw(holdingCard.getTexture(), Gdx.input.getX(), Gdx.input.getY(), holdingCard.getWidth(), holdingCard.getHeight());
        }
    }

    public void addCard(String hash) {
        myDeck.addCard(hash);
        myDeck.getCardsInPlay().get(myDeck.getCurrentDeckSize() - 1).addListener(new ClickListener() {
            public void clicked(InputEvent event, float x, float y) {
                System.out.println("Clicked");
                //Get the card that was clicked on
                Card card = (Card) event.getListenerActor();
                //Remove the card from the current played cards list
                myDeck.getCardsInPlay().remove(card);
                //Set it as the card that the player is holding.
                holdingCard = card;
            }
        });
    }

    public void startTurn(){
    }

    public void increaseMana(){
    }
}

