package com.mygdx.game.Views;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.math.Matrix4;
import com.badlogic.gdx.scenes.scene2d.Actor;
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
import com.mygdx.game.Game;
import com.mygdx.game.UI.SimpleButton;


public class Home extends View {

    private Stage stage;

    @Override
    public void render() {
        stage.draw();
    }

    @Override
    public void resize(int width, int height) {
        stage.getViewport().update(width, height, true);
    }

    @Override
    public Game.viewIndexes update() {
        //Don't switch off Home by default
        return Game.viewIndexes.HOME;
    }

    @Override
    public void create() {
        stage = new Stage();
        Gdx.input.setInputProcessor(stage);

        //Create a simple Play button
        SimpleButton playButton = new SimpleButton("Play");
        playButton.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                System.out.println("X:" + x + " Y:" + y);
                //return true;
            }
        });
        SimpleButton customButton = new SimpleButton("Customize Deck");
        SimpleButton settingsButton = new SimpleButton("Settings");
        SimpleButton quitButton = new SimpleButton("Quit");

        Table table = new Table();
        table.setFillParent(true);
        table.center().center();
        table.add(playButton.getButton()).padBottom(10);
        table.row();
        table.add(customButton.getButton()).padBottom(10);
        table.row();
        table.add(settingsButton.getButton()).padBottom(10);
        table.row();
        table.add(quitButton.getButton()).padBottom(10);
        stage.addActor(table);
    }
}
