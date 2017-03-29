package com.mygdx.game.Views;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Camera;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.utils.Pool;
import com.mygdx.game.Cards.Card;
import com.mygdx.game.Cards.Minion;
import com.mygdx.game.Core.DB_tool;
import com.mygdx.game.Deck;
import com.mygdx.game.Game;
import com.mygdx.game.UI.SimpleButton;

public class Board extends View implements ViewSwitchListener {
    private SpriteBatch spriteBatch = new SpriteBatch();
    private SimpleButton backButton;
    private Pool<Card> cardPool;

    private BitmapFont font;

    private Card testCard;
    private Texture background = new Texture(Gdx.files.internal("raw_textures/temp board.png"));

    private Camera camera;
    private Deck playerDeck, opponentDeck;

    @Override
    public void render() {
        Gdx.gl.glClearColor(255 / 255f, 102 / 255f, 102 / 255f, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        spriteBatch.begin();
        spriteBatch.draw(background, 0, 0, stage.getWidth(), stage.getHeight());
        renderMana();
      //  spriteBatch.draw(testCard.getTexture(), 0.0f, 0.0f);
        spriteBatch.end();
        stage.draw();
    }

    @Override
    public void resize(int width, int height) {
        super.resize(width, height);
        refresh(spriteBatch);
    }

    @Override
    public Game.viewIndexes update() {
        //Return the index of the window we want to switch to next
        return returnIndex;
    }

    @Override
    public void create() {
        super.create();

        font = new BitmapFont();
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
        camera = stage.getCamera();

        testCard = new Minion();
        testCard.init("m0");

        background.setFilter(Texture.TextureFilter.Linear, Texture.TextureFilter.Linear);
        //heir AA ist
        DB_tool db_tool = new DB_tool();
        if (db_tool.getPref("aa", "Boolean") == Boolean.TRUE) {
            background.setFilter(Texture.TextureFilter.Linear, Texture.TextureFilter.Linear);
        }
        else {
            background.setFilter(Texture.TextureFilter.Nearest, Texture.TextureFilter.Nearest);
            System.out.println("AA not applied");
        }

        //Creating the two decks
        playerDeck = new Deck(cardPool);
        opponentDeck = new Deck(cardPool);
    }

    private void assembleTable(Table t) {
        t.setFillParent(true);
        t.center().center();
        t.row();
        t.add(backButton).width(80f).height(50f);
        t.row();
    }

    @Override
    public void onSwitch(int switchingToIndex) {
        super.onSwitch(switchingToIndex);
        returnIndex = Game.viewIndexes.BOARD;
    }

    private void refresh(SpriteBatch sb) {
        camera.update();
        sb.setProjectionMatrix(camera.combined);
        sb.getProjectionMatrix().setToOrtho2D(0, 0, stage.getWidth(), stage.getHeight());
    }


    private void renderMana() {
        int mana = 10;
        int mp = 0;
        font.draw(spriteBatch, mana +" / " + mp, 0, 0);
    }
}
