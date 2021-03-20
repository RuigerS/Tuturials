package nl.firstact.flappeebee.desktop;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import com.badlogic.gdx.tools.texturepacker.TexturePacker;
import nl.firstact.flappeebee.FlappeeBeeGame;

public class DesktopLauncher {
	public static void main (String[] arg) {
		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
		config.height=320;
		config.width=240;
		TexturePacker.process("./core/assets", "./core/assets", "flappee_bee_assets");
		new LwjglApplication(new FlappeeBeeGame(), config);
	}
}
