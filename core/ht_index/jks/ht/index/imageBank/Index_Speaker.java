package jks.ht.index.imageBank;

import jks.ht.interface2D.dialogue.Speaker;

public class Index_Speaker 
{
	private static final String path =  "speaker/" ;
	public static Speaker sweetMarie ;
	
	public static void init()
	{
		sweetMarie = new Speaker("Sweet Marie", path + "SweetMarie2.png") ; 
	
	}
	
	
}
