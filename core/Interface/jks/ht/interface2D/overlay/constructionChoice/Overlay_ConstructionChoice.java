package jks.ht.interface2D.overlay.constructionChoice;

import java.util.HashMap;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.scenes.scene2d.ui.Button;
import com.badlogic.gdx.scenes.scene2d.ui.Label;

import jks.ht.Vars.GVars_Heart;
import jks.ht.doc.enums.Enum_Spec_Room;
import jks.ht.interface2D.GVars_Interface;
import jks.ht.interface2D.overlay.OverlayModel;
import jks.tools2D.view.utils.Utils_View;

public class Overlay_ConstructionChoice extends OverlayModel
{
	private Label topLabel ; 
	private Overlay_ConstructionChoice ref = this; 
	private Overlay_ConstructionChoice_Icon subPage ; 
	public static Overlay_ConstructionChoice_Icon currentSelected ; 
	public static Overlay_ConstructionChoice_SelectedInfo currentInfo ; 
	
	public static int iconSizeX ;
	public static int iconSizeY ; 
	private int iconSpaceY ; 
	
	private int sideDecalX ;
	private int middleDecalX ; 
	int sideDecalY ;
	private int diffDecal = 25 ;
	private int labelDecal = 20 ; 
	private int decalY = 0 ;
	
	HashMap<Enum_Spec_Room, Button> buttonMap ; 
	
	public Overlay_ConstructionChoice()
	{
		super("Construction Choice" , GVars_Interface.baseSkin) ;
		buttonMap = new HashMap<Enum_Spec_Room, Button>() ; 
		this.setLayoutEnabled(false);
		this.setFillParent(true);
		this.setBounds(0, 0, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
		iconSizeX = Gdx.graphics.getWidth()/ 12 ;
		iconSizeY = iconSizeX ; 
		
		diffDecal = (int) (iconSizeX * 1.5f) ;
		sideDecalX = (int) (Gdx.graphics.getWidth()/14) ;
		middleDecalX = iconSizeX + 20; 
		sideDecalY = (int) (Gdx.graphics.getHeight() * 2 / 3) ;
		decalY = iconSizeY * 1/8 ;
		
		// RESSOURCE SECTION
		buildLabel("| Ressource |",1) ;
		buildIcon(Enum_Spec_Room.FOOD,1,1) ;
		buildIcon(Enum_Spec_Room.INDUSTRIE,1,2) ;
		buildIcon(Enum_Spec_Room.SILOS,1,3) ;
		
		buildLabel("|  Housing  |",2) ;
		buildIcon(Enum_Spec_Room.HOME,2,1) ;
		buildIcon(Enum_Spec_Room.CHURCH,2,2) ;
		buildIcon(Enum_Spec_Room.ADMIN,2,3) ;
		
		buildLabel("|    War   |",3) ;
		buildIcon(Enum_Spec_Room.WEAPON,3,1) ;
		buildIcon(Enum_Spec_Room.TRAINING,3,2) ;
		buildIcon(Enum_Spec_Room.BARRACK,3,3) ;
		
		currentInfo = new Overlay_ConstructionChoice_SelectedInfo(this) ; 
		
		this.addActor(GVars_Interface.interaction.turnIntoDeselection()) ; 
		this.addActor(currentInfo) ;
	}

	public void buildIcon(Enum_Spec_Room type, int x, int y)
	{
		subPage = new Overlay_ConstructionChoice_Icon(type) ;
		
		subPage.setBounds(
				getPositionX(x),
				getPositionY(y),
				iconSizeX, iconSizeY);
		
		this.addActor(subPage);
		buttonMap.put(type, subPage.icon) ;
	}
	
	public float getPositionX(int x)
	{return (sideDecalX) + (iconSizeX/2 * (x-1)) + (middleDecalX * (x-1)) ;}
	
	public float getPositionY(int y)
	{return sideDecalY - ((decalY * (y-1)) + (iconSizeX * y)) ;}
	
	public void buildLabel(String value,int x)
	{
		topLabel = new Label(value, GVars_Interface.baseSkin) ;
		topLabel.setBounds(
				getPositionX(x) - (labelDecal/2),
				sideDecalY, 
				iconSizeX + labelDecal, 
				iconSizeY);
		
		topLabel.setAlignment(0);
		this.addActor(topLabel);	
	}

	public static void unselect()
	{
		if(currentSelected != null)
		{
			currentSelected.maskAsDeselected() ; 
			currentInfo.deselect() ; 
		}
			
	}
	
	public void setToTutorial()
	{
		for(Button button : buttonMap.values())
		{button.setDisabled(true);}
	}

	@Override
	public void destroy()
	{this.remove() ;}

	public Button getButton(Enum_Spec_Room type)
	{return buttonMap.get(type) ;}

	public static void build()
	{
		Utils_View.setOverlay(new Overlay_ConstructionChoice());
	}
	
	@Override
	public boolean disableMainClickAction() 
	{return true;}
	
}
