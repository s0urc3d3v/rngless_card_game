package com.mygdx.game.Cards;

import com.badlogic.gdx.utils.Pool;

public abstract class Card implements Pool.Poolable { //Implements a Card Inferface
    private int cost;
    private int manaPoisoning;


    public Card(int cost, int mp) {
        this.cost = cost;
        this.manaPoisoning = mp;
    }

    @Override
    public abstract void reset();

    public abstract void onCreate();

    public abstract void onDestroy();

    public abstract void onAnimate();

    public abstract void render();


    public int getCost() {
        return cost;
    }

    public int getManaPoisoning() {
        return manaPoisoning;
    }

}
