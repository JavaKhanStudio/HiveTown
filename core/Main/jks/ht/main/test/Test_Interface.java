package jks.ht.main.test;

import com.badlogic.gdx.ApplicationListener;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.scenes.scene2d.ui.Table;

import jks.ht.Vars.GVars_Heart;
import jks.ht.interface2D.GVars_Interface;
import jks.ht.interface2D.overlay.constructionChoice.BonusEffect;
import jks.tools2D.animation.AnimationModel;

public class Test_Interface  implements ApplicationListener  
{
	
	public static AnimationModel anim ; 
	public static BonusEffect effect ;

	@Override
	public void create() 
	{
		GVars_Heart.init();

		effect = new BonusEffect(null,true) ;
		Table effectTable = effect.buildIt(50,50,0,0) ; 
		effectTable.setPosition(150, 150);
		GVars_Interface.mainInterface.addActor(effectTable);
	}

	@Override
	public void resize(int width, int height) 
	{
	
	}

	@Override
	public void render() 
	{
//		float delta = Math.min(Gdx.graphics.getDeltaTime(), 1 / 30f);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		GVars_Interface.mainInterface.draw() ;
		GVars_Interface.mainInterface.act(Gdx.graphics.getDeltaTime());
	}

	@Override
	public void pause() 
	{
		
	}

	@Override
	public void resume() 
	{
		
	}

	@Override
	public void dispose() 
	{
		
	}

	
	
	
}
