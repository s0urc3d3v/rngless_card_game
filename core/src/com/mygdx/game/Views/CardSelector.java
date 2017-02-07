package com.mygdx.game.Views;

import com.mygdx.game.Game;

public class CardSelector extends View {
    @Override
    public void render() {

    }

    @Override
    public Game.viewIndexes update() {
        //Don't switch off CardSelector by default
        return Game.viewIndexes.CARD_SELECT;
    }
}
