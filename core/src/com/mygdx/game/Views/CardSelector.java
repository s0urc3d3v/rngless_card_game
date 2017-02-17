package com.mygdx.game.Views;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.math.Matrix4;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.mygdx.game.Controller;
import com.mygdx.game.Game;

public class CardSelector extends View implements ViewSwitchListener {
    private Game.viewIndexes returnIndex;
    private Stage stage;

    @Override
    public void render() {

    }

    @Override
    public void resize(int width, int height) {

    }

    @Override
    public Game.viewIndexes update() {
        //Don't switch off CardSelector by default
        return Game.viewIndexes.CARD_SELECT;
    }

    @Override
    public void create() {
        Controller.attachListener(this);
        stage = new Stage();
    }


    @Override
    public void onSwitch(int switchingToIndex) {
        if(switchingToIndex == Game.viewIndexes.HOME.getValue()) {
            //This switch is to our view
            //Then we should be taking the input now
            Gdx.input.setInputProcessor(stage);
        } else {
            //We are switching off this screen and should make sure to set back our return index
            returnIndex = Game.viewIndexes.HOME;
        }
    }
}
