package jks.tools2D.inputs;

import com.badlogic.gdx.math.Vector3;

import jks.ht.Vars.GVars_Heart;
import jks.ht.building.room.ARoom_Model;
import jks.ht.interface2D.overlay.Overlay_RoomSelection;
import jks.ht.tools.model.Vector2Int;
import jks.tools2D.camera.GVars_Camera;
import jks.tools2D.view.utils.Utils_View;

import static jks.ht.Vars.GVars_Heart.save;
import static jks.ht.building.Vars.FVars_Building.*;
import static jks.tools2D.inputs.GVars_Inputs.*;

public class Utils_Input implements Utils_Input_Interface 
{

	
	public static Vector3 getPosFromScreen(int screenX, int screenY)
	{
		Vector3 touchPos = new Vector3(screenX, screenY, 0); //when the screen is touched, the coordinates are inserted into the vector
        GVars_Camera.camera.unproject(touchPos); // calibrates the input to your camera's dimentions
        return touchPos ; 
	}
	
	public static void updateInput (float delta) 
	{
		if (leftPressed)
		{GVars_Camera.cameraVelocity.x = -FVars_Input.maxSpeedX ;} 
		
		if (rightPressed)
		{GVars_Camera.cameraVelocity.x = FVars_Input.maxSpeedX ;}
			
		if(upPressed)
		{GVars_Camera.cameraVelocity.y = FVars_Input.maxSpeedY ;}
		
		if(downPressed)
		{GVars_Camera.cameraVelocity.y = -FVars_Input.maxSpeedY ;}
		
		if(zoomInPressed)
			
		{GVars_Camera.zoomSpeed = -FVars_Input.zoomSpeed;}
		
		if(zoomOutPressed)
		{GVars_Camera.zoomSpeed = FVars_Input.zoomSpeed;}	
	}
	
	public static Vector2Int findPosByClick(float x, float y)
	{
		x = (x - lockRefX)/roomSizeX ; 
		
		if(x < 0)
			x -- ; 

		try
		{
			return GVars_Heart.positionPool.getPos
			(
				(int)(x), 
				(int)((y - lockRefY)/roomSizeY)
			) ;
		}
		catch(Exception e)
		{System.out.println("Plop");return null ;}
	}
	
	public static void tryRoomSelection(Vector2Int touchPos)
    {
		
    	ARoom_Model selecting = save.getHiveMap().get(touchPos) ; 
    	
    	if(selecting != currentSelected) // Ont a clicker sur une autre salle
    	{
    		deselectRoom() ; 
    		
    		currentSelected = selecting ; 
        	
        	if(selecting != null)
        	{selectRoom(selecting) ;}
    	}
    	else // Ont a clicker sur la meme salle
    	{

    	} 	
    }
    
    public static void selectRoom(ARoom_Model selectedRoom)
   	{
       	markAsSelected(selectedRoom) ;
   		
       	switch(selectedRoom.getType())
   		{
   			case REACTOR : 
   			{
   				
   				break ; 
   			}
   			case TUNEL :
   			{
   				
   				break ; 
   			}
   		}
   	}
       
   public static void deselectRoom()
   {
	   	if(currentSelected != null)
	   	{
	   		currentSelected.setBackNormal();
	   		currentSelected = null ; 
	   		
	   		Utils_View.removeCurrentOverlay() ;
	   	}
   }
       
   public static void markAsSelected(ARoom_Model SelectedRoom)
   {
   		deselectRoom() ; 
   		currentSelected = SelectedRoom ;
   		currentSelected.setSelected();
   		buildInformationOfRoom(currentSelected) ; 
   }
   
   public static void buildInformationOfRoom(ARoom_Model SelectedRoom)
   {
	  Utils_View.setOverlay(new Overlay_RoomSelection(SelectedRoom));
   }
}
