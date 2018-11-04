package jks.ht.interface2D.hiveView;

import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;

import jks.ht.interface2D.GVars_Interface;
import jks.ht.interface2D.Init_UI;

public class Page_HiveView extends Table
{

	public SubPage_Interaction interactionSection ; 
	public SubPage_HiveView_Ressource ressourceSection ; 
	
    public Page_HiveView()
	{
		this.setFillParent(true);
		this.setLayoutEnabled(false);
		
		interactionSection = new SubPage_Interaction() ; 
		ressourceSection = new SubPage_HiveView_Ressource() ; 
		
		this.add(interactionSection) ; 
        this.add(ressourceSection) ;
        GVars_Interface.mainInterface.addActor(this);
	}
	
	
	
	TextButton button (String text, boolean toggle) 
	{
		TextButton button = new TextButton(text, Init_UI.loadSkin(), toggle ? "toggle" : "default");
		button.pad(20, 20, 20, 20);
		return button;
	}
	
	public SubPage_Interaction getInteractionSection()
	{return interactionSection;}

	public void setInteractionSection(SubPage_Interaction interactionSection) 
	{this.interactionSection = interactionSection;}

	public SubPage_HiveView_Ressource getRessourceSection()
	{return ressourceSection;}

	public void setRessourceSection(SubPage_HiveView_Ressource ressourceSection) 
	{this.ressourceSection = ressourceSection;}


	
}
