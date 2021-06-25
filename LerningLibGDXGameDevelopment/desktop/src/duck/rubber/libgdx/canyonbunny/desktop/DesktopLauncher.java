package duck.rubber.libgdx.canyonbunny.desktop;

import com.badlogic.gdx.Files;
import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import duck.rubber.libgdx.canyonbunny.CanyonBunnyMain;

public class DesktopLauncher {
	public static void main (String[] arg) {
		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
		config.width=800;
		config.height=480;
		config.title="Canyon Bunny";
		config.addIcon("icons/ic_launcher_128.png", Files.FileType.Internal);
		config.addIcon("icons/ic_launcher_32.png", Files.FileType.Internal);
		config.addIcon("icons/ic_launcher_16.png", Files.FileType.Internal);
		new LwjglApplication(new CanyonBunnyMain(), config);
	}
}
