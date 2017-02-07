package com.mygdx.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.mygdx.game.Views.Board;
import com.mygdx.game.Views.CardSelector;
import com.mygdx.game.Views.Home;
import com.mygdx.game.Views.View;

import java.util.List;

public class Game extends ApplicationAdapter {
	SpriteBatch batch;
	View[] views = new View[3];
	int currentViewIndex = viewIndexes.HOME.getValue();

	@Override
	public void create () {
		//Adding in the Default Views
		views[viewIndexes.HOME.getValue()] = new Home();
		views[viewIndexes.CARD_SELECT.getValue()] = new CardSelector();
		views[viewIndexes.BOARD.getValue()] = null; //Dont set a default board.
	}

	@Override
	public void render () {
		//Clear the screen
		Gdx.gl.glClearColor(65/255f,105/255f,225/255f, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

		//Call the current views methods.
		currentViewIndex = views[currentViewIndex].update().getValue();
		views[currentViewIndex].render();
	}

	@Override
	public void dispose () {
		batch.dispose();
	}

	//The Indexes of the current view for easy switching.
	public enum viewIndexes {
		HOME(0),
		CARD_SELECT(1),
		BOARD(2);

		private final int value;
		viewIndexes(int value) {
			this.value = value;
		}

		public int getValue() {
			return value;
		}
	}
}
