package jks.ht.index.imageBank;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.Animation.PlayMode;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;

import jks.tools2D.animation.gif.GifModelData;

public class Index_Sign 
{

	public static GifModelData plus ; 
	public static GifModelData minus ; 
	
	
	private static final String path = "sign/"; 
	public static void init()
	{
		TextureAtlas textureAtlas_plus = new TextureAtlas(Gdx.files.internal(path + "plus.atlas"));
		plus = new GifModelData(new Animation(1/10f, textureAtlas_plus.findRegions("add"),PlayMode.LOOP_PINGPONG)) ;
		
		TextureAtlas textureAtlas_minus = new TextureAtlas(Gdx.files.internal(path + "minus.atlas"));
		minus = new GifModelData(new Animation(1/12f, textureAtlas_minus.findRegions("minus"),PlayMode.LOOP_PINGPONG)) ; 
	}

}
