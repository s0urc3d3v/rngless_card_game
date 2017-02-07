package com.mygdx.game.Cards;

import com.badlogic.gdx.utils.Pool;

public abstract class Card implements Pool.Poolable { //Implements a Card Inferface
    @Override
    public abstract void reset();

    public abstract void onCreate();

    public abstract void onDestroy();

    public abstract void onAnimate();
}
