package com.mygdx.game.desktop;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import com.badlogic.gdx.tools.texturepacker.TexturePacker;
import com.badlogic.gdx.utils.XmlReader;
import com.mygdx.game.Game;
import jdk.internal.util.xml.XMLStreamException;
import jdk.nashorn.internal.ir.debug.JSONWriter;
import com.badlogic.gdx.utils.XmlWriter;

import java.io.*;

public class DesktopLauncher {
	public static void main (String[] arg) {
		//TexturePacker.process("raw_textures/buttons", "packed_textures/buttons", "buttons");
		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
		config.fullscreen = true;
		config.resizable = false;
		new LwjglApplication(new Game(), config);
	}
}
