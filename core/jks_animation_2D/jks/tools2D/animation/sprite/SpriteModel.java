package jks.tools2D.animation.sprite;

import java.util.Random;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Vector2;

import jks.ht.Vars.FVars_GlobalData;
import jks.tools2D.animation.Enum_AnimState;
import jks.tools2D.animation.LivingAnimationModel;

public class SpriteModel extends LivingAnimationModel
{

	SpriteModelData ref ;
	
	public Vector2 velocity = new Vector2();
	Animation<TextureRegion> currentState ; 
	TextureRegion currentFrame ; 
	Enum_AnimState currentStateName ; 
	
	Random random = new Random() ; 

	public SpriteModel(SpriteModelData index, Vector2 putAt)
	{
		ref = index ;
		position.set(putAt.x * FVars_GlobalData.caseSize, putAt.y * FVars_GlobalData.caseSize);
	}
	

	@Override
	public void draw(Batch batch) 
	{
		stateTime += Gdx.graphics.getDeltaTime(); // Accumulate elapsed animation time
		// Get current frame of animation for the current stateTime
		currentFrame = currentState.getKeyFrame(stateTime, true);
		
		batch.draw(currentFrame, position.x + (reverse ? 0 : currentFrame.getRegionWidth() * ref.scale), position.y, currentFrame.getRegionWidth() * ref.scale * (reverse ? 1 : - 1) ,currentFrame.getRegionHeight() * ref.scale ); 	
	}
	
//	if(lookRight && currentFrame.isFlipX())
//	{currentFrame.flip(lookRight, false);}
	
	public void changeAnimationState(Enum_AnimState state, boolean atRandom)
	{
		currentState = ref.animationList.get(state) ;
		if(currentState == null)
		{
			currentState = ref.animationList.values().iterator().next() ;
			System.out.println("Impossible de trouver l'animation - " + state.toString() +  " - dans SpriteModel");
		}
		currentStateName = state  ;
		
		if(atRandom)
			stateTime = random.nextFloat() * currentState.getAnimationDuration() ;
	}

	@Override
	public void applyMovement() 
	{
		// TODO Auto-generated method stub
		
	}

	@Override
	public void move(boolean right) 
	{
		// TODO Auto-generated method stub
		
	}

	@Override
	public void work() 
	{
		if(currentStateName != Enum_AnimState.WORK)
			changeAnimationState(Enum_AnimState.WORK,true) ;
		
	}

	@Override
	public Vector2 getVelocity()
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Vector2 getPosition()
	{return position;}
	
	
	
}
