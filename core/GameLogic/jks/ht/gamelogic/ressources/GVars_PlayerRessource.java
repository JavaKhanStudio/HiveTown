package jks.ht.gamelogic.ressources;

import jks.ht.Vars.GVars_Heart;
import jks.ht.format.Hive_OM_Ressources;

public class GVars_PlayerRessource 
{

	
	public static int getIndustrie()
	{return getSave().getIndustrie() ;}
	
	public static void setIndustrie(int toSet)
	{getSave().setIndustrie(toSet);}
	
	public static void addIndustrie(int toAdd)
	{getSave().setIndustrie(getSave().getIndustrie() + toAdd);}
	
	public static void removeIndustrie(int toRemove)
	{getSave().setIndustrie(getSave().getIndustrie() - toRemove);}
	
	public static int getFood()
	{return getSave().getFood() ;}
	
	public static void setFood(int toSet)
	{getSave().setFood(toSet) ;}
	
	public static int getMaxFood()
	{return getSave().getMaxFood();}

	public static void setMaxFood(int maxFood)
	{getSave().setMaxFood(maxFood);}

	public static int getWeapon() 
	{return getSave().getWeapon();}

	public static void setWeapon(int weapon) 
	{getSave().setWeapon(weapon);}

	public static int getMaxIndustrie()
	{return getSave().getMaxIndustrie();}

	public static void setMaxIndustrie(int maxIndustrie)
	{getSave().setMaxIndustrie(maxIndustrie);}

	public static int getMaxWeapon()
	{return getSave().getMaxWeapon();}

	public static void setMaxWeapon(int maxWeapon)
	{getSave().setMaxWeapon(maxWeapon);}

	public static int getPopulation()
	{return getSave().getPopulation();}

	public static void setPopulation(int population)
	{getSave().setPopulation(population );}

	public static int getMaxPopulation()
	{return getSave().getPopulation();}

	public static void setMaxPopulation(int maxPopulation)
	{getSave().setMaxPopulation(maxPopulation); ;}
	
	public static int getImperialCredit()
	{return getSave().getImperialCredit();}

	public static int getGoldenAquila()
	{return getSave().getGoldenAquila() ;}
	
	
	private static Hive_OM_Ressources getSave()
	{return GVars_Heart.save.getHiveRessources() ;}
}
