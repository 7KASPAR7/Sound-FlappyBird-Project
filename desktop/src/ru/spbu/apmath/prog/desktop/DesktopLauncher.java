package ru.spbu.apmath.prog.desktop;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import ru.spbu.apmath.prog.MyFlappyVoiceGame;

public class DesktopLauncher {
	public static void main (String[] arg) {
		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
		config.width = 800	;
		config.height = 600;
		new LwjglApplication(new MyFlappyVoiceGame(), config);
	}
}