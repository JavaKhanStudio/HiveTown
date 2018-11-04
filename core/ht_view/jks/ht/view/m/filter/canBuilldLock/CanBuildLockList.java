package jks.ht.view.m.filter.canBuilldLock;

import static jks.ht.Vars.GVars_Heart.save;
import static jks.ht.Vars.GVars_Heart.positionPool;

import java.util.HashMap;

import com.badlogic.gdx.utils.Array;

import jks.ht.Vars.GVars_Heart;
import jks.ht.building.enums.Enum_CanBuildState;
import jks.ht.building.room.ARoom_Model;
import jks.ht.doc.enums.Enum_Spec_Room;
import jks.ht.doc.utils.Hive_LvlChart;
import jks.ht.tools.enums.Enum_Direction;
import jks.ht.tools.model.PosPool;
import jks.ht.tools.model.Vector2Int;
import jks.tools.visual.NearBuildInfo_Fusion;
import jks.tools.visual.NearBuildInfo_Model;

public class CanBuildLockList
{
	public HashMap<Vector2Int,Array<NearBuildInfo_Model>> refSide_list_NearInfo ;
	public Array<Array<Enum_CanBuildState>> whatCanBeBuild_Left = new Array<Array<Enum_CanBuildState>>();
	public Array<Array<Enum_CanBuildState>> whatCanBeBuild_Right = new Array<Array<Enum_CanBuildState>>();
	
	
	public int getCurrentMaxX_left ;
	public int getCurrentMaxX_right ;
	public int getCurrentMaxY ;
	

	public CanBuildLockList(Enum_Spec_Room type)
	{initWhatCanBeBuild(type) ; }
	
	public void initWhatCanBeBuild(Enum_Spec_Room type)
	{
		refSide_list_NearInfo =  new HashMap<Vector2Int,Array<NearBuildInfo_Model>>(); 
		whatCanBeBuild_Left.add(new Array<Enum_CanBuildState>()) ;
		
		for(Array<Vector2Int> list : GVars_Heart.positionPool.getPos_Left())
		{whatCanBeBuild_Left.get(0).add(Enum_CanBuildState.underground) ;}
			
		whatCan_side(false,type) ;
	}
	
	
	public Enum_CanBuildState getCanBuild(Vector2Int pos)
	{
		if(pos.x < 0)
		{
			if(whatCanBeBuild_Left.size > pos.x * -1 
			&& whatCanBeBuild_Left.get(pos.x * -1).size > pos.y)
			{return whatCanBeBuild_Left.get(pos.x * -1).get(pos.y) ;}
		}
		else
		{
			if(whatCanBeBuild_Right.size > pos.x && whatCanBeBuild_Right.get(pos.x).size > pos.y)
				return whatCanBeBuild_Right.get(pos.x).get(pos.y) ;
		}
		
		return null ; 
	}
	
	public void setAt (Vector2Int pos, Enum_CanBuildState state)
	{
		if(pos.x < 0)
		{whatCanBeBuild_Left.get(pos.x * -1).set(pos.y, state) ;}
		else
		{whatCanBeBuild_Left.get(pos.x * -1).set(pos.y, state) ;}
	}
	
	
	private void whatCan_side(boolean right, Enum_Spec_Room type)
	{
		Array<Array<Enum_CanBuildState>> refSide_list ;
		Array<NearBuildInfo_Model> listBuffer ; 
		int refSide_maxX ;
		int sideValue ; 
		
		ARoom_Model room ;
		ARoom_Model room_under ; 
		
		
		if(right)
		{
			refSide_list = whatCanBeBuild_Right ;
			refSide_maxX = Hive_LvlChart.getCurrent_MaxWidth_right() ; 
			sideValue= 1 ;
		}
		else
		{
			refSide_list = whatCanBeBuild_Left ; 
			refSide_maxX = Hive_LvlChart.getCurrent_MaxWidth_left() ; 
			sideValue = -1 ; 
		}
		
		for(int x = 1 ; x <=  refSide_maxX ; x ++)
		{
			refSide_list.add(new Array<Enum_CanBuildState>()) ;
			refSide_list.get(x).add(Enum_CanBuildState.underground) ;
			
			for(int y = 1 ; y < getMaxHeight(x) ; y++)
			{
				room = save.getHiveMap().get(positionPool.getPos(x * sideValue, y)) ; 
				
				if(room != null)
				{refSide_list.get(x).add(Enum_CanBuildState.alreadyExist) ;}
				else
				{
					room_under = save.getHiveMap().get(positionPool.getPos(x * sideValue, y-1)) ; 
					
					// The building can be supported 
					if(room_under != null)
					{
						listBuffer = connectionList(x * sideValue,y,type) ;
						// Room as adjacent interaction
						if(listBuffer != null)
						{
							refSide_list_NearInfo.put(positionPool.getPos(x * sideValue, y), listBuffer) ;
							refSide_list.get(x).add(Enum_CanBuildState.canBuildAndNearInfo);
							listBuffer = null ;
						}
						else // Room don't care of what is near
						{refSide_list.get(x).add(Enum_CanBuildState.canBuild);}
					}
					else // Show that if there was bases we could build there
					{refSide_list.get(x).add(Enum_CanBuildState.couldBuild);}
				}
				
				room = null ; 
				
			}
			
		}
	}
	
