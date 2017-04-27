package com.mygdx.game.Views;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Camera;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGenerator;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.utils.Pool;
import com.mygdx.game.Cards.Card;
import com.mygdx.game.Cards.Minion;
import com.mygdx.game.Controller;
import com.mygdx.game.Core.DB_tool;
import com.mygdx.game.Deck;
import com.mygdx.game.Game;
import com.mygdx.game.Player;
import com.mygdx.game.UI.SimpleButton;

import java.lang.reflect.Parameter;
import java.util.List;

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
        //Draw the decks cards 3/4 of the way down the screen for our player.
        //TODO: Test Render Deck Method.
        renderDeck(spriteBatch, playerDeck, Gdx.graphics.getWidth(), (int)(Gdx.graphics.getHeight() / 8.0 * 3.0));
        renderMana();
        renderHealth();
//        spriteBatch.draw(testCard.getTexture(), 100f, 30f, 100f, 100f);
        spriteBatch.end();
        stage.draw();
        if (Gdx.input.isKeyPressed(Input.Keys.ESCAPE)){
            returnIndex = Game.viewIndexes.HOME;
        }
        ShapeRenderer renderer = new ShapeRenderer();
        renderer.begin(ShapeRenderer.ShapeType.Filled);
        renderer.rect(0,0, 110, stage.getHeight());
        renderer.setColor(0,0,0,0);
        renderer.end();
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

    private void renderDeck(SpriteBatch batch, Deck deck, int width, int heightBase) {
        List<Card> deckCards = deck.getCardsInPlay();
        int spacing = width / (deckCards.size() + 1);
        for(int i = 0; i < deckCards.size(); i++) {
            Card currentCard = deckCards.get(i);
            currentCard.setSize(50, 100);
            int cardHeightOffset = (currentCard.getCardHeight() / 2);
            int cardWidthOffset = (currentCard.getCardWidth() / 2);
            batch.draw(currentCard.getTexture(), spacing * (i + 1) - cardWidthOffset, heightBase - cardHeightOffset, currentCard.getCardWidth(), currentCard.getCardHeight());
        }
    }

    @Override
    public void create() {
        super.create();

        cardPool = new Pool<Card>() {
            @Override
            protected Card newObject() {
                return new Card();
            }
        };

        font = new BitmapFont();

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

        //Adding cards for testing
        for(int i = 0; i < 10; i++) {
            playerDeck.addCard("m0");
        }
    }

    private void assembleTable(Table t) {
        t.setFillParent(true);
        t.center().center();
        t.row();
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
        Controller controller = Game.getController();
        Player p = controller.getCurrentPlayer();
        int mana_one = p.getMana();
        int mp_one = p.getFatigue();

        int mana_two = p.getMana();
        int mp_two = p.getFatigue();

        font.setColor(new Color(105f/255f, 0, 248f/255f, 1));
        font.draw(spriteBatch, mana_one +" M / " + mp_one + " MP", 140, 60);
        font.draw(spriteBatch, mana_two +" M / " + mp_two + " MP", 140, 910);

    }
    private void renderHealth(){
        Controller controller = Game.getController();
        Player p = controller.getCurrentPlayer();

        int health_one = controller.get_player_one().getHealth();
        int health_two = controller.get_player_two().getHealth();

        font.setColor(new Color(105f/255f, 0, 248f/255f, 1));
        font.draw(spriteBatch, "Health: " + health_one, 1080, 60);
        font.draw(spriteBatch, "Health: " + health_two, 1080, 910);

    }
}
