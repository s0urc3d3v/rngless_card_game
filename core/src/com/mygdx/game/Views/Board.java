package com.mygdx.game.Views;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.math.Matrix4;
import com.mygdx.game.Game;

public class Board extends View {


    @Override
    public void render() {
        Gdx.gl.glClearColor(255/255f,102/255f,102/255f, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
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
