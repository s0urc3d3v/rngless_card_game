package com.mygdx.game.textureAtlases;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;

import java.io.File;
import java.util.ArrayList;

/**
 * Created by matthewelbing on 16.02.17.
 */

public class CardAtlas {
    public static ArrayList<Skin> skins = new ArrayList<>();

    static {
        //Gets a list a files in the Cards asset directory
        File[] files = new File(System.getProperty("user.dir") + File.separator + "assets" + File.separator + "Cards").listFiles();

        //Adds all the card imgs to an array list as textures
        for (int i = 0; i < files.length; i++) {
            skins.add(new Skin(Gdx.files.internal(files[i].getPath())));
        }
    }

    public static ArrayList<Skin> getCards() {
        return skins;
    }
}
