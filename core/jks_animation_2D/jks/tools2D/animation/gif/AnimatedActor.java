package jks.tools2D.animation.gif;

import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.ui.Table;

public class AnimatedActor extends Actor
{
	
	float stateTime ;
	Table refTable; 
	
	GifModelData ref ;
	TextureRegion currentFrame ; 
	
	float animationTime ; 
	
	protected boolean reverse ;
	boolean reconsier = true ; 
	
	public AnimatedActor()
	{}
	
	public void setRef(GifModelData ref)
	{this.ref = ref ; animationTime = 0 ;}
	
	public AnimatedActor(GifModelData model, Vector2 size, Vector2 position ) 
	{
		this.ref = model ;
		setSize(size.x, size.y);
		setPosition(position.x, position.y);
	}


	@Override
	public void act (float delta) 
	{
		super.act(delta);
		
		if(ref != null) 
		{
			currentFrame = ref.gifBody.getKeyFrame(animationTime) ;
			animationTime += delta;
		}
			
	}
	
	@Override
	public void draw (Batch batch, float parentAlpha) 
	{
		if(currentFrame != null)
			batch.draw(currentFrame, getX() + (reverse ? 0 : getWidth()), getY(), getWidth() * (reverse ? 1 : - 1), getHeight());

	}
}
