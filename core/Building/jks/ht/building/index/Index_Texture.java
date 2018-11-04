package jks.ht.building.index;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;

import jks.ht.Vars.GVars_Heart;

public class Index_Texture implements Runnable
{
	public static Texture UnderGround; 
	public static Texture Tower; 
	public static Texture Base; 
	
	public static void init()
	{
		UnderGround  = new Texture(Gdx.files.internal("building/wallTexture/rust_3.png"));
		Tower =  new Texture(Gdx.files.internal("building/wallTexture/rust_4.png"));
		Base =  new Texture(Gdx.files.internal("building/wallTexture/rust_5.jpg"));
	}
	
	public static void initClean()
	{
		GVars_Heart.assets.load("building/wallTexture/rust_3.png", Texture.class);
		GVars_Heart.assets.load("building/wallTexture/rust_4.png", Texture.class);
		GVars_Heart.assets.load("building/wallTexture/rust_5.jpg", Texture.class);
	}
	
	
	@Override
	public void run()
	{init() ; }
}
	