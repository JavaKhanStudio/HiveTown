package jks.ht.tools.Utils;

import jks.ht.Vars.GVars_Heart;
import jks.ht.interface2D.ShowFPS;

public class Utils_Debugg
{

	public static void setAtDebugg()
	{
		GVars_Heart.vue.toRender.add(new ShowFPS()) ; 
	}
}
