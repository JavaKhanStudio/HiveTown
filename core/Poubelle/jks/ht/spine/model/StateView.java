package jks.ht.spine.model;

import com.badlogic.gdx.utils.ObjectFloatMap;
import com.esotericsoftware.spine.Animation;

public class StateView 
{
	Animation animation;
	// Controls the start frame when changing from another animation to this animation.
	ObjectFloatMap<Animation> startTimes = new ObjectFloatMap();
	float defaultStartTime;
}
