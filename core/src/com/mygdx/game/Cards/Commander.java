package com.mygdx.game.Cards;

public class Commander extends Minion {

    public Commander() {
        super();
    }

    /**
     * @param arg is a list of integers
     *            1. manaCost
     *            2. manaPoison
     *            3. health
     *            4. attack
     *            5. Target - should be immune
     */
    @Override
    public void init(int... arg) {
        super.init(arg);
    }
}
