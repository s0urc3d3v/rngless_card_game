package com.mygdx.game.Cards;

import com.badlogic.gdx.utils.Pool;

public abstract class Card implements Pool.Poolable { //Implements a Card Inferface
    private int cost = 0;
    private int manaPoisoning = 0;

    @Override
    public abstract void reset();

    public abstract void onCreate();

    public abstract void onDestroy();

    public abstract void onAnimate();

    public abstract void render();

}
