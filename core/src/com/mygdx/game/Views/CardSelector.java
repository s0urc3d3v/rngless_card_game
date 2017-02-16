package com.mygdx.game.Views;

import com.badlogic.gdx.math.Matrix4;
import com.mygdx.game.Game;

public class CardSelector extends View {
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

    }
}
