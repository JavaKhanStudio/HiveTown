package jks.ht.main.test;

import com.badlogic.gdx.ApplicationListener;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;

import jks.ht.Vars.GVars_Heart;
import jks.ht.index.imageBank.Index_Sign;
import jks.ht.interface2D.GVars_Interface;
import jks.tools2D.animation.gif.AnimatedActor;

public class Test_Image  implements ApplicationListener  
{
	
	public static AnimatedActor anim ; 

	@Override
	public void create() 
	{
		GVars_Heart.init();
//		anim = new AnimatedActor(Index_Sign.plus);
	}

	@Override
	public void resize(int width, int height) 
	{
		// TODO Auto-generated method stub
		
	}

	@Override
	public void render() 
	{
		float delta = Math.min(Gdx.graphics.getDeltaTime(), 1 / 30f);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		GVars_Interface.mainInterface.draw() ;
		GVars_Interface.mainInterface.act(Gdx.graphics.getDeltaTime());
	}

	@Override
	public void pause() 
	{
		// TODO Auto-generated method stub
		
	}

	@Override
	public void resume() 
	{
		// TODO Auto-generated method stub
		
	}

	@Override
	public void dispose() 
	{
		// TODO Auto-generated method stub
		
	}

	
	
	
}
