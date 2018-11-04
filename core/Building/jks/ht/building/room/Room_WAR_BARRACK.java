package jks.ht.building.room;

import jks.ht.doc.enums.Enum_Spec_Colors;
import jks.ht.doc.enums.Enum_Spec_Room;
import jks.ht.tools.model.Vector2Int;

public class Room_WAR_BARRACK extends ARoom_Model
{
	public Room_WAR_BARRACK(int sizeX, int sizeY, Vector2Int position, int level) 
	{
		super(position.x, position.y, sizeX,sizeY);
		type = Enum_Spec_Room.BARRACK ; 
		debuggColor = Enum_Spec_Colors.BTYPE_WAR.color ; 
	}
	
}
