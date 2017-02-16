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
        //Load up the texture atlas in the form of a skin
        skin = new Skin(Gdx.files.internal("shadeui/uiskin.json"));

        //Set states for various textures
        tbs.up = skin.getDrawable("button");
        tbs.down = skin.getDrawable("button-down");
        //Basic font
        font = new BitmapFont();
        tbs.font = font;
    }
    
    public SimpleButton(String text) {
        //Create a button with our custom text and style
        button = new TextButton(text, tbs);
    }

    public Button getButton() {
        return button;
    }
}
