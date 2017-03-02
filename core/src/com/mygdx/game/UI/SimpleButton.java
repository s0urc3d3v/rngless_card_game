package com.mygdx.game.UI;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.DistanceFieldFont;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.freetype.FreeType;
import com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGenerator;
import com.badlogic.gdx.scenes.scene2d.EventListener;
import com.badlogic.gdx.scenes.scene2d.ui.Button;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.sun.javafx.webkit.EventLoopImpl;


public class SimpleButton extends TextButton {
    protected static BitmapFont font;
    protected static Skin skin;
    protected static TextButton.TextButtonStyle tbs = new TextButton.TextButtonStyle();


    //Make the stuff that all simple buttons need.
    static {
        //Load up the texture atlas in the form of a skin
        skin = new Skin(Gdx.files.internal("packed_textures/shadeui/uiskin.json"));

        //Set states for various textures
        tbs.up = skin.getDrawable("button");
        tbs.down = skin.getDrawable("button-down");
        //free type font
        FreeTypeFontGenerator generator = new FreeTypeFontGenerator(Gdx.files.internal("fonts/open-sans/OpenSans-Regular.ttf"));
        //Defaults to size 16 font
        FreeTypeFontGenerator.FreeTypeFontParameter parameter = new FreeTypeFontGenerator.FreeTypeFontParameter();
        parameter.minFilter = Texture.TextureFilter.Linear;
        parameter.magFilter = Texture.TextureFilter.Linear;

        font = generator.generateFont(parameter);
        generator.dispose();

        tbs.font = font;
    }
    
    public SimpleButton(String text) {
        //Create a button with our custom text and style
        super(text, tbs);
    }
}
