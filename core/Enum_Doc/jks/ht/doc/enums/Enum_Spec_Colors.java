package jks.ht.doc.enums;

import com.badlogic.gdx.graphics.Color;

public enum Enum_Spec_Colors
{
	Warhammer40_Contour("34634B",52,99,75,100),  // Contour du logo de warhammer 40k  
	WarhammerBa_Contour("F7E75F",247,231,95,100), // Contour du logo warhammer battle
	
	BTYPE_RESSOURCE("C60000",198,0,0,100),
	BTYPE_HABITATION("1D74DC",29,116,220,100),
	BTYPE_WAR("304921",48,73,33,100),
	 
	// Rust #B7410E
	// Poison #93e51e
	// Gold #ffd700
	
	;
	
	String hex ;
	int red, green, blue, trans ; 
	public Color color ; 
	
	Enum_Spec_Colors(String Hex, int Red,int Green,int Blue, int Trans)
	{
		hex = Hex ; 
		red = Red ; green = Green ; blue = Blue ; trans = Trans ; 
		color = new Color((float)red/255,(float)green/255,(float)blue/255,trans) ; 
	}
	
}

