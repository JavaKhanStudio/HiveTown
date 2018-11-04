package jks.tools2D.animation.spine.modif;

import com.badlogic.gdx.graphics.Color;

import jks.tools2D.animation.spine.model.enums.Enum_RefModif;

public class Modif_Color extends ModifModel
{
	
	String slot ;
	Color color ; 
	
	public Modif_Color(String Slot, Color Color)
	{
		modifType = Enum_RefModif.SET_COLOR ; 
		slot = Slot ; 
		color = Color ;
	}

	public String getSlot() 
	{return slot;}
	
	public Color getColor()
	{return color;}
	
}
