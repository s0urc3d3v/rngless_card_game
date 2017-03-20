package com.mygdx.game.Views;

import com.mygdx.game.Game;

public class CardSelector extends View implements ViewSwitchListener {

    @Override
    public void render() {

    }

    @Override
    public void resize(int width, int height) {
        super.resize(width, height);
    }

    @Override
    public Game.viewIndexes update() {
        //Don't switch off CardSelector by default
        return returnIndex;
    }

    @Override
    public void create() {
        super.create();
    }


    @Override
    public void onSwitch(int switchingToIndex) {
        super.onSwitch(switchingToIndex);
        returnIndex = Game.viewIndexes.HOME;
    }
}
