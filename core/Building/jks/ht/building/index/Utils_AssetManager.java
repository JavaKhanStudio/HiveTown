package jks.ht.building.index;

import com.badlogic.gdx.graphics.Texture;

import jks.ht.Vars.GVars_Heart;

public class Utils_AssetManager
{

	
	public static Texture getTexture(String name)
	{return GVars_Heart.assets.get(name, Texture.class) ;}
	
	
	
}
