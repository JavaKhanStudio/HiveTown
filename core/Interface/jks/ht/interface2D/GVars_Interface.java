package jks.ht.interface2D;

import java.util.ArrayList;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;

import jks.ht.interface2D.hiveView.SubPage_Interaction;
import jks.ht.models.ToRender;

public class GVars_Interface implements Runnable
{

	public static Skin baseSkin ;
	public static Stage mainInterface ;
	public static SubPage_Interaction interaction ; 
	public static ArrayList<ToRender> toRenderGif ;
	
	public static void init()
	{
		Index_InterfaceIcon.init() ;
		baseSkin = Init_UI.loadSkin() ;
		mainInterface = new Stage();
		Gdx.input.setInputProcessor(GVars_Interface.mainInterface);
		toRenderGif = new ArrayList<ToRender>() ; 
	}
	
	public static void reset()
	{
		mainInterface = new Stage();
		Gdx.input.setInputProcessor(GVars_Interface.mainInterface);
		toRenderGif = new ArrayList<ToRender>() ; 
	}
	
	public static void renderGifs()
	{
		for(ToRender rende : toRenderGif)
		{rende.render();}
	}
	
	@Override
	public void run()
	{init() ; }
	
}
