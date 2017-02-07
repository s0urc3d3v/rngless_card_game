package com.mygdx.game.Cards;

public class Minion extends Card {

    private int currentHealth;

    private int health;

    private int attack;

    public Minion(int manaCost, int manaPoison, int health, int attack) {
        super(manaCost, manaPoison);
        this.health = health;
        this.attack = attack;
        currentHealth = health;
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