package com.mygdx.game.Views;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.mygdx.game.Cards.Card;
import com.mygdx.game.Cards.Minion;
import com.mygdx.game.Game;
import com.mygdx.game.UI.SimpleButton;

public class Board extends View implements ViewSwitchListener {
    private SpriteBatch spriteBatch = new SpriteBatch();
    private SimpleButton backButton;

    private Card testCard;
    private Texture background = new Texture(Gdx.files.internal("raw_textures/temp board.png"));
    private TextureRegion tr = new TextureRegion(background, 0, 0, 960, 720);

    @Override
    public void render() {
        Gdx.gl.glClearColor(255 / 255f, 102 / 255f, 102 / 255f, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
       // background.setFilter(Texture.TextureFilter.Linear, Texture.TextureFilter.Linear);
        spriteBatch.begin();
        spriteBatch.draw(tr, 0, 0, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
        //spriteBatch.draw(testCard.getTexture(), 0, 0, 100, 150);
        spriteBatch.end();

        stage.draw();
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
        super.create();
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

        //TODO: Delete later
        testCard = new Minion();
        testCard.init("m0");
    }

    private void assembleTable(Table t) {
        t.setFillParent(true);
        t.center().center();
        t.row();
        t.add(backButton);
        t.row();
    }

    @Override
    public void onSwitch(int switchingToIndex) {
        super.onSwitch(switchingToIndex);
        returnIndex = Game.viewIndexes.BOARD;
    }
}