	public static int getMaxHeight(int x)
	{
		if(Hive_LvlChart.getCurrent_MaxHeight() < PosPool.getMaxHeight(x))
		{return Hive_LvlChart.getCurrent_MaxHeight() ;}
		else
		{return PosPool.getMaxHeight(x) ;}
	}
	
	public Array<NearBuildInfo_Model> connectionList(int x, int y, Enum_Spec_Room type)
	{
		Array<NearBuildInfo_Model> returning = new Array<NearBuildInfo_Model>() ;
		ARoom_Model room_under ; 
		ARoom_Model room_side_left ;
		ARoom_Model room_side_right ;
		
		room_under = save.getHiveMap().get(positionPool.getPos(x, y - 1)) ; 
		room_side_left = save.getHiveMap().get(positionPool.getPos(x - 1, y)) ; 
		room_side_right = save.getHiveMap().get(positionPool.getPos(x + 1, y)) ;
		
		Array<Vector2Int> buildInfoPos = new Array<Vector2Int>() ; 
	
		INVALID: 
		{
			if(room_under != null)
			{
				//Room can fuse
				if(room_under.getType() == type)
				{
					//room is not already at max size
					if(room_under.getSizeY() < room_under.maxSizeY())
					{
						buildInfoPos = new  Array<Vector2Int>() ; 
						//Every space are available
						for(int a = 0 ; a < room_under.getSizeX(); a++)
						{
							if(save.getHiveMap().get(positionPool.getPos(x + a , y)) != null)
							{buildInfoPos = null ; break INVALID ;}
							
							buildInfoPos.add(positionPool.getPos(x + a , y - 1));
						}
						
						returning.add(new NearBuildInfo_Fusion(Enum_Direction.BOTTOM,buildInfoPos)) ; 
					}
				}
				else //Room can't fuse but could give bonus
				{
					
				}
			}
		}
		
		if(room_side_left != null)
		{
			if(room_side_left.getType() == type)
			{
				if(room_side_left.getSizeX() < room_side_left.maxSizeX())
				{
					returning.add(new NearBuildInfo_Fusion(Enum_Direction.LEFT,buildInfoPos)) ;
				}
			}
			else 
			{
				
			}
		}
		
		if(room_side_right != null)
		{
			if(room_side_right.getType() == type)
			{
				if(room_side_right.getSizeX() < room_side_right.maxSizeX())
				{
					returning.add(new NearBuildInfo_Fusion(Enum_Direction.RIGHT,buildInfoPos)) ; 
				}
			}
			else 
			{
				
			}
		}
		
		if(returning.size != 0)
		{return returning ; }
		
		return null ; 
	}
	
	
	public boolean checkForConnection(ARoom_Model room)
	{
	
		return false ; 
	}
	
	
	public void checkForPlusValue(Enum_Spec_Room is, Enum_Spec_Room checkingFor)
	{
		
	}
	
	
}
