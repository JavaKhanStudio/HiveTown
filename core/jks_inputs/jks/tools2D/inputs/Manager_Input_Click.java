package jks.tools2D.inputs;

import static jks.tools2D.camera.GVars_Camera.cameraVelocity;
import static jks.tools2D.inputs.GVars_Inputs.blockActionForClick;
import static jks.tools2D.inputs.GVars_Inputs.downPressed;
import static jks.tools2D.inputs.GVars_Inputs.leftPressed;
import static jks.tools2D.inputs.GVars_Inputs.rightPressed;
import static jks.tools2D.inputs.GVars_Inputs.startSelection_X;
import static jks.tools2D.inputs.GVars_Inputs.startSelection_Y;
import static jks.tools2D.inputs.GVars_Inputs.upPressed;
import static jks.tools2D.inputs.GVars_Inputs.zoomInPressed;
import static jks.tools2D.inputs.GVars_Inputs.zoomOutPressed;

import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.InputAdapter;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.math.Vector3;

import jks.ht.Vars.GVars_Heart;
import jks.ht.tools.model.Vector2Int;
import jks.tools2D.camera.Fvars_Camera;
import jks.tools2D.camera.GVars_Camera;

public class Manager_Input_Click extends InputAdapter 
{
	float currentlySelectingAt ; 
	
	@Override
    public boolean touchDown(int screenX, int screenY, int pointer, int button) 
	{
		super.touchDown(screenX, screenY, pointer, button) ;
		blockActionForClick = false ; 
		
    	startSelection_X = screenX; 
    	startSelection_Y = screenY; 
    	 
    	if(!cameraVelocity.isZero ())
    		cameraVelocity.set(cameraVelocity.x * Fvars_Camera.cameraVelocity_ReductionOnClick, cameraVelocity.y * Fvars_Camera.cameraVelocity_ReductionOnClick) ; 
    	
        return false;
    }

    @Override
    public boolean touchUp(int screenX, int screenY, int pointer, int button) 
    {
    	Vector3 pos = Utils_Input.getPosFromScreen(screenX,screenY) ;
    	Vector2Int select = Utils_Input.findPosByClick(pos.x, pos.y) ;
    	
    	if(select == null)
    		return false;
    	
    	if(checkOverlayClick())
    		return false; // l'overlay desactive toute selection
    	
    	if(checkFilterClick(select))
         	return false; // le filter desactive toute selection
    	
    	if(!blockActionForClick)
    	{Utils_Input.tryRoomSelection(select) ;}

        return false;
    }
    
    private final int minVelocity = 1 ; 
    
    @Override
    public boolean touchDragged(int screenX, int screenY, int pointer) 
    {
    	
    	currentVelocity_X = startSelection_X - screenX ;  
    	currentVelocity_Y = screenY - startSelection_Y ; 
    	startSelection_X = screenX ;
    	startSelection_Y = screenY ;

    	if(Math.abs(currentVelocity_X + currentVelocity_Y) > minVelocity)
    	{
    		blockActionForClick = true ; 
    		GVars_Camera.cameraVelocity.add(currentVelocity_X * 1.2f, currentVelocity_Y * 1.5f) ;  
    		return true ; 
    	}
    	else
    	{
    		return false;
    	} 	
    }
    

    private boolean checkOverlayClick()
    {
    	if(GVars_Heart.vue.overlay != null)
    	{
    		if(GVars_Heart.vue.overlay.disableMainClickAction())
    			return true ;
    	}
    	
    	return false ;
    }
    
    public static boolean checkFilterClick(Vector2Int select)
    {
     	if(GVars_Heart.vue.filter != null)
     	{
     		GVars_Heart.vue.filter.clickAction(select);
     	
     		if(GVars_Heart.vue.filter.disableMainClickAction())
     			return true ;
     	}
     	
     	return false ; 
    }
   

	int currentVelocity_X ;
    int currentVelocity_Y ;
    
   
}
