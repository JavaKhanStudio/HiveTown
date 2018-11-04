package jks.tools.visual;

import static jks.ht.building.Vars.FVars_Building.lockRefX;
import static jks.ht.building.Vars.FVars_Building.lockRefY;
import static jks.ht.building.Vars.FVars_Building.roomSizeX;
import static jks.ht.building.Vars.FVars_Building.roomSizeY;
import static jks.tools2D.camera.GVars_Camera.*;

import java.util.ArrayList;
import java.util.ListIterator;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.ui.Button;
import com.badlogic.gdx.utils.Array;

import jks.ht.building.Vars.FVars_Building;
import jks.tools2D.camera.GVars_Camera;


public class PulsingShape
{

	int tempo ; 
	private float speed = 25; 
	private float maxDecal = 70; 
	
	int colorIndex = 0 ; 
	Array<ArrayList<Float>> pulses_position ; 
	Array<Color> pulses_color ;
	
	float currentTempo ; 
	
	Enum_ShapeType shape ; 
	boolean moveInner ;
	
	ListIterator<Float> ite ; 
	float currentValue ; 
	
	
	public PulsingShape(Array<Color> Pulses_color,int Tempo,int Speed, float MaxDecal, boolean MoveInner)
	{ 
		this(Pulses_color, Tempo, MoveInner) ;
		maxDecal = MaxDecal ;
		speed = Speed ;
	}
	
	
	public PulsingShape(Array<Color> Pulses_color,int Tempo,int Speed, boolean MoveInner)
	{ 
		this(Pulses_color, Tempo, MoveInner) ;
		speed = Speed ;
	}
	
	public PulsingShape(Array<Color> Pulses_color,int Tempo,boolean MoveInner)
	{
		tempo = Tempo ;
		moveInner = MoveInner ;
		currentTempo = tempo ; 
		pulses_color = Pulses_color ;
		pulses_position = new Array<ArrayList<Float>>() ;
		
		for(Color color : pulses_color)
		{pulses_position.add(new ArrayList<Float>());}
	}
	
	
	
	public void nextCycle(float delta)
	{
		currentTempo += delta * speed ;
		
		if(moveInner)
			cycleInner(delta) ;
		else
			cycleOuter(delta) ;
	}
	
	private void cycleInner(float delta)
	{
		if(currentTempo >= tempo)
		{
			currentTempo = 0 ; 
			
			colorIndex ++ ;
			if(colorIndex == pulses_color.size)
			{colorIndex = 0 ;}
				
			pulses_position.get(colorIndex).add(0f) ;
		}
		
		for(ArrayList<Float> list : pulses_position)
		{
			ite = list.listIterator() ;
			
			while(ite.hasNext())
			{
				currentValue = ite.next() ;
				
				if(currentValue > maxDecal)
				{ite.remove(); ;}
				else
				{ite.set(currentValue + (delta * speed ));}
			}
		}
	}
	
	private void cycleOuter(float delta)
	{
		if(currentTempo >= tempo)
		{
			currentTempo = 0 ; 
			
			colorIndex ++ ;
			if(colorIndex == pulses_color.size)
			{colorIndex = 0 ;}
				
			pulses_position.get(colorIndex).add(maxDecal) ;
		}
		
		for(ArrayList<Float> list : pulses_position)
		{
			ite = list.listIterator() ;
			
			while(ite.hasNext())
			{
				currentValue = ite.next() ;
				
				if(currentValue <= 0)
				{ite.remove(); ;}
				else
				{ite.set(currentValue - (delta * speed ));}
			}
		}
	}
	
	public void drawFor_Room(int x, int y, int sizeX,int sizeY)
	{
		for(int a = 0 ;  a < pulses_color.size ; a ++ )
		{
			render_ShapeLine.setColor(pulses_color.get(a));
			
			for(Float pos : pulses_position.get(a))
			{drawOverRoom(render_ShapeLine,pos,x,y,sizeX,sizeY) ;}
		}
	}
	
	public void drawFor_Icon(Vector2 position, Vector2 size,ShapeRenderer renderer)
	{
		for(int a = 0 ;  a < pulses_color.size ; a ++ )
		{
			renderer.setColor(pulses_color.get(a));
			for(Float pos : pulses_position.get(a))
			{drawFrom_Circle(renderer,pos,position.x,position.y,size.x,size.y) ;}
		}
	}
	
	private void drawOverRoom(ShapeRenderer renderer, float decal,int x,int y, int sizeX, int sizeY)
	{
		renderer.rect
		(
				lockRefX + (x * roomSizeX) + decal * 2, 
				lockRefY + (y * roomSizeY) + decal, 
				(FVars_Building.roomSizeX *  sizeX) - (decal * 4), 
				(FVars_Building.roomSizeY * sizeY) - (decal * 2)
		);
	}
	
	private void drawFrom_Circle(ShapeRenderer renderer, float decal,float posX,float posY, float sizeX, float sizeY)
	{	
		renderer.ellipse
		(
				posX - decal * 2, 
				posY - decal, 
				sizeX + (decal * 4), 
				sizeY + (decal * 2)
		);
	}
	
	
	
}
