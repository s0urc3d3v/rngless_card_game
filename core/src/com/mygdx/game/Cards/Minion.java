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
     *            3. Target - should be targetable
     *            4. health
     *            5. attack
     *            6. take damage
     */
    @Override
    public void init(int... arg) {
        super.init(arg);
        health = arg[3];
        attack = arg[4];
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