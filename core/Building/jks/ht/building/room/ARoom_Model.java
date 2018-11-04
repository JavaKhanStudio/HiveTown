package jks.ht.building.room;

import static jks.ht.building.Vars.FVars_Building.lockRefX;
import static jks.ht.building.Vars.FVars_Building.lockRefY;
import static jks.ht.building.Vars.FVars_Building.roomSizeX;
import static jks.ht.building.Vars.FVars_Building.roomSizeY;
import static jks.tools2D.camera.GVars_Camera.*;

import java.util.ArrayList;
import java.util.HashMap;

import static jks.ht.Vars.GVars_Heart.save;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer.ShapeType;
import com.badlogic.gdx.math.Vector2;

import jks.ht.Vars.GVars_Heart;
import jks.ht.building.Vars.FVars_Building;
import jks.ht.building.enums.Utils_MaxWorkerCapacity;
import jks.ht.building.index.Index_Texture;
import jks.ht.building.nearbyBonus.ANearbyBonus_Model;
import jks.ht.doc.enums.Enum_Spec_Ressource;
import jks.ht.doc.enums.Enum_Spec_Room;
import jks.ht.gamelogic.drones.DroneGroup;
import jks.ht.gamelogic.drones.Utils_DroneActivity;
import jks.ht.tools.model.Vector2Int;
import jks.ht.view.m.vue.Vue_Game;
import jks.tools2D.camera.GVars_Camera;
import jks.tools2D.inputs.Utils_Input;

public abstract class ARoom_Model 
{
	protected int posX ; 
	protected int posY ;
	protected int sizeX ; 
	protected int sizeY ;
	protected Enum_Spec_Room type; 
	
	protected int currentRoomOccupation ;
	protected int maxRoomOccupation ; 
	
	public Color debuggColor = Color.BLACK ;
	protected Color contour = Color.WHITE ; 
	protected int currentOccupation ; 
	protected int bonusMaxOccupation ;
	
	protected int roomLvl ; 
	
	protected DroneGroup droneGroup ;
	protected HashMap<Enum_Spec_Ressource,Integer> storingCapacity; 
	
	protected ArrayList<ANearbyBonus_Model> nearbyBonus ; 
	
	public void setSelected()
	{
		contour= Color.YELLOW ; 
		showLife(true) ;
	}
	
	public void setBackNormal()
	{
		contour = Color.WHITE ;
		showLife(false) ;
	}
	 
	public ARoom_Model(int PosX, int PosY, int SizeX, int SizeY)
	{
		posX = PosX ;
		posY = PosY ;
		sizeX = SizeX ;
		sizeY = SizeY ;
		initDrawingValues();
		roomLvl = 1 ; 
	}
	
	public ARoom_Model(int SizeX, int SizeY)
	{
		sizeX = SizeX ;
		sizeY = SizeY ;
		roomLvl = 1 ; 
	}
	
	
	protected float drawPosX ; 
	protected float drawPosY ; 
	
	public void initDrawingValues()
	{
		drawPosX = lockRefX + (posX * roomSizeX) ;
		drawPosY = lockRefY + (posY * roomSizeY) ;
	}
	
	
	public void draw()
	{
		if(GVars_Heart.debbug)
		{
			render_ShapeFill.begin(ShapeType.Filled);
			render_ShapeFill.setColor(debuggColor);
			render_ShapeFill.rect(drawPosX, drawPosY, FVars_Building.roomSizeX * sizeX, FVars_Building.roomSizeY * sizeY);
			render_ShapeFill.end();
		}
		else 
		{
			for(int x = 0 ; x < sizeX ; x ++)
			{
				for(int y = 0 ; y < sizeY ; y ++)
				{GVars_Camera.batch.draw(getTexture(), drawPosX + FVars_Building.roomSizeX * x, drawPosY + FVars_Building.roomSizeY * y, FVars_Building.roomSizeX, FVars_Building.roomSizeY);}
			}
		}
		
		render_ShapeLine.setColor(contour);
		render_ShapeLine.rect(drawPosX, drawPosY, FVars_Building.roomSizeX * sizeX, FVars_Building.roomSizeY * sizeY);
	}
	
