package com.mygdx.game.Views;

import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.mygdx.game.Game;

import java.io.IOException;
import java.io.*;
import java.util.*;
/**
 * Created by matthewelbing on 17.02.17.
 */
public class Settings extends View implements ViewSwitchListener {

    @Override
    public void render() {
        stage.draw();
    }
    @Override
    public void resize(int width, int height) {
        super.resize(width, height);
    }

    @Override
    public Game.viewIndexes update() {
        //Don't switch off Home by default
        return returnIndex;
    }
    @Override
    public void create() {
        super.create();
        ShapeRenderer shapeRenderer = new ShapeRenderer();
        shapeRenderer.begin();
        shapeRenderer.rect(100, 100, 100, 100);
        shapeRenderer.end();
    }
}

