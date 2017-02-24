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
//		TexturePacker.process("raw_textures", "packed_textures/cards", "allcards");
		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
		new LwjglApplication(new Game(), config);
	}
}
