package com.mygdx.game.Cards;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.utils.Pool;

public abstract class Card implements Pool.Poolable {
    private int cost;
    private int manaPoisoning;
    Texture cardImg = null; //This must be loaded with a batch


    //Default Constructor
    public Card() {
        this.cost = 0;
        this.manaPoisoning = 0;
    }

    /**
     * YOU NEED TO OVERRIDE THIS METHOD AND IMPLEMENT IT FOR SUBCLASSES
     * All subclasses must have a init method that acts as a constructor
     * This allows them to poolable
     * @param arg: A variable number of integers that get passed in for arguments.
     *           1. Cost
     *           2. manaPoisoning
     */
    public void init(int... arg) {
        cost = arg[0];
        manaPoisoning = arg[1];
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
