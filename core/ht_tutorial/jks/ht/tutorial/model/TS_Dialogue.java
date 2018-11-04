package jks.ht.tutorial.model;

import static jks.tools2D.camera.GVars_Camera.render_ScreenFill;

import java.util.ArrayList;

import com.badlogic.gdx.graphics.glutils.ShapeRenderer.ShapeType;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.scenes.scene2d.Actor;

import jks.ht.index.imageBank.Index_PulsingType;

public class TS_Dialogue implements Tutorial_Step
{

	ArrayList<Vector2[]> listPointingTo ;
	boolean objectif = false ; 
	Tutorial ref ; 
	
	public TS_Dialogue(Tutorial Ref,String message)
	{
		ref = Ref ; 
	}
	
	@Override
	public void draw(float delta) 
	{
		if(listPointingTo == null)
			return ; 
		
		render_ScreenFill.begin(ShapeType.Line);
		Index_PulsingType.show_icon_SelectTutorial.nextCycle(delta);
		
		for(Vector2[] info : listPointingTo)
		{Index_PulsingType.show_icon_SelectTutorial.drawFor_Icon(info[0],info[1],render_ScreenFill);}
		
		render_ScreenFill.end();
	}
	
	public void addPointTo(Actor actor)
	{
		if(listPointingTo == null)
			listPointingTo = new ArrayList<Vector2[]>() ;
		
		Vector2[] sizePosition = new Vector2[2] ; 
		sizePosition[0] = new Vector2(actor.getX(),actor.getY()) ;
		sizePosition[1] = new Vector2(actor.getWidth(),actor.getHeight()) ;
	}
	
	@Override
	public void init()
	{}
	
	
	@Override
	public void read() 
	{
		init() ; 
		
		
	}
	
	@Override
	public boolean checkIfGood() 
	{return objectif;}
}
