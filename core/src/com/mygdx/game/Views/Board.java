package com.mygdx.game.Views;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.mygdx.game.Controller;
import com.mygdx.game.Game;
import com.mygdx.game.UI.SimpleButton;

public class Board extends View implements ViewSwitchListener {
    private Stage stage;
    private SpriteBatch spriteBatch;

    private Game.viewIndexes returnIndex = Game.viewIndexes.BOARD;

    private SimpleButton backButton;

    @Override
    public void render() {
        Gdx.gl.glClearColor(255/255f,102/255f,102/255f, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        stage.draw();
//        ArrayList<Texture> cardTexture = CardAtlas.getCards();
//        spriteBatch.begin();
       // spriteBatch.draw(null, 100, 100);
//        spriteBatch.end();
    }

    @Override
    public void resize(int width, int height) {
        stage.getViewport().update(width, height, true);
    }

    @Override
    public Game.viewIndexes update() {
        //Return the index of the window we want to switch to next
        return returnIndex;
    }

    @Override
    public void create() {
        //Tell us when switching methods
       Controller.attachListener(this);

       stage = new Stage();
       backButton = new SimpleButton("Go Back");
       backButton.addListener(new ClickListener() {
           @Override
           public void clicked(InputEvent event, float x, float y) {
               returnIndex = Game.viewIndexes.HOME;
           }
       });
       Table table = new Table();
       assembleTable(table);
       stage.addActor(table);
    }

    private void assembleTable(Table t) {
        t.setFillParent(true);
        t.center().center();
        t.row();
        t.add(backButton);
    }

    @Override
    public void onSwitch(int switchingToIndex) {
        if(switchingToIndex == Game.viewIndexes.BOARD.getValue()) {
            //Then we should be taking the input now
            Gdx.input.setInputProcessor(stage);
        } else {
            //We are switching off this screen and should make sure to set back our return index
            returnIndex = Game.viewIndexes.BOARD;
        }
    }
}
