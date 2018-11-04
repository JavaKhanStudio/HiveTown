package jks.ht.building.room;

import java.util.ArrayList;

import com.badlogic.gdx.graphics.Texture;

import jks.ht.Vars.GVars_Heart;
import jks.ht.building.index.Index_Texture;
import jks.ht.doc.enums.Enum_Spec_Room;
import jks.ht.doc.utils.Hive_LvlChart;
import jks.tools2D.inputs.Utils_Input;

public class Room_INFRA_TUNEL extends ARoom_Model
{

	public boolean isRightside ; 
	
	public Room_INFRA_TUNEL(int Level, boolean isRightside) 
	{
		super(Hive_LvlChart.getMaxWidth_ByLevel(Level), 1);
		this.isRightside = isRightside ; 
		
		if(isRightside)
		{posX = 1 ;}
		else
		{posX = - sizeX ;}
		
		initDrawingValues() ;
		type = Enum_Spec_Room.TUNEL ; 
	}


	public Texture getTexture()
	{return Index_Texture.UnderGround ;}
	
	@Override
	public ArrayList<String> checkIfCanLevelUp()
	{
//		GVars_Heart.save.getHiveBuildings().get
		ArrayList<String> test = new ArrayList<String>() ; 
		test.add("test") ; 
		
		return test ; 
	}
	
	@Override
	public void levelUp() 
	{
		removeFromHive() ;
		Utils_Input.deselectRoom();
		roomLvl++ ;	
		
		sizeX = Hive_LvlChart.getMaxWidth_ByLevel(roomLvl);
		
		if(isRightside)
			GVars_Heart.getHive().setLvl_coridor_right(roomLvl);
		else
		{
			posX = - sizeX ;
			GVars_Heart.getHive().setLvl_coridor_left(roomLvl);
			initDrawingValues() ;
		}
			
		

		addToHive();
		Utils_Input.markAsSelected(this) ;
	}
}
