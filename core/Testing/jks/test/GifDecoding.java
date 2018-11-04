package jks.test;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

import jks.tools2D.tools.GifDecoder;

public class GifDecoding extends ApplicationAdapter
{
	
	SpriteBatch batch;
	
	Animation<TextureRegion> currentState ; 
	TextureRegion currentFrame ; 
	float stateTime ; 
	
	@Override
	public void create () 
	{
		batch = new SpriteBatch();
//		currentState = GifDecoder.loadGIFAnimation(Animation.PlayMode.LOOP, Gdx.files.internal("test/giphy.gif").read()) ;
	}
	
	 @Override
    public void render() 
	 {        
	        Gdx.gl.glClearColor(1, 1, 1, 1);
	        
	        batch.begin();
	        
	        stateTime += Gdx.graphics.getDeltaTime(); // Accumulate elapsed animation time
			// Get current frame of animation for the current stateTime
			currentFrame = currentState.getKeyFrame(stateTime, true);
			
			batch.draw(currentFrame,0,0,currentFrame.getRegionWidth()/2,currentFrame.getRegionHeight()/2);
			batch.draw(currentFrame,150,100,currentFrame.getRegionWidth()/2,currentFrame.getRegionHeight()/2);
			batch.draw(currentFrame,300,200,currentFrame.getRegionWidth()/2,currentFrame.getRegionHeight()/2);
			batch.draw(currentFrame,450,300,currentFrame.getRegionWidth()/2,currentFrame.getRegionHeight()/2);
			batch.end();
	    }
}
