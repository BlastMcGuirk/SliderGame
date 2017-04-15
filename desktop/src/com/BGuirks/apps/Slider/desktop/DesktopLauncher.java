package com.BGuirks.apps.Slider.desktop;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import com.BGuirks.apps.Slider.MainGame;

public class DesktopLauncher {
	public static void main (String[] arg) {
		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
        config.height = 1920/3;
        config.width = 1080/3;
		new LwjglApplication(new MainGame(), config);
	}
}
