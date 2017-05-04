package com.mygdx.game.Views;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Camera;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.ui.HorizontalGroup;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.utils.Pool;
import com.mygdx.game.Cards.Card;
import com.mygdx.game.Deck;
import com.mygdx.game.Game;
import com.mygdx.game.UI.SimpleButton;

public class CardSelector extends View implements ViewSwitchListener {
    private SpriteBatch spriteBatch = new SpriteBatch();
    private Camera camera;
    private SimpleButton Heros,Minions,Spells;
    private Deck allCardDeck;
    private Table table;

    @Override
    public void render() {
        Gdx.gl.glClearColor(100 / 255f, 100/ 255f, 100 / 255f, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        if (Gdx.input.isKeyPressed(Input.Keys.ESCAPE)){
            returnIndex = Game.viewIndexes.HOME;
        }
//        spriteBatch.begin();
//
//        BitmapFont font = new BitmapFont();
//
//        font.setColor(new Color(105f/255f, 0, 248f/255f, 1));
//        font.draw(spriteBatch, "All Cards", Gdx.graphics.getWidth()/2, Gdx.graphics.getHeight() - 50);
//        spriteBatch.end();
        stage.draw();
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


        Heros = new SimpleButton("Heros");
        Heros.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                ;
            }
        });

        Minions = new SimpleButton("Minions");
        Minions.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                ;
            }
        });

        Spells = new SimpleButton("Spells");
        Spells.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
               ;
            }
        });

        table = new Table();
        assembleTable(table);
        //Create a new deck and put all the cards possible into it.
        allCardDeck = new Deck(new Pool<Card>() {
            @Override
            protected Card newObject() {
                return new Card();
            }
        });
        allCardDeck.loadAllCards();
        addDeckToTable(table, allCardDeck);

        table.setDebug(true);
        table.left().top();
        stage.addActor(table);
    }

    private void refresh() {
        stage.getCamera().update();
        spriteBatch.setProjectionMatrix(camera.combined);
        spriteBatch.getProjectionMatrix().setToOrtho2D(0, 0, stage.getWidth(), stage.getWidth());
    }

    @Override
    public void onSwitch(int switchingToIndex) {
        super.onSwitch(switchingToIndex);
        returnIndex = Game.viewIndexes.CARDSELECTOR;
    }

    private void assembleTable(Table table) {
        table.setFillParent(true);
        table.setY(0);
        table.add(Heros).padRight(10);
        table.add(Minions).padRight(10);
        table.add(Spells);
    }

    private void addDeckToTable(Table table, Deck deck) {
        int currentX = 0;
        int padding = 5;
        int cardIndex = 0;
        Card currentCard = deck.getCardsInPlay().get(0);
        table.row();
        do {
            for (currentX = padding; currentX - padding < Gdx.graphics.getWidth(); currentX += currentCard.getWidth() + padding) {
                table.add(new Image(currentCard.getTexture())).padRight(padding);
                cardIndex++;
                if(cardIndex < deck.getCurrentDeckSize())
                    currentCard = deck.getCardsInPlay().get(cardIndex);
                else
                    break;
            }
            table.row();
        } while(currentCard != deck.getCardsInPlay().get(deck.getCurrentDeckSize() - 1));
    }

}
