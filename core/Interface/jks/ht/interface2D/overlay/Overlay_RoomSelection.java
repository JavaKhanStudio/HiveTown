package jks.ht.interface2D.overlay;

import java.util.ArrayList;

import org.apache.commons.collections4.CollectionUtils;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.InputListener;
import com.badlogic.gdx.scenes.scene2d.Touchable;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;

import jks.ht.Vars.GVars_Heart;
import jks.ht.building.room.ARoom_Model;
import jks.ht.interface2D.GVars_Interface;
import jks.ht.interface2D.Index_InterfaceIcon;
import jks.ht.interface2D.Tools.Button_OverInfo;
import jks.tools2D.inputs.GVars_Inputs;

public class Overlay_RoomSelection extends Overlay_InformativeWindow
{
	 
	
	Label infoLabel_roomSize ;
	Label infoLabel_roomLvl ;
	
	public Overlay_RoomSelection(ARoom_Model room)
	{
		super(GVars_Interface.baseSkin) ;
		
		//"Room selected : " + room.getType().name()
		buildInfo(this,room,Enum_RoomInfo.SIZE, 1) ;
		buildInfo(this,room,Enum_RoomInfo.LEVEL, 2) ;
	}
	
	public static void buildInfo(Table attachOn, ARoom_Model room, Enum_RoomInfo type, int y)
	{
		switch(type)
		{
			case SIZE :
			{
				Label roomSize_Desc = new Label(type.getDescription() + " : ", GVars_Interface.baseSkin) ; 
				setPosition(roomSize_Desc,1,y) ;
				
				Label roomSize_info = new Label(room.getSizeX() + " x " + room.getSizeY(), GVars_Interface.baseSkin) ; ; 
				setPosition(roomSize_info,2,y) ;
				
				attachOn.add(roomSize_Desc); attachOn.add(roomSize_info);
				break ; 
			}
			case LEVEL :
			{
				Label roomLevel_Desc = new Label(type.getDescription() + " : ", GVars_Interface.baseSkin) ; 
				setPosition(roomLevel_Desc,1,y) ;
				
				Label roomLevel_info = new Label(room.getRoomLvl() + "", GVars_Interface.baseSkin) ; ; 
				setPosition(roomLevel_info,2,y) ;
				
				Button_OverInfo button = buidLevelIncreaseButton(room) ;
				setPosition(button,2.5f,y + 0.2f) ;
				
				attachOn.add(roomLevel_info); attachOn.add(roomLevel_Desc); attachOn.add(button) ;
				break ; 
			}
		}
	}
	
	public static Button_OverInfo buidLevelIncreaseButton(final ARoom_Model room)
	{
		ArrayList<String> problem = room.checkIfCanLevelUp() ;
		
		Button_OverInfo icon = new Button_OverInfo(Index_InterfaceIcon.icon_LevelUp,problem) ;
		icon.setSize(buttonSize, buttonSize);

		if(CollectionUtils.isEmpty(problem))
		{
		    icon.addListener(new InputListener()
		    {
				@Override
		        public boolean touchDown (InputEvent event, float x, float y, int pointer, int button) 
		        {
					room.levelUp();
					return false ; 
		        }

				@Override
		        public void touchUp (InputEvent event, float x, float y, int pointer, int button) 
		        {
					
		        }
			});
		}
		
		return icon ; 
	}
	
	public static void setPosition(Actor setIm, float x, float y)
	{setIm.setPosition(decal + ((x - 1) * width), size - (y * height));}
	
}
