package com.mygdx.game.textureAtlases;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;

import java.io.File;
import java.util.ArrayList;

/**
 * Created by matthewelbing on 16.02.17.
 */

public class CardAtlas {
    public static ArrayList<Texture> skins = new ArrayList<>();

    static {
        //Gets a list a files in the Cards asset directory
        File[] files = new File(System.getProperty("user.dir") + File.separator + "assets" + File.separator + "Cards").listFiles();

        //Adds all the card imgs to an array list as textures
        if (files != null) {
            for (int i = 0; i < files.length; i++) {
                skins.add(new Texture(Gdx.files.internal(files[i].getPath())));
            }
        }
    }

    public static ArrayList<Texture> getCards() {
        return skins;
    }
}
