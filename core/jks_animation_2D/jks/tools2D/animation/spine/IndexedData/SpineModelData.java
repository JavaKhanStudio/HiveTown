package jks.tools2D.animation.spine.IndexedData;

import java.util.ArrayList;
import java.util.HashMap;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.utils.ObjectMap;
import com.esotericsoftware.spine.Animation;
import com.esotericsoftware.spine.AnimationStateData;
import com.esotericsoftware.spine.SkeletonData;
import com.esotericsoftware.spine.SkeletonJson;
import com.esotericsoftware.spine.Slot;

import jks.tools2D.animation.Enum_AnimState;
import jks.tools2D.animation.spine.model.enums.Enum_BodyPart;
import jks.tools2D.animation.spine.model.enums.Enum_RefModif;
import jks.tools2D.animation.spine.modif.ModifModel;
import jks.tools2D.animation.spine.modif.Modif_Color;

public class SpineModelData 
{
	public TextureAtlas modelAtlas ;
	public SkeletonData modelSkeleton ;
	public AnimationStateData modelAnimation ;
	public ObjectMap<Enum_AnimState, Animation> modelStates = new ObjectMap<Enum_AnimState, Animation>();
	
	int width ;
	public HashMap<Enum_BodyPart,Slot> slotList;
	
	public SpineModelData(String atlasPath,String skeletonPath, float scale,ArrayList<ModifModel> modifsToDo)
	{
		modelAtlas = new TextureAtlas(Gdx.files.internal(atlasPath));
		SkeletonJson json = new SkeletonJson(modelAtlas);
		json.setScale(scale);
		modelSkeleton = json.readSkeletonData(Gdx.files.internal(skeletonPath));
		
		modelAnimation = new AnimationStateData(modelSkeleton);
		modelAnimation.setDefaultMix(0.2f);

		modelStates.put(Enum_AnimState.IDLE, modelSkeleton.findAnimation("idle"));
		modelStates.put(Enum_AnimState.RUN, modelSkeleton.findAnimation("run"));
		modelStates.put(Enum_AnimState.WORK, modelSkeleton.findAnimation("hit"));
		
		if(modifsToDo != null)
		{
			for(ModifModel ref: modifsToDo)
			{
				switch(ref.getType())
				{
					case SET_COLOR  : setColor((Modif_Color) ref); break; 
					case SET_MIX : setMix(); break; 
				}
			}
		}
	}
	
	
	
	public void setColor(Modif_Color color)
	{modelSkeleton.findSlot(color.getSlot()).getColor().set(color.getColor());;}
	
	public void setMix()
	{
		setMix(modelAnimation, "idle", "run", 0.3f);
	}
	
//	setMix(modelAnimation, "idle", "run", 0.3f);
//	setMix(modelAnimation, "run", "idle", 0.1f);
//	setMix(modelAnimation, "shoot", "shoot", 0);
	

	
	
	void setMix (AnimationStateData data, String from, String to, float mix) 
	{
		Animation fromAnimation = data.getSkeletonData().findAnimation(from);
		Animation toAnimation = data.getSkeletonData().findAnimation(to);
		if (fromAnimation == null || toAnimation == null) 
		{System.out.println("Impossible de trouver " + from + "FROM et " + to + " TO") ; return;}
		
		data.setMix(fromAnimation, toAnimation, mix);
	}
	
//	StateView setupState (ObjectMap map, Enum_AnimState state, SkeletonData skeletonData, String name, boolean loop) 
//	{
//		StateView stateView = new StateView();
//		stateView.animation = skeletonData.findAnimation(name);
//		stateView.loop = loop;
//		map.put(state, stateView);
//		return stateView;
//	}
	
	
}
