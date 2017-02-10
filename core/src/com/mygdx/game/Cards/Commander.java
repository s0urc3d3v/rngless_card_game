package com.mygdx.game.Cards;

import com.mygdx.game.Player;

public class Commander extends Minion {

    Player myPlayer;

    private int attack;

    public Commander() {
        super();
        attack=0;

    }

    /**
     * @param arg is a list of integers
     *            1. manaCost
     *            2. manaPoison
     *            3. Target - should be immune
     *            4. health
     *            5. attack
     */
    @Override
    public void init(int... arg) {
        super.init(arg);
    }

    @Override
    public void reset() {

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
    // Minion stuff
    public void takeDamage(int damageTaken){
        myPlayer.Health= myPlayer.Health-damageTaken;
    }

    // Connects commander to player
    public void connectToPlayer(Player Jesus){
        myPlayer = Jesus;

    }

}
