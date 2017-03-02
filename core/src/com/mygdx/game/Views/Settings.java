package com.mygdx.game.Views;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.InputListener;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.mygdx.game.Core.DatabaseTool;
import com.mygdx.game.Core.ResourceFetcher;
import com.mygdx.game.Game;
import com.mygdx.game.UI.SimpleButton;
import com.sun.xml.internal.txw2.Document;
import org.omg.CORBA.PRIVATE_MEMBER;
import org.xml.sax.SAXException;

import javax.xml.crypto.Data;
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
    private String AAon = "Antialising on";
    private String AAoff = "Antialising off";
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

        antialiasingToggle = new SimpleButton(AAon); //On by default

        antialiasingToggle.addListener(new ClickListener(){
            public void clicked(InputEvent event, float x, float y){
                DatabaseTool.init();
                if (DatabaseTool.getPreference("AA") != null){
                    DatabaseTool.updatePreference("AA");
                }
                else {
                    DatabaseTool.addPreference("AA", false);
                }
            }
        }

        Table table = new Table();
        assembleTable(table);
        stage.addActor(table);

    }
    private void assembleTable(Table table){
        table.setFillParent(true);
        table.center().center();
        table.add(antialiasingToggle);
        table.row();
    }

    @Override
    public void onSwitch(int switchingToIndex) {
        super.onSwitch(switchingToIndex);
        returnIndex = Game.viewIndexes.SETTINGS;
    }
}

