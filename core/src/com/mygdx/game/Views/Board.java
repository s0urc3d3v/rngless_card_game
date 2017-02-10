package com.mygdx.game.Views;

import com.mygdx.game.Game;

public class Board extends View {


    @Override
    public void render() {

    }

    @Override
    public Game.viewIndexes update() {
        //Don't switch off board by default
        return Game.viewIndexes.BOARD;
    }

    @Override
    public void create() {

    }
}
