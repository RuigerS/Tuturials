package com.packt.snake.desktop;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import com.packt.snake.SnakeGame;

public class DesktopLauncher {

	public static void main (String[] arg) {
		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
		//16:9 640:360 1024:576 1152:648 1280:720 1366:768
		config.width=1024;
		config.height=576;
		new LwjglApplication(new SnakeGame(), config);
	}
}
