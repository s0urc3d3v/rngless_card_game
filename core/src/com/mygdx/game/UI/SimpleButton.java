package com.mygdx.game.UI;

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
