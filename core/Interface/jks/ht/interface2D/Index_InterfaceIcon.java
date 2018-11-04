package jks.ht.interface2D;

import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;

import jks.ht.tools.Utils.Utils_Interface;

public class Index_InterfaceIcon 
{
	public static final String standarPath = "hiveView/icon/";
	public static final String generalPath = "general/icon/" ;
	
	
	public static TextureRegionDrawable icon_LevelUp ;
	
	public static TextureRegionDrawable icon_Cancel ;
	
	public static TextureRegionDrawable icon_build ;
	public static TextureRegionDrawable icon_missions ;
	public static TextureRegionDrawable icon_stats ;

	
	
	
	public static void init()
	{
		
		icon_build = Utils_Interface.buildDrawingRegionTexture(standarPath + "build.png") ;
		icon_missions = Utils_Interface.buildDrawingRegionTexture(standarPath + "missions.png") ;
		icon_stats = Utils_Interface.buildDrawingRegionTexture(standarPath + "stats.png") ;
		
		icon_LevelUp = Utils_Interface.buildDrawingRegionTexture(generalPath + "upgrade.png") ;
		icon_Cancel = Utils_Interface.buildDrawingRegionTexture(generalPath + "cancel.png") ;
		
	}
	
	
}
