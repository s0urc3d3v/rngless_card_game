package com.mygdx.game.Views;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.mygdx.game.Controller;
import com.mygdx.game.Game;
import com.mygdx.game.UI.SimpleButton;


public class Home extends View implements ViewSwitchListener {
    private SimpleButton playButton;
    private SimpleButton customButton;
    private SimpleButton settingsButton;
    private SimpleButton quitButton;

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
        //Set us as the default input processor, as this is the primary view.
        Gdx.input.setInputProcessor(stage);

        //Create a simple menu buttons
        playButton = new SimpleButton("Play");
        playButton.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                returnIndex = Game.viewIndexes.BOARD;
            }
        });
        customButton = new SimpleButton("Customize Deck");
        customButton.addListener(new ClickListener(){
            @Override
            public void clicked(InputEvent event, float x, float y){
                returnIndex = Game.viewIndexes.CARDSELECTOR;
            }

        });
        settingsButton = new SimpleButton("Settings");
        settingsButton.addListener(new ClickListener() {
            public void clicked(InputEvent event, float x, float y) {
                returnIndex = Game.viewIndexes.SETTINGS;
            }
        });
        quitButton = new SimpleButton("Quit");

        quitButton.addListener(new ClickListener() {
            public void clicked(InputEvent event, float x, float y) {
                Gdx.app.exit();
            }
        });

        Table table = new Table();
        assembleTable(table);
        stage.addActor(table);
    }


    private void assembleTable(Table table) {
        //Puts buttons onto the screen in a vertical alignment
        table.setFillParent(true);
        table.center().center();
        table.add(playButton).padBottom(10);
        table.row();
        table.add(customButton).width(175).padBottom(10);
        table.row();
        table.add(settingsButton).padBottom(10);
        table.row();
        table.add(quitButton).padBottom(10);
    }

    @Override
    public void onSwitch(int switchingToIndex) {
        super.onSwitch(switchingToIndex);
        //Reset our return value.
        returnIndex = Game.viewIndexes.HOME;
    }
}