	public void addToHive()
	{
		for(int x = 0 ; x < sizeX ; x ++)
		{
			for(int y = 0 ; y < sizeY ; y ++)
			{save.getHiveMap().put(GVars_Heart.positionPool.getPos(posX + x, posY + y), this) ;}
		}

		initShow();
	}
	
	public void addToHive(HashMap<Vector2Int, ARoom_Model> hiveMap)
	{
		for(int x = 0 ; x < sizeX ; x ++)
		{
			for(int y = 0 ; y < sizeY ; y ++)
			{hiveMap.put(GVars_Heart.positionPool.getPos(posX + x, posY + y), this) ;}
		}
	}
	
	public void initShow()
	{
		Vue_Game.drawinglist_room.add(this);
		Utils_DroneActivity.setRoomLife(this);
	}
	
	public void removeFromHive()
	{
		for(int x = 0 ; x < sizeX ; x ++)
		{
			for(int y = 0 ; y < sizeY ; y ++)
			{
//				GVars_Heart.positionPool.getPos(posX + x, posY + y).re
				save.getHiveMap().remove(GVars_Heart.positionPool.getPos(posX + x, posY + y)) ;
			}
		}
		
		Vue_Game.drawinglist_room.removeValue(this, true);
	}
	
	public void levelUp() 
	{
		Utils_Input.deselectRoom();
		roomLvl++ ;
		Utils_Input.selectRoom(this);
	}
	
	public float currentEfficacity()
	{
		float eff = currentRoomOccupation/maxRoomOccupation ; 
		eff *= sizeX * sizeY; 
		
		return eff ;
	}
		
	public void collecRessource()
	{
		
	}
	
	
	public ArrayList<String> checkIfCanLevelUp()
	{
//		if(roomLvl = FVars_Building.)
		
		
		
		return null ; 
	}
	
	
	public void showLife(boolean show)
	{droneGroup.isShow = show ; }
	
	public Texture getTexture()
	{return Index_Texture.Base ;}

	
	public int maxSizeX()
	{return 3 ;}
	
	public int maxSizeY()
	{return 3 ;}

	public Enum_Spec_Room getType()
	{return type;}

	public void setType(Enum_Spec_Room type)
	{this.type = type;}

	public int getSizeX()
	{return sizeX;}

	public void setSizeX(int sizeX)
	{this.sizeX = sizeX;}

	public int getSizeY()
	{return sizeY;}

	public void setSizeY(int sizeY)
	{this.sizeY = sizeY;}

	public int getPosX()
	{return posX;}

	public void setPosX(int posX)
	{this.posX = posX;}

	public int getPosY()
	{return posY;}

	public void setPosY(int posY)
	{this.posY = posY;}
	
	public int getMaxCapacity()
	{return Utils_MaxWorkerCapacity.getIsCapacity(this) ;}

	public int getCurrentOccupation()
	{return currentOccupation;}

	public void setCurrentOccupation(int currentOccupation)
	{this.currentOccupation = currentOccupation;}

	public int getBonusMaxOccupation()
	{return bonusMaxOccupation;}

	public void setBonusMaxOccupation(int bonusMaxOccupation)
	{this.bonusMaxOccupation = bonusMaxOccupation;}
	
	public int getSize()
	{return sizeX * sizeY ;}

	public int getRoomLvl()
	{return roomLvl;}

	public void setRoomLvl(int roomLvl)
	{this.roomLvl = roomLvl;}	
	
	public DroneGroup getDroneGroup() 
	{return droneGroup;}

	public void setDroneGroup(DroneGroup droneGroup) 
	{this.droneGroup = droneGroup;}

	

	
}