package jks.tools2D.animation.spine.vars;

import java.util.HashMap;

import jks.tools2D.animation.spine.IndexedData.SpineModelData;

public class GVars_SpineModels 
{
	public static HashMap<String, SpineModelData> refList ; 
	
	public static SpineModelData getRef(String ref)
	{return refList.get(ref) ;}
}
