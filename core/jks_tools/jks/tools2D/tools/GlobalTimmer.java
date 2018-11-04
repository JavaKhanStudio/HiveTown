package jks.tools2D.tools;

import java.util.HashMap;

public class GlobalTimmer
{

	public static HashMap<String,Long> timeHolder ;
	
	
	public static void registerTime(String key)
	{
		if(timeHolder == null)
		{timeHolder = new  HashMap<String,Long>() ;}
		
		timeHolder.put(key, System.currentTimeMillis()) ;
	}
	
	public static Long getElapse(String key)
	{return getElapse(key, false);}
	
	public static Long getElapse(String key, boolean reset)
	{
		long finishTime = System.currentTimeMillis();
		long took = (finishTime-timeHolder.get(key)) ; 
		System.out.println(key + " took: " + took+ " ms");
		
		if(reset)
			timeHolder.put(key, finishTime) ;
		
		return took ; 
	}
	
	
}
