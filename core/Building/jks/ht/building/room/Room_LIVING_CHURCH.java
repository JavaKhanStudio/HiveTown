package jks.ht.building.room;

import jks.ht.doc.enums.Enum_Spec_Colors;
import jks.ht.doc.enums.Enum_Spec_Room;
import jks.ht.tools.model.Vector2Int;

public class Room_LIVING_CHURCH extends ARoom_Model
{
	public Room_LIVING_CHURCH(int sizeX, int sizeY, Vector2Int position, int level) 
	{
		super(position.x, position.y, sizeX,sizeY);
		type = Enum_Spec_Room.CHURCH ; 
		debuggColor = Enum_Spec_Colors.BTYPE_HABITATION.color ; 
	}
	
}
