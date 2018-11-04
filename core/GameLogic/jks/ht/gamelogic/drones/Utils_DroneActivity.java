package jks.ht.gamelogic.drones;

import java.util.Random;

import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.utils.Array;

import jks.ht.Vars.GVars_Heart;
import jks.ht.building.Vars.FVars_Building;
import jks.ht.building.room.ARoom_Model;
import jks.ht.index.imageBank.Index_Sprite;
import jks.tools2D.animation.sprite.SpriteModel;

public class Utils_DroneActivity 
{

	public static Random random = new Random();
	
	private static final float droneDecalX_Min_Work = 2.00f ; 
	private static final float randomDistance = 1.00f ; 
	//private static final float droneDecalX_random_Work ; 
	
	public static void setRoomLife(ARoom_Model room)
	{
		DroneGroup finalGroup = new DroneGroup(); 
		
		int currentRoomOccupation ; 
		
		for(int x = 1; x <= room.getSizeX() ; x ++)
		{
			for(int y = 1; y <= room.getSizeY() ; y++)
			{
				currentRoomOccupation = random.nextInt(10) + 1 ; 
				buildDronesIn(finalGroup.members,currentRoomOccupation,Enum_GroupActivity.WORKING,getGroupPosition(x + room.getPosX(),  y + room.getPosY())); 
			}
		}
		
		finalGroup.isShow = false ; 
		room.setDroneGroup(finalGroup);
		GVars_Heart.addDroneGroup(finalGroup) ; 
	}
	
	
	private static final int decalX = 42 ; // 3
	private static final int decalY = 2 ; // 2
	private static final int roomHeigh = FVars_Building.room_LogicSizeY ; //5 
	private static final int roomWidth = FVars_Building.room_LogicSizeX ; // 10
	
	public static Vector2 getGroupPosition(int x, int y)
	{
		return new Vector2(decalX + roomWidth * (x - 1),decalY + (y - 1) * roomHeigh) ;
	}
	
	public static void buildDronesIn(Array<Drone> list,int howMany, Enum_GroupActivity doing, Vector2 position)
	{
		if(howMany == 0)
		{return ;}
		
		//float actual_droneDecalX_Min_Work = droneDecalX_Min_Work + FVars_Building.room_LogicSizeX/(howMany* 4f) ; 
		float actual_droneDecalX_random_Work = FVars_Building.room_LogicSizeX/howMany; 
		float randomValue ;
		Vector2 positionRef ;
		
		position.x -= droneDecalX_Min_Work ;
		switch(doing)
		{
			case WORKING : 
			{
				for(int a = 0 ; a < howMany ; a ++)
				{
					positionRef = new Vector2(position) ;
					positionRef.x += ((FVars_Building.room_LogicSizeX - droneDecalX_Min_Work) * random.nextFloat()) + randomDistance;
					
					SpriteModel spine = new SpriteModel(Index_Sprite.little,positionRef) ;
					spine.reverse(random.nextBoolean()) ;
					
					
					
					list.add(new Drone(spine));
				}
				
				break ; 
			}
			default : 
				System.out.println("Not drone activity build");
		}
	}
	
	
}

//actual_droneDecalX_random_Work = ((FVars_Building.room_LogicSizeX - (position.x/FVars_GlobalData.caseSize))/(howMany - a + 2)) ; 
//randomValue = (actual_droneDecalX_random_Work * random.nextFloat()) ;
//
//position.x += randomValue/2 ;
//position.x += (actual_droneDecalX_random_Work - randomValue)/ 2 ; 
