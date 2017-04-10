package com.mygdx.game.Views;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.mygdx.game.Controller;
import com.mygdx.game.Game;

public abstract class View implements ViewSwitchListener {

    protected Stage stage;
    //Set the return index to default to this class.
    protected Game.viewIndexes returnIndex = Game.viewIndexes.valueOf(getClass().getSimpleName().toUpperCase());

    public abstract void render();

    public void resize(int width, int height) {
        if(stage != null) {
            stage.getViewport().update(width, height, true);


        }
    }

    //Return the index of the view to switch to that view.
    public abstract Game.viewIndexes update();

    //Initialise objects in this function
    public void create() {
        stage = new Stage();
        Controller.attachListener(this);
    }

    public void onSwitch(int switchingToIndex) {
        //If Enum is equal to this class name then set us to the input processor
        if(switchingToIndex == Game.viewIndexes.valueOf(getClass().getSimpleName().toUpperCase()).getValue()) {
            Gdx.input.setInputProcessor(stage);
        }
    }

}
