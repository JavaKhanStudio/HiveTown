package jks.tools2D.animation.spine.IndexedData;


import com.badlogic.gdx.ApplicationListener;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.TextureAtlas.AtlasRegion;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.utils.Array;

import jks.tools2D.animation.sprite.SpriteModel;

public class Tools_CheckForAnimations implements ApplicationListener 
{


	Animation<TextureRegion> runAnimation; // Must declare frame type (TextureRegion)
	Animation<TextureRegion> deathAnimation; 
	//Texture walkSheet;
	SpriteBatch spriteBatch;

	// A variable for tracking elapsed time for the animation
	float stateTime;
	Array<AtlasRegion> runningFrames ;
	SpriteBatch batch  ;
	float currentFrame ; 
	
	@Override
	public void create()
	{

		batch = new SpriteBatch();
		TextureAtlas textureAtlas = new TextureAtlas(Gdx.files.internal("cuteGirl/libTest.atlas"));
		//walkAnimation = new Animation(0.2f, textureAtlas.getRegions());

		
		runAnimation = new Animation(1/15f, textureAtlas.findRegions("Run"));
		deathAnimation  = new Animation(1/15f, textureAtlas.findRegions("Dead"));
		spriteBatch = new SpriteBatch();
		
		SpineModelData model = new SpineModelData("alien/alien.atlas","alien/alien.json",0.10f,null) ;
		System.out.println(model.modelSkeleton.getAnimations()) ;
		//System.exit(1);
		
	}

	@Override
	public void resize(int width, int height) {
		// TODO Auto-generated method stub
		
	}

	float scale = 0.5f ;
	
	@Override
	public void render() 
	{
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT); // Clear screen
		
		stateTime += Gdx.graphics.getDeltaTime(); // Accumulate elapsed animation time
		
		// Get current frame of animation for the current stateTime
		TextureRegion currentFrame = runAnimation.getKeyFrame(stateTime, true);
		if(currentFrame == null)
		{
			stateTime = 0 ; 
			currentFrame = deathAnimation.getKeyFrame(stateTime, true);
		}
		
		spriteBatch.begin();
		spriteBatch.draw(currentFrame, 10, 10,currentFrame.getRegionWidth() * scale,currentFrame.getRegionHeight() * scale); // Draw current frame at (50, 50)
		spriteBatch.end();
		
	}

	@Override
	public void pause() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void resume() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void dispose() {
		// TODO Auto-generated method stub
		
	}

	
	
	
}
