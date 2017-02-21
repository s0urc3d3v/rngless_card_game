package com.mygdx.game.Views;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.mygdx.game.Game;
import com.mygdx.game.UI.SimpleButton;
import com.sun.xml.internal.txw2.Document;
import org.omg.CORBA.PRIVATE_MEMBER;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.io.*;
import java.util.*;
/**
 * Created by matthewelbing on 17.02.17.
 */
public class Settings extends View implements ViewSwitchListener {
    private SimpleButton antialiasingToggle;
    @Override
    public void render() {
        stage.draw();
    }
    @Override
    public void resize(int width, int height) {
        super.resize(width, height);
    }

    @Override
    public Game.viewIndexes update() {
        //Don't switch off Home by default
        return returnIndex;
    }
    @Override
    public void create() {
        super.create();

        antialiasingToggle = new SimpleButton("PLACEHOLDER");



    }

    @Override
    public void onSwitch(int switchingToIndex) {
        super.onSwitch(switchingToIndex);
        returnIndex = Game.viewIndexes.SETTINGS;
    }
}

