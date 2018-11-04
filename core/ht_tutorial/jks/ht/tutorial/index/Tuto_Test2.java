package jks.ht.tutorial.index;

import java.util.LinkedList;

import jks.ht.doc.enums.Enum_Spec_Room;
import jks.ht.interface2D.overlay.constructionChoice.Overlay_ConstructionChoice;
import jks.ht.tutorial.model.TS_Dialogue;
import jks.ht.tutorial.model.TS_PointToButton;
import jks.ht.tutorial.model.Tutorial;
import jks.ht.tutorial.model.Tutorial_Step;
import jks.ht.view.m.vue.Vue_Game;
import jks.tools2D.view.utils.Utils_View;

public class Tuto_Test2 extends Tutorial
{

	public Tuto_Test2(Vue_Game main)
	{
		steps = new LinkedList<Tutorial_Step>() ; 
		
		Tutorial_Step step0 = new TS_Dialogue(this,"Test this!") ;
		Tutorial_Step step1 = new TS_PointToButton(main.getInterface().getInteractionSection().getBuildIcon()) ;
		Tutorial_Step step2 = new TS_PointToButton(main.getInterface().getInteractionSection().getBuildIcon())
		{
			@Override
			public void init()
			{
				((Overlay_ConstructionChoice)Utils_View.getOverlay()).setToTutorial();
				setButton(((Overlay_ConstructionChoice)Utils_View.getOverlay()).getButton(Enum_Spec_Room.FOOD)) ;
			}
		} ;
		
		Tutorial_Step step3 = new TS_Dialogue(this,"Test this!") ;
		
		steps.add(step1) ;
		steps.add(step2) ; 	 
	}
	
	
}
