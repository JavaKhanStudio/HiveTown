package jks.ht.index.imageBank;

import static jks.ht.index.imageBank.Index_Color.*;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.utils.Array;

import jks.tools.visual.PulsingShape;

public class Index_PulsingType 
{

	public static PulsingShape show_draw_Close_CanBuild ;
	public static PulsingShape show_draw_Close_Bonus ;
	public static PulsingShape show_icon_SelectTutorial ;
	public static PulsingShape show_icon_ShowTutorial ;
	
	
	public static void init()
	{
		show_draw_Close_CanBuild = new PulsingShape
		(
			new Array<Color>() 
			{{
			    add(maxGreen);
			    add(midGreen);
			    add(minGreen);
			}}, 
			9, 
			50,
			true
		) ; 
		
		show_draw_Close_Bonus = new PulsingShape
		(
			new Array<Color>() 
			{{
			    add(maxBLUE);
			    add(midBLUE);
			    add(minBLUE);
			}}, 
			10,
			60,
			true
		) ; 
		
		show_icon_SelectTutorial = new PulsingShape
		(
			new Array<Color>() 
			{{
			    add(maxYellow);
			    add(minYellow);
			}}, 
			1, 
			5,
			10,
			true
		) ; 
		
		show_icon_ShowTutorial = new PulsingShape
				(
					new Array<Color>() 
					{{
						add(midGreen);
					    add(minGreen);
					}}, 
					1, 
					5,
					10,
					true
				) ; 
	}
	
	
}
