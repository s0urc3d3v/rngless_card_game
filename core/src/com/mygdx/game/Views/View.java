package com.mygdx.game.Views;

import com.mygdx.game.Game;

public abstract class View { //update, etc

    public abstract void render();

    //Return the index of the view to switch to that view.
    public abstract Game.viewIndexes update();
}
