package jks.ht.index.imageBank;

import java.util.HashMap;

import jks.tools2D.animation.Enum_AnimState;
import jks.tools2D.animation.sprite.SpriteModelData;

public class Index_Sprite 
{
	public static SpriteModelData little ; 
	
	public static void init()
	{
		HashMap<Enum_AnimState,String> map = new HashMap<Enum_AnimState,String>() ;
		map.put(Enum_AnimState.RUN, "Run") ; 
		map.put(Enum_AnimState.WALK, "Walk") ; 
		map.put(Enum_AnimState.IDLE, "Idle") ; 
		map.put(Enum_AnimState.WORK, "Idle") ;
		little = new SpriteModelData(map,1/18f,0.155f) ; 
	}
}
