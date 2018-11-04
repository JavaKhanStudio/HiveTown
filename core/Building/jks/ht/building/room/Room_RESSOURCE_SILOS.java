package jks.ht.building.room;

import jks.ht.doc.enums.Enum_Spec_Colors;
import jks.ht.doc.enums.Enum_Spec_Room;
import jks.ht.tools.model.Vector2Int;

public class Room_RESSOURCE_SILOS extends ARoom_Model
{
	public Room_RESSOURCE_SILOS(int sizeX, int sizeY, Vector2Int position, int level) 
	{
		super(position.x, position.y, sizeX,sizeY);
		type = Enum_Spec_Room.SILOS ; 
		debuggColor = Enum_Spec_Colors.BTYPE_RESSOURCE.color ; 
	}
	
}
