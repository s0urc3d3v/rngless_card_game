package com.mygdx.game.Views;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.math.Matrix4;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Button;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.tools.texturepacker.TexturePacker;
import com.badlogic.gdx.utils.Scaling;
import com.badlogic.gdx.utils.viewport.ScalingViewport;
import com.mygdx.game.Controller;
import com.mygdx.game.Game;
import com.mygdx.game.UI.SimpleButton;


public class Board extends View {

    private Stage stage;

    private Game.viewIndexes returnIndex = Game.viewIndexes.BOARD;

    private SimpleButton backButton;

    @Override
    public void render() {
        Gdx.gl.glClearColor(255/255f,102/255f,102/255f, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        stage.draw();
    }

    @Override
    public void resize(int width, int height) {
        stage.getViewport().update(width, height, true);
    }

    @Override
    public Game.viewIndexes update() {
        //Don't switch off Home by default
        return returnIndex;
    }

    @Override
    public void create() {

       stage = new Stage();
       //Gdx.input.setInputProcessor(stage);
       backButton = new SimpleButton("Go Back");
       backButton.addListener(new ClickListener() {

           @Override
           public void clicked(InputEvent event, float x, float y) {
               returnIndex = Game.viewIndexes.HOME;
               update();
               Controller.callViewSwitch();
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
        t.add(backButton).pad(10);
    }
}
