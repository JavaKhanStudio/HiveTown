package jks.ht.view.m.vue;

import java.util.ArrayList;

import com.esotericsoftware.spine.SkeletonRenderer;

import jks.ht.Vars.GVars_Heart;
import jks.ht.interface2D.GVars_Interface;
import jks.ht.interface2D.overlay.OverlayModel;
import jks.ht.models.ToRender;
import jks.ht.tutorial.model.Tutorial;
import jks.ht.view.m.filter.AView_Model_Filter;

public abstract class AVue_Model 
{

	public static SkeletonRenderer skeletonRenderer = new SkeletonRenderer();
	
	public ArrayList<ToRender> toRender ; 
	
	public OverlayModel overlay ; 
	public AView_Model_Filter filter ; 
	public Tutorial tutorial ;  
	
	
	public abstract void init() ;
	public abstract void destroy() ;
	public abstract void restart() ; 
	
	public abstract void update (float delta) ;
	public abstract void render (float delta) ;
	
	
	public void clear()
	{
		GVars_Heart.viewport.apply();
	}
	
	public void renderBeforeInterface()
	{
		for(ToRender rende : toRender)
		{rende.render();}
		
		if(filter != null)
		{filter.draw();}
	}
	
	public void drawInterface(float delta)
	{
		GVars_Interface.mainInterface.draw() ;
		
		if(tutorial != null)
		{tutorial.render(delta) ;}
	}

	public Tutorial getTutorial() 
	{return tutorial;}
	
	public void setTutorial(Tutorial tutorial) 
	{this.tutorial = tutorial;}
	
	public void nextTutorialStep()
	{tutorial.nextStep();}
	
	public void setAsTutorial() 
	{}
}
