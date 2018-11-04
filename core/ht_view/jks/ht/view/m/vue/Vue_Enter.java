package jks.ht.view.m.vue;

import java.util.ArrayList;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import jks.ht.Vars.GVars_Heart;
import jks.ht.index.imageBank.Index_Image;
import jks.ht.interface2D.mainPage.Page_Main;
import jks.ht.models.ToRender;
import jks.ht.tutorial.index.Tuto_Test1;
import jks.ht.tutorial.model.Tutorial;

public class Vue_Enter extends AVue_Model
{
	
	Texture background ;
	private SpriteBatch spriteBatch;

	@Override
	public void init()
	{
		background = Index_Image.logo ;
		spriteBatch = new SpriteBatch() ;
		toRender = new ArrayList<ToRender>() ;
		Page_Main page = new Page_Main() ;
	}

	@Override
	public void destroy()
	{
		
		
	}

	@Override
	public void restart()
	{
		
		
	}

	@Override
	public void update(float delta)
	{
		
		
	}
	
	public void drawBackground()
	{
		spriteBatch.begin();
		spriteBatch.draw(background,0,0, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
		spriteBatch.end();
	}

	@Override
	public void render(float delta)
	{
		clear() ;
		renderBeforeInterface() ;
		drawBackground() ; 
		drawInterface(delta) ;
	}
	
}
