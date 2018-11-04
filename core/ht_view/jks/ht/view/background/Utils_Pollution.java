package jks.ht.view.background;
import static jks.tools2D.camera.Fvars_Camera.*;
import static jks.tools2D.camera.GVars_Camera.*;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer.ShapeType;

import jks.ht.Vars.GVars_Heart;
import jks.tools2D.camera.Fvars_Camera;
import jks.tools2D.camera.GVars_Camera; 

public class Utils_Pollution 
{

	
	static float showBaseColor ; 
	static float showPolution ;
	static float startShowingBottom = 0.4f ; 
	static Color coin_HautG = Color.CYAN.cpy();
	static Color coin_HautD = Color.CYAN.cpy();
	
	static Color coin_BasG = Color.WHITE.cpy();
	static Color coin_BasD = Color.WHITE.cpy();
	
	public static void caculateCurrentSkyColor()
	{
		showPolution = computeCurrentPollutionShow() ;
		
		coin_HautG = Color.BLUE.cpy().add(showPolution,(showPolution)/1.5f + .15f, -0.35f - showPolution/5.5f, 0);
		coin_HautD = coin_HautG;
		
		if(showPolution > startShowingBottom)
		{
			showBaseColor = (showPolution - startShowingBottom) ;
			coin_BasG = Color.WHITE.cpy().add(-showBaseColor ,-showBaseColor,-showBaseColor * 1.2f,0);
			coin_BasD = coin_BasG;
		}
	}
	
	public static float computeCurrentPollutionShow()
	{
		float computed =  
				GVars_Heart.save.getPollution()
				/(
					FVars_Pollution.maxPollution 
					+  (((GVars_Camera.camera.position.y * FVars_Pollution.pollutionHeightVector) * (zoomPower/GVars_Camera.camera.zoom))
						- (Fvars_Camera.minHeightY * (2.3f)))
				 ) ;

		if(computed > 1)
			computed = 1 ;
		
		return computed ;
	}
	
	public static void addStuff()
	{
		if(GVars_Heart.save.getPollution() < FVars_Pollution.absoluteMaxPollution)
			GVars_Heart.save.setPollution(GVars_Heart.save.getPollution() + 1); ; 
	}
	
	public static void buildColors()
	{
		caculateCurrentSkyColor() ; 
		render_ScreenFill.begin(ShapeType.Filled) ;
		render_ScreenFill.rect(0, 0, Gdx.graphics.getWidth(),Gdx.graphics.getHeight(), coin_BasG, coin_BasD, coin_HautD, coin_HautG);
		render_ScreenFill.end() ;
		addStuff() ; 
	}
	
	
}

//if(GVars_Camera.camera.position.y > 100)
//{
//	shapeRenderer.rect(0, 0, Gdx.graphics.getWidth(),100,  Color.CHARTREUSE, Color.CHARTREUSE, Color.CHARTREUSE, Color.CHARTREUSE);
//}
//Gdx.graphics.getWidth() Gdx.graphics.getHeight()
