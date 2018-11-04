package jks.ht.doc.enums;

import java.util.ArrayList;

import jks.ht.building.room.ARoom_Model;
import jks.ht.building.room.Room_LIVING_ADMIN;
import jks.ht.building.room.Room_LIVING_CHURCH;
import jks.ht.building.room.Room_LIVING_HOME;
import jks.ht.building.room.Room_RESSOURCE_FOOD;
import jks.ht.building.room.Room_RESSOURCE_INDUSTRIE;
import jks.ht.building.room.Room_RESSOURCE_SILOS;
import jks.ht.building.room.Room_WAR_BARRACK;
import jks.ht.building.room.Room_WAR_TRAINING;
import jks.ht.building.room.Room_WAR_WEAPON;
import jks.ht.interface2D.overlay.constructionChoice.BonusEffect;
import jks.ht.tools.model.Vector2Int;
import jks.tools2D.animation.gif.GifModelData;

public enum Enum_Spec_Room 
{
	//MAIN CHAIN
	REACTOR(),
	TUNEL(),
	
	//RESSOURCE CHAIN
	INDUSTRIE("IR_INDUSTRIE",Enum_Spec_RoomType.RESSOURCE), 			// allow mineral production
	FOOD("IR_FOOD",Enum_Spec_RoomType.RESSOURCE),						// allow food production
	SILOS("IR_SILOS",Enum_Spec_RoomType.RESSOURCE),					// Store mineral and food
	
	//WAR CHAIN
	WEAPON("IW_WEAPON",Enum_Spec_RoomType.MILITARY),					// Allow to produce war point to buy unit
	TRAINING("IW_TRAINING",Enum_Spec_RoomType.MILITARY),				// Allow to train solder and vehicule using the war point
	BARRACK("IW_BARRACK",Enum_Spec_RoomType.MILITARY),				// Store the soldier and vehicule
	
	//LIVING CHAIN
	HOME("IL_HOME",Enum_Spec_RoomType.HABITATION),						// Increase max population
	CHURCH("IL_CHURCH",Enum_Spec_RoomType.HABITATION),					// Keep corrumption low
	ADMIN("IL_ADMIN",Enum_Spec_RoomType.HABITATION),					// Produce money, give bonus to surronding and whole hive
	
	// Special
	POLICE(),					// Allow police to lower corrumption
	POLLUTION(),				// Clean the air
	
	
	DUMMY(),
	;
	
	private String referencePath ;
	private String showName ;
	private String description ;
	private int priceLvl = 0 ;
	private Enum_Spec_RoomType type ; 
	
	private static final String iconPath = "building/icon/"; 
	private static final String printScreenPath = "building/screenPath"; 
	
	// MOCK
	Enum_Spec_Room()
	{
		referencePath = "building/icon/cancel" ;
		showName = "default" ; 
		priceLvl = 1000 ; 
	}
	
	Enum_Spec_Room(String IconPath, Enum_Spec_RoomType type)
	{
		referencePath = IconPath ; 
		showName = this.name() ;
		this.type = type ; 
	}
	
	Enum_Spec_Room(String IconPath, String description)
	{referencePath = IconPath ; }
	
	
	public String getIconPath()
	{return iconPath + referencePath + ".png";}
	
	public String getIconPathHover()
	{return iconPath + referencePath + "_HOVER" + ".png";}
	
	public String getIconPathTOP()
	{return iconPath + referencePath + "_TOP" + ".png";}
	
	public GifModelData getScreenCapPres()
	{return Index_RoomType_Gif.getGif(this);}
	
	public Enum_Spec_RoomType getType() 
	{return type;}

	public void setType(Enum_Spec_RoomType type) 
	{this.type = type;}
	
	public String getDisplayName()
	{return showName ;}
	
	public String getDisplayLvlCost()
	{return priceLvl + "" ;}

	public ARoom_Model getNewRoom(Vector2Int pos)
	{
		switch(this)
		{
			case ADMIN : 	  return new Room_LIVING_ADMIN(1, 1, pos, 1);	  
			case CHURCH :     return new Room_LIVING_CHURCH(1, 1, pos, 1);   
			case HOME : 	  return new Room_LIVING_HOME(1, 1, pos, 1); 
		
			case WEAPON : 	  return new Room_WAR_WEAPON(1, 1, pos, 1);      
			case TRAINING :   return new Room_WAR_TRAINING(1, 1, pos, 1); 
			case BARRACK :    return new Room_WAR_BARRACK(1, 1, pos, 1);    
			
			case FOOD :       return new Room_RESSOURCE_FOOD(1, 1, pos, 1);    
			case INDUSTRIE :  return new Room_RESSOURCE_INDUSTRIE(1, 1, pos, 1);    
			case SILOS :      return new Room_RESSOURCE_SILOS(1, 1, pos, 1);    
		}
		
		System.out.println("WHAT THE HELL MATE I AM " + this.name()) ;
		return null ; 
	}

	public ArrayList<BonusEffect> getEffectList() 
	{
		ArrayList<BonusEffect> effectList = new ArrayList<BonusEffect>(); 
		
		switch(this)
		{
			case FOOD :      
			{
				effectList.add(new BonusEffect(getIconPath(), true)) ; break ; 
			}
			case INDUSTRIE :  
			{
				effectList.add(new BonusEffect(getIconPath(), true)) ;
				effectList.add(new BonusEffect(Enum_Spec_Ressource.POLLUTION.getIconPath(), false)) ; break ;   
			}
			case SILOS :      
			{
				effectList.add(new BonusEffect(getIconPath(), true)) ;  break ; 
			}
			
		    case ADMIN :
	    	{
	    		effectList.add(new BonusEffect(HOME.getIconPath(), true)) ; 
	    		effectList.add(new BonusEffect(Enum_Spec_Ressource.IMPERIAL_CREDIT.getIconPath(), true)) ; 
	    		effectList.add(new BonusEffect(Enum_Spec_Ressource.HERESY.getIconPath(), false)) ; 
	    		break ; 
	    	}
			case CHURCH :     
			{
				effectList.add(new BonusEffect(Enum_Spec_Ressource.HERESY.getIconPath(), true)) ; 
				break ; 
			}
			case HOME : 
			{
				effectList.add(new BonusEffect(getIconPath(), true)) ; 
				break ; 
			}
		
			
			case WEAPON : 	  
			{
				effectList.add(new BonusEffect(getIconPath(), true)) ;    
				effectList.add(new BonusEffect(INDUSTRIE.getIconPath(), false)) ;
				break ;   
			}
			case TRAINING : 
			{
				effectList.add(new BonusEffect(getIconPath(), true)) ; break ; 
			}
			case BARRACK :  
			{
				effectList.add(new BonusEffect(getIconPath(), true)) ; break ; 
			}
		}
		
		return effectList ; 
		
	}
}


// Current nb room (unit/WholeSize)
// room price lvl1/lvl2/lvl3