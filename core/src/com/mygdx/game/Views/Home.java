package com.mygdx.game.Views;

import com.mygdx.game.Game;

public class Home extends View {

    @Override
    public void render() {

    }

    @Override
    public Game.viewIndexes update() {
        //Don't switch off Home by default
        return Game.viewIndexes.HOME;
    }
}
