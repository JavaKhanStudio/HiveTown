package jks.ht.building.room;

import jks.ht.doc.enums.Enum_Spec_Colors;
import jks.ht.doc.enums.Enum_Spec_Room;
import jks.ht.tools.model.Vector2Int;

public class Room_LIVING_HOME extends ARoom_Model
{
	public Room_LIVING_HOME(int sizeX, int sizeY, Vector2Int position, int level) 
	{
		super(position.x, position.y, sizeX,sizeY);
		type = Enum_Spec_Room.HOME ; 
		debuggColor = Enum_Spec_Colors.BTYPE_HABITATION.color ; 
	}
	
}
