package jks.ht.interface2D;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.scenes.scene2d.ui.Label;

import jks.ht.models.ToRender;

public class ShowFPS implements ToRender 
{
	Label fpsLabel ; 
	
	public ShowFPS()
	{
		fpsLabel = new Label("", GVars_Interface.baseSkin);
		fpsLabel.setFontScale(5);
		fpsLabel.setPosition(0, 100);
		GVars_Interface.mainInterface.addActor(fpsLabel);
	}
	
	@Override
	public void render()
	{fpsLabel.setText(Integer.toString(Gdx.graphics.getFramesPerSecond()));}
}
