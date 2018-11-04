package jks.tools2D.inputs;

import jks.ht.building.room.ARoom_Model;
import jks.ht.tools.model.Vector2Int;

public class GVars_Inputs 
{
	public static boolean touched, 
		upPressed, downPressed,
		leftPressed, rightPressed,
		zoomInPressed, zoomOutPressed 
		;
	
	public static int startSelection_X ;
	public static int startSelection_Y ;
	
	public static ARoom_Model currentSelected  ;
	public static boolean blockActionForClick ; // Considere s'il faut annuler toute autre action de click

	

}
