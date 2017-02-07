package com.mygdx.game.Cards;

import com.badlogic.gdx.utils.Pool;

/**
 * Created by matthewelbing on 06.02.17.
 */
public abstract class Card implements Pool.Poolable { //Implements a Card Inferface
    @Override
    public abstract void reset();
}
