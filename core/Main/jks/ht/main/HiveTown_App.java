package jks.ht.main;

import com.badlogic.gdx.ApplicationListener;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;

import jks.ht.Vars.GVars_Heart;
import jks.ht.interface2D.GVars_Interface;
import jks.ht.view.m.vue.Vue_Enter;
import jks.ht.view.m.vue.Vue_Game;
import jks.tools2D.camera.GVars_Camera;
import jks.tools2D.camera.renderer.Renderer_Map;
import jks.tools2D.camera.renderer.Singleton_Renderer_Spine;


public class HiveTown_App implements ApplicationListener 
{
	@Override
    public void create()
    {       
		GVars_Heart.full = true ; 
		GVars_Heart.init();
		GVars_Heart.changeView(new Vue_Enter()) ;    
		Gdx.graphics.setVSync(false);
    }

    @Override
    public void render() 
    {    
    	Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
    	float delta = Math.min(Gdx.graphics.getDeltaTime(), 1 / 30f);
    	
    	if (delta > 0) 
    	{
    		GVars_Heart.vue.update(delta);
        	GVars_Heart.vue.render(delta);
    	}
    	
    	GVars_Interface.mainInterface.act(Gdx.graphics.getDeltaTime());
    }
    
    @Override
	public void resize(int width, int height) 
	{
		GVars_Heart.viewport.update(width, height);
		
		if(GVars_Camera.render_Map != null)
			GVars_Camera.render_Map.setView(GVars_Camera.camera);
	}

    @Override
    public void pause()
    {}

    @Override
    public void resume()
    {}

    @Override
	public void dispose() 
	{}
	
}
