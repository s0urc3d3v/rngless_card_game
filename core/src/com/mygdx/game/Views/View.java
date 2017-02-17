package com.mygdx.game.Views;

import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.math.Matrix4;
import com.badlogic.gdx.utils.viewport.Viewport;
import com.mygdx.game.Game;

public abstract class View {

    public abstract void render();

    public abstract void resize(int width, int height);

    //Return the index of the view to switch to that view.
    public abstract Game.viewIndexes update();

    //Initialise objects in this function
    public abstract void create();

}
