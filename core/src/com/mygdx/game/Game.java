package com.mygdx.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.mygdx.game.Views.*;

public class Game extends ApplicationAdapter {

	View[] views = new View[4];
	int currentViewIndex = viewIndexes.HOME.getValue();

	private static Controller controller;

	@Override
	public void create () {
		//Adding in the Default Views
		views[viewIndexes.HOME.getValue()] = new Home();
		views[viewIndexes.HOME.getValue()].create();
		views[viewIndexes.CARDSELECTOR.getValue()] = new CardSelector();
		views[viewIndexes.BOARD.getValue()] = new Board();
		views[viewIndexes.BOARD.getValue()].create();
		views[viewIndexes.SETTINGS.getValue()] = new Settings();
		views[viewIndexes.SETTINGS.getValue()].create();
		controller = new Controller();
	}

	@Override
	public void render () {
		int startingIndex = currentViewIndex;

		//Clear the screen
		Gdx.gl.glClearColor(65/255f,105/255f,225/255f, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT | (Gdx.graphics.getBufferFormat().coverageSampling?GL20.GL_COVERAGE_BUFFER_BIT_NV:0));

		//Call the current views update.
		currentViewIndex = views[currentViewIndex].update().getValue();

		//Call the render of the current frame.
		views[currentViewIndex].render();

		//Check to see if the view was switched
		if(startingIndex != currentViewIndex) {
			Controller.callViewSwitch(currentViewIndex);
		}
	}

	@Override
	public void resize(int width, int height) {
		for(View view: views) {
			view.resize(width, height);
		}
	}

	//The Indexes of the current view for easy switching.
	public enum viewIndexes {
		HOME(0),
		CARDSELECTOR(1),
		BOARD(2),
		SETTINGS(3);

		private final int value;
		viewIndexes(int value) {
			this.value = value;
		}

		public int getValue() {
			return value;
		}
	}

	public static Controller getController() {
		return controller;
	}

	public void setCurrentViewIndex(int i) {
		currentViewIndex = i;
	}
}
