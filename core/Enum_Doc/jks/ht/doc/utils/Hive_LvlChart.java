package jks.ht.doc.utils;


import static jks.ht.Vars.GVars_Heart.getHive ;

public class Hive_LvlChart
{
	//	//	//	//	//
	// Main Methode	//
	//	//	//	//	//
	
	// Base =  4
	// Lvl  = +2 
	public static int getMaxHeight_ByLevel(int level)
	{return level * 2 + 4 ; }
	
	
	// Base =  4
	// Lvl  = +2 
	public static int getMaxWidth_ByLevel(int level)
	{
		if(level == 0)
			return 0 ; 
		else 
			return (level - 1) * 2 + 4 ;
	}
	
	
	//	//	//	//
	// Utility	//
	//	//	//	//
	
	public static int getCurrent_MaxWidth_left()
	{return getMaxWidth_ByLevel(getHive().getLvl_corridor_left()) ;}
	
	public static int getCurrent_MaxWidth_right()
	{return getMaxWidth_ByLevel(getHive().getLvl_corridor_right()) ;}
	
	public static int getCurrent_MaxHeight()
	{return getMaxHeight_ByLevel(getHive().getLvl_mainReactor()) ; }
	
	
	//private final static int[] levelHeight = new int[]{6,12,18,25};
}
