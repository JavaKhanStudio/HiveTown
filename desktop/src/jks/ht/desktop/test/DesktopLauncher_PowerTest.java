package jks.ht.desktop.test;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;

import jks.ht.main.HiveTown_App;

public class DesktopLauncher_PowerTest 
{
	public static void main (String[] arg) 
	{
		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
		//config.width = 750 ;
		//config.height = 440 ;
		config.vSyncEnabled = false ; 
		config.foregroundFPS = 0 ; 
		config.backgroundFPS = 0 ; 
		config.width = (int) (750 * 1.3) ;
		config.height = (int) (440 * 1.3) ;
		new LwjglApplication(new HiveTown_App(), config);
		//new LwjglApplication(new State_Game(), config);
	}
}
