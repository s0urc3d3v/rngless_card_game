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
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.utils.Pool;
import com.mygdx.game.Cards.Card;
import com.mygdx.game.Cards.Commander;
import com.mygdx.game.Cards.Minion;
import com.mygdx.game.Controller;
import com.mygdx.game.Core.DB_tool;
import com.mygdx.game.Deck;
import com.mygdx.game.Game;
import com.mygdx.game.Player;
import com.mygdx.game.UI.SimpleButton;

import java.util.List;

public class Board extends View implements ViewSwitchListener {
    private SpriteBatch spriteBatch = new SpriteBatch();
    private SimpleButton backButton;
    private Pool<Card> cardPool;

    private BitmapFont font;

    private Card testCard;
    private Texture background = new Texture(Gdx.files.internal("raw_textures/temp board.png"));

    private Camera camera;
    private Player player, opponent;
    private Controller controller;

    @Override
    public void render() {
        Gdx.gl.glClearColor(255 / 255f, 102 / 255f, 102 / 255f, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        spriteBatch.begin();
        spriteBatch.draw(background, 0, 0, stage.getWidth(), stage.getHeight());
        /*ShapeRenderer renderer = new ShapeRenderer();
        renderer.setProjectionMatrix(camera.combined);

        float rgbToGdx[] = Controller.convertColor(254, 102, 102);
        renderer.setColor(rgbToGdx[0], rgbToGdx[1], rgbToGdx[2], 1);

        renderer.begin(ShapeRenderer.ShapeType.Filled);
        renderer.rect(0,0, 250, stage.getHeight());*/

        //renderer.end();
        //Draw the decks cards 3/4 of the way down the screen for our player.
        player.renderCurrentCard(spriteBatch);
        renderDeck(spriteBatch, player.getMyDeck());
        renderMana();
        renderHealth();
//        spriteBatch.draw(testCard.getTexture(), 100f, 30f, 100f, 100f);
        spriteBatch.end();
        stage.draw();
        if (Gdx.input.isKeyPressed(Input.Keys.ESCAPE)){
            returnIndex = Game.viewIndexes.HOME;
        }

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

    private void renderDeck(SpriteBatch batch, Deck deck) {
        List<Card> deckCards = deck.getCardsInPlay();
        for (int i = 0; i < deckCards.size(); i++) {
            Card currentCard = deckCards.get(i);
            currentCard.setSize(50, 25);
            //int cardHeightOffset = (int) (currentCard.getHeight() / 2);
            //int cardWidthOffset = (int) (currentCard.getWidth() / 2);

            currentCard.setPosition(12, stage.getHeight() - (120*i));
            font.draw(batch, currentCard.getName(), 12,(stage.getHeight() - (120*i) - currentCard.getHeight() - 5));
            //batch.draw(currentCard.getTexture(), currentCard.getX(), currentCard.getY(), currentCard.getWidth(), currentCard.getHeight());
            batch.draw(currentCard.getTexture(), currentCard.getX(), currentCard.getY(), currentCard.getWidth(), currentCard.getHeight());
        }
    }
    private void renderDeckAsText(SpriteBatch batch, Deck deck_in){
        List<Card> cards = deck_in.getCardsInPlay();
        for (int i = 0; i < cards.size(); i++) {
            cards.get(i).getName();
            //draw name
        }
    }


    @Override
    public void create() {
        super.create();
        controller = new Controller();

        cardPool = new Pool<Card>() {
            @Override
            protected Card newObject() {
                return new Card();
            }
        };

        player = new Player(new Commander(), cardPool);

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

        //Adding cards for testing
        for(int i = 0; i < 10; i++) {
            player.addCard("m0");
            stage.addActor(player.getMyDeck().getCardsInPlay().get(player.getMyDeck().getCurrentDeckSize() - 1));
        }

        stage.addListener(new ClickListener() {
            public void clicked(InputEvent event, float x, float y) {
                for(int i = stage.getActors().size - 1; i >= 0; i--) {
                    Actor actor = stage.getActors().get(i);
                    //Current Actor, make a collision box
                    Rectangle rectangle = new Rectangle(actor.getX(), actor.getY(), actor.getWidth(), actor.getHeight());
                    //Check if mouse is clicked on collision box
                    if(rectangle.contains(x, y)) {
                        //Fire the click event if it is on our deck
                        if(actor instanceof Card && player.getDeckSignature().equals(((Card) actor).getSignature())) {
                            player.cardClicked((Card)actor);
                        }
                        //After a hit, break, so we don't click another actor.
                        break;
                    }
                }
            }
        });
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
        int mana_one = player.getMana();
        int mp_one = player.getFatigue();

        int mana_two = player.getMana();
        int mp_two = player.getFatigue();

        font.setColor(new Color(105f/255f, 0, 248f/255f, 1));
        font.draw(spriteBatch, mana_one +" M / " + mp_one + " MP", 280, 60);
        font.draw(spriteBatch, mana_two +" M / " + mp_two + " MP", 280, 850);

    }
    private void renderHealth(){
        int health_one = controller.get_player_one().getHealth();
        int health_two = controller.get_player_two().getHealth();

        font.setColor(new Color(105f/255f, 0, 248f/255f, 1));
        font.draw(spriteBatch, "Health: " + health_one, 1100, 60);
        font.draw(spriteBatch, "Health: " + health_two, 1100, 850);
    }

}
