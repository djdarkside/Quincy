package com.djdarkside.quincy.desktop;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import com.djdarkside.quincy.Application;

public class DesktopLauncher {
	public static void main (String[] arg) {
		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
		new LwjglApplication(new Application(), config);
		config.title = Application.TITLE + " v" + Application.VERSION;
		config.width = Application.V_WIDTH;
		config.height = Application.V_HEIGHT;
		config.backgroundFPS = 60;
		config.foregroundFPS = 60;
		config.resizable = false;
	}
}
