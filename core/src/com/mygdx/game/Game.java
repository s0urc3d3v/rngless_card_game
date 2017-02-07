package com.mygdx.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.mygdx.game.Views.Home;
import com.mygdx.game.Views.View;

public class Game extends ApplicationAdapter {
	SpriteBatch batch;
	Home currentView = new Home();

	@Override
	public void create () {
		batch = new SpriteBatch();
	}

	@Override
	public void render () {
		Gdx.gl.glClearColor(1, 0, 0, 1);
	    Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

		currentView.update();
		currentView.render();

//		batch.begin();
//		batch.end();
	}
	
	@Override
	public void dispose () {
		batch.dispose();
	}
}
