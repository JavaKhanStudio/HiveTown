package jks.tools2D.animation.spine.model;

import java.util.HashMap;
import java.util.Random;

import com.esotericsoftware.spine.Animation;
import com.esotericsoftware.spine.AnimationState;
import com.esotericsoftware.spine.AnimationState.TrackEntry;
import com.esotericsoftware.spine.Skeleton;
import com.esotericsoftware.spine.Slot;

import jks.tools2D.animation.Enum_AnimState;
import jks.tools2D.animation.spine.IndexedData.SpineModelData;
import jks.tools2D.animation.spine.model.enums.Enum_BodyPart;

public class SpireModelView 
{

	SpineModel model ;
	public Skeleton skeleton;
	AnimationState animationState;
	SpineModelData ref ; 
	Enum_AnimState animState = Enum_AnimState.IDLE;
	
	HashMap<Enum_BodyPart,Slot> slot = new HashMap<Enum_BodyPart,Slot>();
	
	Random random = new Random() ;
	
	public SpireModelView(SpineModel Model,SpineModelData Ref)
	{
		model = Model ;
		ref = Ref ; 
		skeleton = new Skeleton(ref.modelSkeleton);
		animationState = new AnimationState(ref.modelAnimation);
		slot = ref.slotList ; 
	}
	
	
	public void update(float delta)
	{
		skeleton.setX(model.position.x);
		skeleton.setY(model.position.y);
		
		animationState.update(delta);
		animationState.apply(skeleton);

		skeleton.updateWorldTransform();
	}
	
	void setAnimState (Enum_AnimState newState, boolean force) 
	{
		if(force && animState == newState)
		{
			return;
			
		}
		animState = newState;
	}
	
	
	boolean setAnimation (Enum_AnimState state,float speed, boolean force, boolean loop, boolean applyRandom) 
	{
		Animation animation = model.ref.modelStates.get(state) ;
		TrackEntry current = animationState.getCurrent(0);
		
		Animation oldAnimation = current == null ? null : current.getAnimation();
		
		if (force || oldAnimation != animation) 
		{
			if (animation == null) 
				return true;
			
			animationState.setAnimation(0, animation, loop);
			
			animationState.setTimeScale(speed) ;
			
			if(applyRandom)
				animationState.update(random.nextInt(100));
		}
		return false;
	}
}
//skeleton.setFlipX(model.lookRight);