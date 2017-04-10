package com.mygdx.game.UI;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGenerator;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.mygdx.game.Core.DB_tool;


public class SimpleButton extends TextButton {
    protected static BitmapFont font;
    protected static Skin skin;
    protected static TextButton.TextButtonStyle tbs = new TextButton.TextButtonStyle();
    private static int fontSize = 25;


    //Make the stuff that all simple buttons need.
    static {
        //Load up the texture atlas in the form of a skin
        skin = new Skin(new TextureAtlas(Gdx.files.internal("packed_textures/buttons/buttons.atlas")));

        //Set states for various textures
        tbs.up = skin.getDrawable("Button Aqua - UP");
        tbs.down = skin.getDrawable("Button Aqua - DOWN");
        //free type font
        FreeTypeFontGenerator generator = new FreeTypeFontGenerator(Gdx.files.internal("fonts/ancient/Ancient_Medium.ttf"));
        //Defaults to size 16 font
        FreeTypeFontGenerator.FreeTypeFontParameter parameter = new FreeTypeFontGenerator.FreeTypeFontParameter();
        //heir AA ist
        DB_tool db_tool = new DB_tool();
        if (db_tool.getPref("aa", "Boolean") == Boolean.TRUE){
            parameter.minFilter = Texture.TextureFilter.Linear;
            parameter.magFilter = Texture.TextureFilter.Linear;
        }
        else{
            parameter.minFilter = Texture.TextureFilter.Nearest;
            parameter.magFilter = Texture.TextureFilter.Nearest;
            System.out.println("no AA aplied");
        }


        parameter.size = fontSize;

        font = generator.generateFont(parameter);
        generator.dispose();

        tbs.font = font;
    }
    
    public SimpleButton(String text) {
        //Create a button with our custom text and style
        super(text, tbs);
    }
}
