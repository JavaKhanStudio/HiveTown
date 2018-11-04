package jks.ht.building.enums;

import java.util.ArrayList;
import java.util.HashMap;

import jks.ht.doc.enums.Enum_Spec_Ressource;
import jks.ht.doc.enums.Enum_Spec_Room;
import jks.ht.exception.Exception_NoSuchLvl;

public class Utils_RoomStorageCapacity
{

	//SILOS
	public static final ArrayList<HashMap<Enum_Spec_Ressource,Integer>> 
	storage_Silos = new ArrayList<HashMap<Enum_Spec_Ressource,Integer>>()
	{{
		//Lvl 1
		add(new HashMap<Enum_Spec_Ressource,Integer>()
		{{put(Enum_Spec_Ressource.FOOD,1000); put(Enum_Spec_Ressource.INDUSTRIE,1000); }});
		//Lvl 2
		add(new HashMap<Enum_Spec_Ressource,Integer>()
		{{put(Enum_Spec_Ressource.FOOD,1000); put(Enum_Spec_Ressource.INDUSTRIE,1000); }}); 
		//Lvl 3
		add(new HashMap<Enum_Spec_Ressource,Integer>()
		{{put(Enum_Spec_Ressource.FOOD,3000); put(Enum_Spec_Ressource.INDUSTRIE,3000); }});	
	}} ;
	
	//REACTOR
	public static final ArrayList<HashMap<Enum_Spec_Ressource,Integer>> 
	storage_Reactor = new ArrayList<HashMap<Enum_Spec_Ressource,Integer>>()
	{{
		//Lvl 1
		add(new HashMap<Enum_Spec_Ressource,Integer>()
		{{
			put(Enum_Spec_Ressource.FOOD,1000); put(Enum_Spec_Ressource.INDUSTRIE,1000); 
			put(Enum_Spec_Ressource.POPULATION,1000); put(Enum_Spec_Ressource.SOLDIER,100); 
		}}) ;
		//Lvl 2
		add(new HashMap<Enum_Spec_Ressource,Integer>()
		{{
			put(Enum_Spec_Ressource.FOOD,1000); put(Enum_Spec_Ressource.INDUSTRIE,1000); 
			put(Enum_Spec_Ressource.POPULATION,1000); put(Enum_Spec_Ressource.SOLDIER,100); 
		}}) ;
		//Lvl 3
		add(new HashMap<Enum_Spec_Ressource,Integer>()
		{{
			put(Enum_Spec_Ressource.FOOD,1000); put(Enum_Spec_Ressource.INDUSTRIE,1000); 
			put(Enum_Spec_Ressource.POPULATION,1000); put(Enum_Spec_Ressource.SOLDIER,100); 
		}}) ;
	}};
	
	
	public static HashMap<Enum_Spec_Ressource,Integer> getStorageCapacity(Enum_Spec_Room roomType, int lvl) throws Exception_NoSuchLvl
	{
		ArrayList<HashMap<Enum_Spec_Ressource,Integer>> list = null; 
		switch(roomType)
		{
			case REACTOR :
			{list = storage_Reactor ; break;}
			
			default:
				
		}
		
		if(list.size() < lvl - 1) throw new Exception_NoSuchLvl() ;
		
		return list.get(lvl - 1) ; 
	}
	
	
}
