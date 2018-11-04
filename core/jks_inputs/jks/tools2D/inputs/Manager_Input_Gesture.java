package jks.tools2D.inputs;

import com.badlogic.gdx.input.GestureDetector.GestureListener;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.math.Vector3;

import jks.tools2D.camera.GVars_Camera;

public class Manager_Input_Gesture implements GestureListener
{

	private Vector2 oldInitialFirstPointer=null, oldInitialSecondPointer=null;
    private float oldScale;
    
	@Override
    public boolean pinch (Vector2 initialFirstPointer, Vector2 initialSecondPointer, Vector2 firstPointer, Vector2 secondPointer)
    {

        if(!(initialFirstPointer.equals(oldInitialFirstPointer)&&initialSecondPointer.equals(oldInitialSecondPointer)))
        {
            oldInitialFirstPointer = initialFirstPointer.cpy();
            oldInitialSecondPointer = initialSecondPointer.cpy();
            oldScale = GVars_Camera.getCamera().zoom;
        }
        
        Vector3 center = new Vector3
        (
                (firstPointer.x+initialSecondPointer.x)/2,
                (firstPointer.y+initialSecondPointer.y)/2,
                0
        );
        zoomCamera(center, oldScale*initialFirstPointer.dst(initialSecondPointer)/firstPointer.dst(secondPointer));
        return true;
    }
    
    private void zoomCamera(Vector3 origin, float scale)
    {
    	System.out.println("test2") ; 
    	
        GVars_Camera.getCamera().update();
        Vector3 oldUnprojection = GVars_Camera.getCamera().unproject(origin.cpy()).cpy();
        GVars_Camera.getCamera().zoom = scale; //Larger value of zoom = small images, border view
        GVars_Camera.getCamera().zoom = Math.min(2.0f, Math.max(GVars_Camera.getCamera().zoom, 0.5f));
        GVars_Camera.getCamera().update();
        Vector3 newUnprojection = GVars_Camera.getCamera().unproject(origin.cpy()).cpy();
        GVars_Camera.getCamera().position.add(oldUnprojection.cpy().add(newUnprojection.cpy().scl(-1f)));
    }

	@Override
	public boolean touchDown(float x, float y, int pointer, int button)
	{return false;}

	@Override
	public boolean tap(float x, float y, int count, int button)
	{return false;}

	@Override
	public boolean longPress(float x, float y)
	{return false;}

	@Override
	public boolean fling(float velocityX, float velocityY, int button)
	{return false;}

	@Override
	public boolean pan(float x, float y, float deltaX, float deltaY)
	{return false;}

	@Override
	public boolean panStop(float x, float y, int pointer, int button)
	{return false;}

	@Override
	public boolean zoom(float initialDistance, float distance)
	{return false;}

	@Override
	public void pinchStop()
	{}
	
	
	
}
