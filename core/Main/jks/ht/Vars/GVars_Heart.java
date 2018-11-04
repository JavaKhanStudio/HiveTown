package jks.ht.Vars;

import java.util.Random;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.maps.tiled.TmxMapLoader;
import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.utils.viewport.ExtendViewport;

import jks.ht.building.index.Index_Texture;
import jks.ht.doc.enums.Index_RoomType_Gif;
import jks.ht.format.Hive_OM_Building;
import jks.ht.gamelogic.drones.DroneGroup;
import jks.ht.index.imageBank.Index_Speaker;
import jks.ht.index.imageBank.Index_Image;
import jks.ht.index.imageBank.Index_PulsingType;
import jks.ht.index.imageBank.Index_Sign;
import jks.ht.interface2D.GVars_Interface;
import jks.ht.save.Main_Save_File;
import jks.ht.tools.model.PosPool;
import jks.ht.tutorial.model.Tutorial;
import jks.ht.view.m.vue.AVue_Model;
import jks.ht.view.m.vue.Vue_Game;
import jks.tools2D.animation.spine.model.SpineModel;
import jks.tools2D.camera.GVars_Camera;
import jks.tools2D.tools.GlobalTimmer;

public class GVars_Heart 
{
	public static Array<SpineModel> drawinglist_Spine = new Array<SpineModel>() ;
	
	public static boolean debbug = true; 
	public static AVue_Model vue;
	public static float scale = 1 / 64f;
	public static TiledMap map ; 
	public static final int fps = 60 ; 
	
	public static final String mapName = "map/FirstMap.tmx" ; 
	
	public static final PosPool positionPool = new PosPool();
	
	public static final Random random = new Random() ;
	
	public static int screenSizeX ; 
	public static int screenSizeY ; 
	
	public static Main_Save_File save; 
	
	public static AssetManager assets = new AssetManager();
	
	public static boolean full = false ;  
	
	public static void init()
	{
		assets = new AssetManager();
		GlobalTimmer.registerTime("HEART") ; 
		
		GVars_Camera.init(); GlobalTimmer.getElapse("HEART",true) ; 
		GVars_Interface.init(); GlobalTimmer.getElapse("HEART",true) ; 
		
		
		Index_Texture.init(); GlobalTimmer.getElapse("HEART",true) ; 
		Index_Image.init(); GlobalTimmer.getElapse("HEART",true) ;
		Index_Speaker.init(); GlobalTimmer.getElapse("HEART",true) ;
		
		if(full)
			Index_RoomType_Gif.init(); GlobalTimmer.getElapse("HEART",true) ; 
		
		Index_Sign.init(); GlobalTimmer.getElapse("HEART",true) ; 
		Index_PulsingType.init() ; GlobalTimmer.getElapse("HEART",true) ; 
		
		screenSizeX = Gdx.graphics.getWidth() ; 
		screenSizeY = Gdx.graphics.getHeight();	
	}
	
	public static void initMap(String mapName)
	{
		map = new TmxMapLoader().load(mapName);
		GVars_Camera.initMapVisual(map);
	}
	
	public static void changeView(AVue_Model View)
	{
		if(View != null)
		{
			vue = View ; 
			vue.init();
		}
		else
		{System.out.println("Aucune view?");}
	}
	
	public static void load()
	{
		newGame() ; //TODO Actully load 
	}
	
	public static void newGame()
	{
		new Main_Save_File() ; 
	}
	
	private static long diff, start = System.currentTimeMillis();

	public static void sleep() 
	{
	    if(fps>0)
	    {
	      diff = System.currentTimeMillis() - start;
	      long targetDelay = 1000/fps;
	      if (diff < targetDelay) 
	      {
	        try
	        {Thread.sleep(targetDelay - diff);} 
	        catch (InterruptedException e) {}
	      }   
	      start = System.currentTimeMillis();
	    }
	}

	public static Hive_OM_Building getHive()
	{return save.getHiveBuildings();}
	
	public static ExtendViewport viewport;

	public static void addDroneGroup(DroneGroup finalGroup) 
	{
		if(vue != null && vue instanceof Vue_Game)
		{
			((Vue_Game)vue).droneGroup.add(finalGroup) ;
		}
		
	}

	public static Tutorial getTutorial()
	{return vue.tutorial ;}
	
	public static void setAsTutorial() 
	{vue.setAsTutorial() ;}
}
