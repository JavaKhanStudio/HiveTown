package jks.ht.building.Vars;

import jks.ht.building.buildResults.Model_Results;
import jks.ht.building.room.ARoom_Model;
import jks.ht.building.room.Room_LIVING_HOME;
import jks.ht.doc.enums.Enum_Spec_Room;
import jks.ht.tools.model.Vector2Int;

public class Utils_Building
{
	public static Model_Results buildFuse(Vector2Int pos, ARoom_Model wantFuseWith)
	{
		wantFuseWith.removeFromHive();
			
		// Is it on the Side
		if(pos.x != wantFuseWith.getPosX())
		{
			wantFuseWith.setSizeX(wantFuseWith.getSizeX() + 1);
			
			if(pos.x < wantFuseWith.getPosX())
			{
				wantFuseWith.setPosX(pos.x);
				wantFuseWith.initDrawingValues() ; 
			}
		}
		else // Or on top 
		{
			wantFuseWith.setSizeY(wantFuseWith.getSizeY() + 1);
			
			if(pos.y < wantFuseWith.getPosY())
			{wantFuseWith.setPosY(pos.y);}
		}
		
		wantFuseWith.addToHive();
	
		return new Model_Results(true, "Test") ; 
	}
	
	public static Model_Results buildNew(Vector2Int pos, Enum_Spec_Room wantToBuild)
	{
		//Room_Habitation habit = new Room_Habitation(1,1,pos,1) ;
		ARoom_Model room = wantToBuild.getNewRoom(pos) ; 
		room.addToHive();
		return new Model_Results(true, "Test") ; 
	}
}
