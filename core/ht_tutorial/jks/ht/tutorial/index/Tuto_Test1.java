package jks.ht.tutorial.index;

import java.util.LinkedList;

import jks.ht.interface2D.mainPage.Page_Main;
import jks.ht.tutorial.model.TS_PointToButton;
import jks.ht.tutorial.model.Tutorial;
import jks.ht.tutorial.model.Tutorial_Step;

public class Tuto_Test1 extends Tutorial
{

	public Tuto_Test1(Page_Main main)
	{
		steps = new LinkedList<Tutorial_Step>() ; 
		Tutorial_Step step1 = new TS_PointToButton(main.newGame) ;
		steps.add(step1) ; 
	}
	
	
}
