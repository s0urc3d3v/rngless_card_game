package com.mygdx.game.Views;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Camera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.Matrix4;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Button;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.tools.texturepacker.TexturePacker;
import com.badlogic.gdx.utils.Scaling;
import com.badlogic.gdx.utils.viewport.ScalingViewport;
import com.mygdx.game.Game;
import com.mygdx.game.UI.SimpleButton;
import com.mygdx.game.textureAtlases.CardAtlas;

import java.util.ArrayList;


public class Board extends View {
    private ShapeRenderer shapeRenderer = new ShapeRenderer();
    private Stage stage;
    private SpriteBatch spriteBatch;

    @Override
    public void render() {
        stage.draw();
        Gdx.gl.glClearColor(255/255f,102/255f,102/255f, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        ArrayList<Texture> cardTexture = CardAtlas.getCards();
        spriteBatch.begin();
       // spriteBatch.draw(null, 100, 100);
        spriteBatch.end();
    }

    @Override
    public void resize(int width, int height) {
        stage.getViewport().update(width, height, true);
    }

    @Override
    public Game.viewIndexes update() {
        //Don't switch off Home by default
        return Game.viewIndexes.BOARD;
    }

    @Override
    public void create() {
        spriteBatch = new SpriteBatch();
    }
}
