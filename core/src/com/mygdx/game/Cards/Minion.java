package com.mygdx.game.Cards;

import com.badlogic.gdx.utils.XmlReader;

public class Minion extends Card {

    private int currentHealth;
    private int health;
    private int attack;

    public Minion() {
        super();
        this.health = 0;
        this.attack = 0;
        currentHealth = 0;
    }

    public void init(String cardHash) {
        super.init(cardHash);
    }

    @Override
    void loadSubCardAttribs(XmlReader.Element cardAttributeElement) {
        //Loading in our custom Attributes for this sub-card
        health = Integer.valueOf(cardAttributeElement.get("health"));
        attack = Integer.valueOf(cardAttributeElement.get("attack"));
    }

    @Override
    public void reset() {
        currentHealth = health;
    }

    public int getAttack() {
        return attack;
    }

    public int getHealth() {
        return health;
    }

    public int getCurrentHealth() {
        return currentHealth;
    }

    public void takeDamage(int damageTaken){
        currentHealth= currentHealth-damageTaken;
    }


    public void setHealth(int n) {
        currentHealth = n;
    }

    @Override
    public void onCreate() {

    }

    @Override
    public void onDestroy() {

    }

    @Override
    public void onAnimate() {

    }

    @Override
    public void render() {

    }
}