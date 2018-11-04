package jks.ht.tools.enums;

import jks.ht.Vars.GVars_Heart;
import jks.ht.tools.model.Vector2Int;

public enum Enum_Direction
{
	TOP,
	LEFT,
	RIGHT,
	BOTTOM,
	
	;
	
	public Vector2Int getFrom(Vector2Int pos)
	{
		switch(this)
		{
			case TOP :
			{return GVars_Heart.positionPool.getPos(pos.x, pos.y + 1);}
			case BOTTOM :
			{return GVars_Heart.positionPool.getPos(pos.x, pos.y - 1);}
			case LEFT :
			{return GVars_Heart.positionPool.getPos(pos.x - 1, pos.y);}
			case RIGHT :
			{return GVars_Heart.positionPool.getPos(pos.x + 1, pos.y);}
		
			default :
			{System.out.println("How the fuck? Enum_direct") ; return null ;}
		}
	}
	
	public Vector2Int getWhere(Vector2Int pos)
	{
		switch(this)
		{
			case TOP :
			{return GVars_Heart.positionPool.getPos(pos.x, pos.y - 1);}
			case BOTTOM :
			{return GVars_Heart.positionPool.getPos(pos.x, pos.y + 1);}
			case LEFT :
			{return GVars_Heart.positionPool.getPos(pos.x + 1, pos.y);}
			case RIGHT :
			{return GVars_Heart.positionPool.getPos(pos.x - 1, pos.y);}
		
			default :
			{System.out.println("How the fuck? Enum_direct") ; return null ;}
		}
	}
	
	public static Enum_Direction getFrom(Vector2Int from, Vector2Int too)
	{
		if(from.getX() != too.getX())
		{
			if(from.getX() < too.getX())
			{return LEFT;}
			else
			{return RIGHT;}
		}
		else
		{
			if(from.getY() < too.getY())
			{return BOTTOM;}
			else
			{return TOP;}
		} 
	}
	
}
