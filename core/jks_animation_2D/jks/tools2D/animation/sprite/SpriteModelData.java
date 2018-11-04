package jks.tools2D.animation.sprite;

import java.util.HashMap;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

import jks.tools2D.animation.Enum_AnimState;

public class SpriteModelData 
{
	HashMap<Enum_AnimState,Animation<TextureRegion>> animationList ;
	float scale ;
	
	public SpriteModelData(HashMap<Enum_AnimState,String> animationName, float animationSpeed, float Scale)
	{
		TextureAtlas textureAtlas = new TextureAtlas(Gdx.files.internal("cuteGirl/libTest.atlas"));
		animationList = new HashMap<Enum_AnimState,Animation<TextureRegion>>() ;
		
		for(Enum_AnimState finalName : animationName.keySet())
		{
			animationList.put(finalName, new Animation(animationSpeed, textureAtlas.findRegions(animationName.get(finalName)))) ;
		}
	
	
		scale = Scale ; 
	}
	
	
}
