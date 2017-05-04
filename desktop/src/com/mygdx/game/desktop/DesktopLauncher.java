package com.mygdx.game.desktop;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import com.badlogic.gdx.tools.texturepacker.TexturePacker;
import com.mygdx.game.Game;

public class DesktopLauncher {
	public static void main (String[] arg) {
		//TexturePacker.process("raw_textures/cards", "packed_textures/cards", "allcards");
		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
		config.resizable = false;
		config.width = LwjglApplicationConfiguration.getDesktopDisplayMode().width;
		config.height = LwjglApplicationConfiguration.getDesktopDisplayMode().height;
		config.fullscreen = false;
		config.useHDPI = false;
		config.foregroundFPS = 60;
		new LwjglApplication(new Game(), config);
	}
}
