package com.mygdx.game.UI;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.scenes.scene2d.ui.Button;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;

/**
 * Created by john_bachman on 2/15/17.
 */
public class SimpleButton {
    protected Button button;
    protected static BitmapFont font;
    protected static Skin skin;
    protected static TextureAtlas simpleAtlas;
    protected static TextButton.TextButtonStyle tbs = new TextButton.TextButtonStyle();


    //Make the stuff that all simple buttons need.
    static {
        //Load up texture atlas
        simpleAtlas = new TextureAtlas(Gdx.files.internal("buttons/buttons.pack"));
        skin.addRegions(simpleAtlas);

        //Set states for various textures
        tbs.up = skin.getDrawable("up-button");
        tbs.down = skin.getDrawable("down-button");
        tbs.checked = skin.getDrawable("down-button");
        font = new BitmapFont();
        skin = new Skin();
        tbs.font = font;
    }
    
    public SimpleButton(String text) {
        button = new TextButton(text, tbs);
    }

    public Button getButton() {
        return button;
    }
}
