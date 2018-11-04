package jks.tools2D.animation.spine.model;

import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;

import jks.ht.Vars.FVars_GlobalData;
import jks.ht.view.m.vue.AVue_Model;
import jks.tools2D.animation.Enum_AnimState;
import jks.tools2D.animation.LivingAnimationModel;
import jks.tools2D.animation.spine.IndexedData.SpineModelData;

public class SpineModel extends LivingAnimationModel
{
	float scale = 1 / 64f;
	float gravity = 32;
	float fps = 1 / 30f;
	
	
	String assetName ;
	SpineModelData ref ;
	public SpireModelView modelView ; 
	Vector2 position = new Vector2();
	Vector2 velocity = new Vector2();
	
	static float runGroundX = 80 ;
	float dir;
	float velocityX = 8.5f, maxVelocityMinX = 4f ;
	
	public SpineModel(SpineModelData Ref, Vector2 putAt)
	{
		ref = Ref ;
		modelView = new SpireModelView(this,ref) ;
		position.set(putAt.x * FVars_GlobalData.caseSize, putAt.y * FVars_GlobalData.caseSize);
	}
	
	@Override
	public void applyMovement()
	{
		if (velocity.x < 0) 
			move(true);
		else if (velocity.x > 0) 
			move(false);
	}
	
	@Override 
	public void draw(Batch batch)
	{AVue_Model.skeletonRenderer.draw(batch, modelView.skeleton) ; }
	
	
	@Override
	public void move(boolean right) 
	{
		reverse = right ;
		modelView.skeleton.setFlipX(reverse);
		modelView.setAnimation(Enum_AnimState.RUN,0.5f,false,true,true);
		position.add(velocity) ;
	}
	
	@Override
	public void work()
	{
		if(modelView.animState != Enum_AnimState.WORK)
			modelView.setAnimation(Enum_AnimState.WORK,1,false,true,true);
	}
	
	@Override
	public Vector2 getVelocity() 
	{return velocity;}

	@Override
	public void update(float delta) 
	{modelView.update(delta);}

	
	public String getAssetName() 
	{return assetName;}

	public void setAssetName(String assetName) 
	{this.assetName = assetName;}

	public Vector2 getPosition() 
	{return position;}

	public void setPosition(Vector2 position) 
	{this.position = position;}

	

	@Override
	public void reverse(boolean reverse) 
	{
		this.reverse = reverse;
		if(modelView != null)
			modelView.skeleton.setFlipX(reverse);
	}

	public SpireModelView getView() 
	{return modelView;}

	public void setView(SpireModelView view) 
	{this.modelView = view;}

	
}