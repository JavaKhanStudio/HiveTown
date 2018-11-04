package jks.ht.desktop.test;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;

import jks.ht.main.test.Test_Image;
import jks.ht.main.test.Test_Interface;
import jks.ht.main.test.Test_UILabelText;
import jks.ht.main.test.UITest;
import jks.test.GifDecoding;

public class DesktopLauncher_Test_CheckForAnimation
{

	public static void main (String[] arg) 
	{
		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
		config.width = 750 ;
		config.height = 440 ;
		new LwjglApplication(new Test_UILabelText(), config);
		//new LwjglApplication(new UITest(), config);
//		new LwjglApplication(new Test_Image(), config);
	}
}
