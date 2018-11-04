package jks.tools2D.inputs;

import static jks.tools2D.inputs.GVars_Inputs.downPressed;
import static jks.tools2D.inputs.GVars_Inputs.leftPressed;
import static jks.tools2D.inputs.GVars_Inputs.rightPressed;
import static jks.tools2D.inputs.GVars_Inputs.upPressed;
import static jks.tools2D.inputs.GVars_Inputs.zoomInPressed;
import static jks.tools2D.inputs.GVars_Inputs.zoomOutPressed;

import com.badlogic.gdx.InputAdapter;
import com.badlogic.gdx.Input.Keys;

import jks.tools2D.camera.GVars_Camera;

public class Manager_Input_Keys extends InputAdapter 
{
		// PC input
		@Override
		public boolean keyDown (int keycode) 
		{
			switch (keycode) 
			{
				case Keys.W:
				case Keys.UP:
				case Keys.SPACE:
					upPressed = true ; 
					return true;
				case Keys.A:
				case Keys.LEFT:
					leftPressed = true;
					return true;
				case Keys.D:
				case Keys.RIGHT:
					rightPressed = true;
					return true ; 
				case Keys.DOWN :
				case Keys.S :
					downPressed = true ;
					return true;
				case Keys.PLUS : 
				case Keys.Q : 
					zoomInPressed = true ;
					return true ; 
				case Keys.MINUS : 
				case Keys.E : 
					zoomOutPressed = true ;
					return true ; 
				
			}
			return false;
		}
		
		@Override
		public boolean keyUp (int keycode) 
		{
			switch (keycode) 
			{
				case Keys.W:
				case Keys.UP:
				case Keys.SPACE:
					upPressed = false ; 
					GVars_Camera.cameraVelocity.y = 0 ;
					return true;
				case Keys.A:
				case Keys.LEFT:
					leftPressed = false;
					GVars_Camera.cameraVelocity.x = 0 ;
					return true;
				case Keys.D:
				case Keys.RIGHT:
					rightPressed = false;
					GVars_Camera.cameraVelocity.x = 0 ;
					return true;
				case Keys.DOWN :
				case Keys.S :
					downPressed = false ;
					GVars_Camera.cameraVelocity.y = 0 ;
					return true ; 
				case Keys.PLUS : 
				case Keys.Q : 
					zoomInPressed = false ;
					return true ; 
				case Keys.MINUS : 
				case Keys.E : 
					zoomOutPressed = false ;
					return true ; 
			}
			return false;
		}
}
