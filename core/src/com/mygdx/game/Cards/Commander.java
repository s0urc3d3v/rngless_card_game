package com.mygdx.game.Cards;

import com.mygdx.game.Player;

public class Commander extends Minion {

    Player player;

    public Commander() {
        super();
    }

    @Override
    public void init(String cardHash) {
        super.init(cardHash);
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
        player.Health = player.Health-damageTaken;
    }

    // Connects commander to player
    public void connectToPlayer(Player other){
        player = other;
    }

}
