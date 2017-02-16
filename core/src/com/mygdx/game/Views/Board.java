package com.mygdx.game.Views;

import com.badlogic.gdx.math.Matrix4;
import com.mygdx.game.Game;

public class Board extends View {


    @Override
    public void render() {

    }

    @Override
    public void resize(int width, int height) {

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
