package com.mygdx.game.Views;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Camera;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.mygdx.game.Game;

public class CardSelector extends View implements ViewSwitchListener {
    private SpriteBatch spriteBatch = new SpriteBatch();
    private Camera camera;


    @Override
    public void render() {
        //refresh();
        Gdx.gl.glClearColor(100 / 255f, 100/ 255f, 100 / 255f, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        if (Gdx.input.isKeyPressed(Input.Keys.ESCAPE)){
            returnIndex = Game.viewIndexes.HOME;
        }
        spriteBatch.begin();

        BitmapFont font = new BitmapFont();

        font.setColor(new Color(105f/255f, 0, 248f/255f, 1));
        font.draw(spriteBatch, "All Cards", Gdx.graphics.getWidth()/2, Gdx.graphics.getHeight() - 50);
        spriteBatch.end();

    }

    @Override
    public void resize(int width, int height) {
        super.resize(width, height);
    }

    @Override
    public Game.viewIndexes update() {
        //Don't switch off CardSelector by default
        return returnIndex;
    }

    @Override
    public void create() {
        super.create();
        camera = stage.getCamera();

    }

    private void refresh(){
        stage.getCamera().update();
        spriteBatch.setProjectionMatrix(camera.combined);
        spriteBatch.getProjectionMatrix().setToOrtho2D(0,0,stage.getWidth(), stage.getWidth());

    }


    @Override
    public void onSwitch(int switchingToIndex) {
        super.onSwitch(switchingToIndex);
        returnIndex = Game.viewIndexes.CARDSELECTOR;
    }
}
