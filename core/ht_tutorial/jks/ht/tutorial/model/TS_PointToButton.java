package jks.ht.tutorial.model;

import static jks.tools2D.camera.GVars_Camera.render_ScreenFill;

import com.badlogic.gdx.graphics.glutils.ShapeRenderer.ShapeType;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.ui.Button;
import com.badlogic.gdx.scenes.scene2d.utils.ChangeListener;

import jks.ht.Vars.GVars_Heart;
import jks.ht.index.imageBank.Index_PulsingType;

public class TS_PointToButton implements Tutorial_Step
{
	boolean objectif = false ; 
	private Button button ; 
	Vector2 actorPosition ;
	Vector2 actorSize ; 
	
	// Do to post init
	public TS_PointToButton()
	{}
	
	public TS_PointToButton(Button Button)
	{setButton(Button);}
	
	@Override
	public void init()
	{}
	
	
	@Override
	public void read() 
	{
		init() ;
		GVars_Heart.setAsTutorial() ; 
		button.setDisabled(false);
		
		if(button != null)
		{
			button.addListener(new ChangeListener() 
			{
				public void changed (ChangeEvent event, Actor actor) 
				{objectif = true ;}
			});
		}
		else
		{objectif = true ; }		
	}
	
	@Override
	public boolean checkIfGood() 
	{return objectif;}

	@Override
	public void draw(float delta) 
	{
		render_ScreenFill.begin(ShapeType.Line);
		Index_PulsingType.show_icon_SelectTutorial.nextCycle(delta);
		Index_PulsingType.show_icon_SelectTutorial.drawFor_Icon(actorPosition,actorSize,render_ScreenFill);	
		render_ScreenFill.end();
	}
	
	public Button getButton()
	{return button ;}
	
	public void setButton(Button Button)
	{
		button = Button ; 
		actorPosition = button.localToStageCoordinates(new Vector2(0, 0));
		actorSize = new Vector2(button.getWidth(), button.getHeight()) ; 
		
	}
}
