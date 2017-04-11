package com.mygdx.game.Views;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.mygdx.game.Core.DB_tool;
import com.mygdx.game.Game;
import com.mygdx.game.UI.SimpleButton;

//import com.mygdx.game.Core.DatabaseTool;


public class Settings extends View implements ViewSwitchListener {
    private SimpleButton antialiasingToggle, gohome;
    private String AA = "Antialising";
    @Override
    public void render() {
        stage.draw();
        if (Gdx.input.isKeyPressed(Input.Keys.ESCAPE)){
            returnIndex = Game.viewIndexes.HOME;
        }
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
        DB_tool db_tool = new DB_tool();
        if ((db_tool.getPref("aa", "Boolean")) == null) antialiasingToggle = new SimpleButton(AA); //On by default
        else antialiasingToggle = new SimpleButton(AA + " " + db_tool.getPref("aa", "Boolean").toString());
        antialiasingToggle.addListener(new  ClickListener(){
            public void clicked(InputEvent event, float x, float y){
                DB_tool db_tool = new DB_tool();
                Boolean aaStatus = (Boolean) db_tool.getPref("aa", "Boolean");
                db_tool.addPref("aa", !aaStatus);

            }
        });



        Table table = new Table();
        assembleTable(table);
        stage.addActor(table);

    }
    private void assembleTable(Table table){
        table.setFillParent(true);
        table.center().center();
        table.add(antialiasingToggle).padBottom(10);
        table.row();
        table.add(gohome);
        table.row();
    }

    @Override
    public void onSwitch(int switchingToIndex) {
        super.onSwitch(switchingToIndex);
        returnIndex = Game.viewIndexes.SETTINGS;
    }
}

