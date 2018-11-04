package jks.ht.save;

import java.util.HashMap;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import jks.ht.Vars.GVars_Heart;
import jks.ht.building.enums.Utils_RoomStorageCapacity;
import jks.ht.building.room.ARoom_Model;
import jks.ht.building.room.Room_INFRA_HiveReactor;
import jks.ht.building.room.Room_INFRA_TUNEL;
import jks.ht.doc.enums.Enum_Spec_Ressource;
import jks.ht.format.Hive_OM_Building;
import jks.ht.format.Hive_OM_Ressources;
import jks.ht.tools.model.Vector2Int;

import static jks.ht.Vars.GVars_Heart.positionPool ;

@XmlRootElement
public class Main_Save_File
{

	//	//	//	//	 //
	//  Complex TYPE // 
	//	//	//	//	//
	
	private float pollution ; 
	
	private Hive_OM_Building hiveBuildings ; 
	private Hive_OM_Ressources hiveRessources; 

	
	
	//new game
	public Main_Save_File()
	{
		GVars_Heart.save = this ; 
		setHiveBuildings(Hive_OM_Building.init());
		setHiveRessources(Hive_OM_Ressources.init()) ;
		
	}
	
	public static Main_Save_File loadSaveFile(int thisOne)
	{
		return null ; 
	}
	
	
	public Hive_OM_Building getHiveBuildings()
	{return hiveBuildings;}

	public void setHiveBuildings(Hive_OM_Building hive)
	{this.hiveBuildings = hive;}

	public ARoom_Model getRoom(Vector2Int pos)
	{return hiveBuildings.getHiveMap().get(pos) ;}
	
	public ARoom_Model getRoom(int x, int y)
	{return hiveBuildings.getHiveMap().get(positionPool.getPos(x, y)) ;}
	
	public HashMap<Vector2Int, ARoom_Model> getHiveMap()
	{return hiveBuildings.getHiveMap();}

	public void setHiveMap(HashMap<Vector2Int, ARoom_Model> hiveMap)
	{this.hiveBuildings.setHiveMap(hiveMap) ;}

	public Hive_OM_Ressources getHiveRessources() 
	{return hiveRessources;}

	public void setHiveRessources(Hive_OM_Ressources hiveRessources) 
	{this.hiveRessources = hiveRessources;}

	public float getPollution()
	{return pollution;}

	public void setPollution(float polution) 
	{this.pollution = polution;}
		
}
