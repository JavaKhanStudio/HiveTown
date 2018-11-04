package jks.ht.building.enums;

import jks.ht.building.room.ARoom_Model;
import jks.ht.tools.Utils.Utils_Debugg;
import jks.ht.tools.Utils.Utils_Log;

public class Utils_MaxWorkerCapacity
{
	// SPL = Size Per Level 
	//Per Level Caps
	//private static final int cap_admin = 100;
	private static final int[] SPL_ADMIN = 		{100,200,300} ; 
	private static final int[] SPL_HOME = 		{100,200,300} ; 
	private static final int[] SPL_CHURCH = 	{100,200,300} ; 
	
	private static final int[] SPL_BARRACK = 	{100,200,300} ; 
	private static final int[] SPL_TRAINING = 	{100,200,300} ; 
	private static final int[] SPL_WEAPON = 	{100,200,300} ; 
	
	private static final int[] SPL_FOOD = 		{100,200,300} ; 
	private static final int[] SPL_INDUSTRIE = 	{100,200,300} ; 
	private static final int[] SPL_SILOS = 		{100,200,300} ; 
	
	public static int getIsCapacity(ARoom_Model room)
	{
		int returnCap ;
		int[] ref = null; 
		
		switch(room.getType())
		{
			case ADMIN :
			{ref = SPL_ADMIN;break;}
			case HOME :
			{ref = SPL_HOME;break;}
			case CHURCH :
			{ref = SPL_CHURCH;break;}
			
			case BARRACK :
			{ref = SPL_BARRACK;break;}
			case TRAINING :
			{ref = SPL_TRAINING;break;}
			case WEAPON :
			{ref = SPL_WEAPON;break;}
			
			case FOOD :
			{ref = SPL_FOOD;break;}
			case INDUSTRIE :
			{ref = SPL_INDUSTRIE;break;}
			case SILOS :
			{ref = SPL_SILOS; break;}
			
			case POLICE : break;
			case POLLUTION : break;
			case REACTOR : break;
			case TUNEL : break ; 
			
			default : 
			{Utils_Log.log(Utils_MaxWorkerCapacity.class, "Impossible de trouver la capacity de " + room.getType());}
		}
		
		return ref[room.getRoomLvl()] * room.getSize() ; 
	}
	
}
