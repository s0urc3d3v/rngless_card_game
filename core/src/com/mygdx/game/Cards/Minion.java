package com.mygdx.game.Cards;

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

    /**
     * @param arg is a list of integers
     *            1. manaCost
     *            2. manaPoison
     *            3. health
     *            4. attack
     */
    @Override
    public void init(int... arg) {
        super.init(arg);
        health = arg[2];
        attack = arg[3];
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