package com.mygdx.game.desktop;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import com.badlogic.gdx.tools.texturepacker.TexturePacker;
import com.mygdx.game.Game;

import java.awt.*;

public class DesktopLauncher {
	public static void main (String[] arg) {
//		TexturePacker.process("raw_textures/cards", "packed_textures/cards", "allcards");
		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
		//config.fullscreen = true;
		//config.useHDPI = true;
		config.foregroundFPS = 60;
		config.setFromDisplayMode(LwjglApplicationConfiguration.getDesktopDisplayMode());
		new LwjglApplication(new Game(), config);
	}
}
