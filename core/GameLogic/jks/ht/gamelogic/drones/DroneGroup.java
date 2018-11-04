package jks.ht.gamelogic.drones;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.utils.Array;

import jks.ht.view.m.vue.AVue_Model;
import jks.tools2D.animation.AnimationModel;
import jks.tools2D.animation.spine.model.SpineModel;
import jks.tools2D.camera.GVars_Camera;

public class DroneGroup 
{

	Enum_GroupActivity currentActivity = Enum_GroupActivity.WORKING  ;
	Vector2 groupVector ; 
	public Array<Drone> members ;
	public boolean isShow = false ; 
	
	
	public DroneGroup()
	{
		members = new Array<Drone>() ;
	}
	
	public DroneGroup(int num, Vector2 position)
	{
		members = new Array<Drone>() ;
	}
	
	public void runGroupActivity()
	{
		switch(currentActivity)
		{
			case MOVING_TO_WORK: 
			{movingToWork();break ;}
			case WORKING:
			{working();break ; }
			
			default :
				System.out.println("AUCUNE ACTIVITY POUR LE GROUPE");
		}
	}

	private void working() 
	{
		for(Drone drone : members)
		{drone.model.work() ;}
	}

	private void movingToWork() 
	{
		for(Drone drone : members)
		{
			setWorkerNextStep(drone.model) ;
			drone.model.applyMovement() ;
		}
	}

	public void setWorkerNextStep(AnimationModel model)
	{model.getVelocity().x = -1 ;}


	public void draw(final SpriteBatch batch) 
	{
		if(isShow)
		{
			batch.begin();
			batch.setProjectionMatrix(GVars_Camera.camera.combined);
			
			for(Drone drone : members)
			{drone.model.draw(batch);}
			
			batch.end();
		}
	}
	
	public void update(float delta) 
	{
		if(isShow)
		{
			for(Drone drone : members)
			{drone.model.update(delta);}
		}
	}
	
	public DroneGroup fuseGroup(DroneGroup toFuse)
	{
		members.addAll(toFuse.members); 
		toFuse = null ; 
		return this ; 
	}
	

}
