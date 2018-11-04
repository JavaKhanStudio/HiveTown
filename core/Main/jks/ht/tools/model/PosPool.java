package jks.ht.tools.model;

import com.badlogic.gdx.utils.Array;

import jks.ht.building.Vars.FVars_Building;

public class PosPool 
{

	Array<Array<Vector2Int>> pos_Left = new Array<Array<Vector2Int>>(); 
	Array<Array<Vector2Int>> pos_Right = new Array<Array<Vector2Int>>(); 
	
	public PosPool()
	{
		Array<Vector2Int> line ;
		int currentMaxHeight = FVars_Building.hauteurMax ;
		Array<Vector2Int> pointZero = new Array<Vector2Int>() ;
		
		for(int y = 0 ; y <= FVars_Building.hauteurMax; y ++)
		{pointZero.add(new Vector2Int(0,y));}
		
		//Gestion du cas de figure 0
		pos_Right.add(pointZero);
		pos_Left.add(pointZero);
		
		// calcule de chaque posX autre que 0 ;
		for(int x = 1 ; x <= FVars_Building.largeurMax ; x ++)
		{
			pos_Right.add(new Array<Vector2Int>()) ;
			pos_Left.add(new Array<Vector2Int>()) ;
			
			for(int y = 0 ; y <=  getMaxHeight(x); y ++)
			{
				pos_Right.get(x).add(new Vector2Int(x,y)) ; 
				pos_Left.get(x).add(new Vector2Int(-x,y)) ; 
			}
		}
	}
	
	public static int getMaxHeight(int x)
	{return FVars_Building.hauteurMax - ((x/FVars_Building.grandeurEtage) * FVars_Building.grandeurEtage);}
	
	public Vector2Int getPos(int x, int y)
	{
		if(x >= 0)
		{return pos_Right.get(x).get(y) ;}
		else
		{return pos_Left.get(Math.abs(x)).get(y);}
	}

	public Array<Array<Vector2Int>> getPos_Left() 
	{return pos_Left;}

	public void setPos_Left(Array<Array<Vector2Int>> pos_Left) 
	{this.pos_Left = pos_Left;}

	public Array<Array<Vector2Int>> getPos_Right() 
	{return pos_Right;}

	public void setPos_Right(Array<Array<Vector2Int>> pos_Right) 
	{this.pos_Right = pos_Right;}

}
