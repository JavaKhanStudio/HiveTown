package jks.ht.building.room;

import com.badlogic.gdx.graphics.Texture;

import jks.ht.Vars.GVars_Heart;
import jks.ht.building.index.Index_Texture;
import jks.ht.doc.enums.Enum_Spec_Room;
import jks.ht.doc.utils.Hive_LvlChart;
import jks.tools2D.inputs.Utils_Input;

public class Room_INFRA_HiveReactor extends ARoom_Model 
{
	public Room_INFRA_HiveReactor(int level) 
	{
		super(0, 0, 1, Hive_LvlChart.getMaxHeight_ByLevel(level));
		type = Enum_Spec_Room.REACTOR ; 
	}

	public Texture getTexture()
	{return Index_Texture.Tower ;}
	
	@Override
	public void levelUp() 
	{
		removeFromHive() ;
		Utils_Input.deselectRoom();
		roomLvl++ ;	
		sizeY = Hive_LvlChart.getMaxHeight_ByLevel(roomLvl) ;
		GVars_Heart.getHive().setLvl_mainReactor(roomLvl);
		addToHive();
		Utils_Input.markAsSelected(this) ;
	}
	
}