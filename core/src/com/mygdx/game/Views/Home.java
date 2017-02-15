package com.mygdx.game.Views;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Button;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.mygdx.game.Game;


public class Home extends View {

    private TextButton.TextButtonStyle tbs = new TextButton.TextButtonStyle();
    private Button play;
    private BitmapFont font;
    private Skin skin;
    private TextureAtlas buttonAtlas;
    private Stage stage;

    @Override
    public void render() {
        stage.draw();
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
        font = new BitmapFont();
        skin = new Skin(Gdx.files.internal("shadeui/uiskin.json"));
       // buttonAtlas = new TextureAtlas());
        //skin.addRegions(buttonAtlas);
        tbs.font = font;
        tbs.up = skin.getDrawable("button");
        tbs.down = skin.getDrawable("button-down");
        play = new TextButton("Play", tbs);

        Table table = new Table();
        table.setFillParent(true);
        table.center().center();
        table.add(play);
        stage.addActor(table);

    }
}
