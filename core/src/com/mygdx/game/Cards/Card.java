package com.mygdx.game.Cards;

import com.badlogic.gdx.utils.Pool;

public abstract class Card implements Pool.Poolable { //Implements a Card Inferface
    private int cost;
    private int manaPoisoning;


    //Constructor has to init values not declare for Poolable objects.
    public Card() {
        this.cost = 0;
        this.manaPoisoning = 0;
    }

    //Same thing as constructor, but you can't call constructor after getting the Card from a pool.
    public void init(int cost, int mp) {
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
