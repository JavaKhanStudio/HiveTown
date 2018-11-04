package jks.tools2D.view.utils;

import jks.ht.Vars.GVars_Heart;
import jks.ht.interface2D.GVars_Interface;
import jks.ht.interface2D.overlay.OverlayModel;
import jks.ht.view.m.filter.AView_Model_Filter;

public class Utils_View 
{

	public static OverlayModel getOverlay()
	{return GVars_Heart.vue.overlay ;}
	
	public static void setOverlay(OverlayModel overlay)
	{
		removeCurrentOverlay() ; 
		GVars_Heart.vue.overlay = overlay ; 
		GVars_Interface.mainInterface.addActor(overlay) ;
	}
	
	public static void removeCurrentOverlay()
	{
		if(GVars_Heart.vue.overlay != null)
		{
			GVars_Heart.vue.overlay.destroy();
			GVars_Heart.vue.overlay = null ; 
		}
	}
	
	public static void setFilter(AView_Model_Filter filter_CanBuild)
	{
		removeFilter() ;
		GVars_Heart.vue.filter = filter_CanBuild ;
	}

	public static void removeFilter() 
	{
		if(GVars_Heart.vue.filter != null)
		{
			GVars_Heart.vue.filter = null ; 
		}
	}
}
