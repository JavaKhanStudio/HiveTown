package jks.ht.tutorial.model;

import java.util.Iterator;
import java.util.LinkedList;

import jks.ht.Vars.GVars_Heart;
import jks.ht.interface2D.dialogue.DialogueBox;

public class Tutorial 
{

	protected LinkedList<Tutorial_Step> steps  ; 
	protected Iterator<Tutorial_Step> iterator ;
	protected Tutorial_Step currentSteps ;
	protected DialogueBox dialogue ; 
	
	public void nextStep()
	{
		if(iterator == null)
		{iterator = steps.iterator() ;}
		
		if(iterator.hasNext())
		{
			currentSteps = iterator.next() ; 
			currentSteps.read();
		}
		else
		{
			currentSteps = null ; 
			GVars_Heart.vue.setTutorial(null);
		}
	
	}
	
	public void render(float delta)
	{
		if(currentSteps != null)
		{
			if(currentSteps.checkIfGood())
				nextStep() ;
			
			draw(delta) ; 
		}	
	}
	
	private void draw(float delta)
	{
		if(currentSteps != null)
			currentSteps.draw(delta);
	}
}
