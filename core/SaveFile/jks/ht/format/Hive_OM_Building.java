package jks.ht.format;

import java.io.Serializable;
import java.util.HashMap;

import jks.ht.building.room.ARoom_Model;
import jks.ht.building.room.Room_INFRA_HiveReactor;
import jks.ht.building.room.Room_INFRA_TUNEL;
import jks.ht.tools.model.Vector2Int;

public class Hive_OM_Building implements Serializable
{
	private static final long serialVersionUID = -330603129392297085L;

	private HashMap<Vector2Int, ARoom_Model> hiveMap = new HashMap<Vector2Int, ARoom_Model>();
	private int lvl_mainReactor   ; 
	private int lvl_coridor_Left  ;
	private int lvl_coridor_right ;
	
	private Hive_OM_Building()
	{}
	
	public static Hive_OM_Building init()
	{
		Hive_OM_Building returning = new Hive_OM_Building() ;
		returning.setLvl_coridor_left(1);
		returning.setLvl_mainReactor(1);
		returning.setLvl_coridor_right(0);
		
		new Room_INFRA_HiveReactor(returning.getLvl_mainReactor()).addToHive(returning.hiveMap);
		new Room_INFRA_TUNEL(returning.getLvl_corridor_left(),false).addToHive(returning.hiveMap);
		new Room_INFRA_TUNEL(returning.getLvl_corridor_right(),true).addToHive(returning.hiveMap);
		
		return returning ;
	}
	
	
	public int getLvl_mainReactor()
	{return lvl_mainReactor;}
	
	public void setLvl_mainReactor(int lvl_mainReactor)
	{this.lvl_mainReactor = lvl_mainReactor;}
	
	public int getLvl_corridor_left()
	{return lvl_coridor_Left;}
	
	public void setLvl_coridor_left(int lvl)
	{this.lvl_coridor_Left = lvl;}
	
	public int getLvl_corridor_right()
	{return lvl_coridor_right;}
	
	public void setLvl_coridor_right(int lvl)
	{this.lvl_coridor_right = lvl;}
	
	public static long getSerialversionuid()
	{return serialVersionUID;}

	public HashMap<Vector2Int, ARoom_Model> getHiveMap() 
	{return hiveMap;}

	public void setHiveMap(HashMap<Vector2Int, ARoom_Model> hiveMap)
	{this.hiveMap = hiveMap;}
	
	
	
}
