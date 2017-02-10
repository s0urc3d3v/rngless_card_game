package com.mygdx.game.Views;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.mygdx.game.Game;


public class Home extends View {
    ShapeRenderer renderer = new ShapeRenderer();
    SpriteBatch spriteBatchMenu = new SpriteBatch();
    BitmapFont title = new BitmapFont();
    @Override
    public void render() {

    }

    @Override
    public Game.viewIndexes update() {
        //Don't switch off Home by default

        return Game.viewIndexes.HOME;
    }
}
