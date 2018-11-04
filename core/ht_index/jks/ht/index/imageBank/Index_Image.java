package jks.ht.index.imageBank;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;

public class Index_Image 
{
	public static Texture logo ;

	public static void init()
	{
		logo = new Texture(Gdx.files.internal("background/background.jpg"));
	}
}
