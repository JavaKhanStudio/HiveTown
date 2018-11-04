package jks.ht.format;

import java.util.HashMap;

import javax.xml.bind.annotation.XmlElement;

import jks.ht.building.enums.Utils_RoomStorageCapacity;
import jks.ht.doc.enums.Enum_Spec_Ressource;

public class Hive_OM_Ressources 
{
	
	public static Hive_OM_Ressources init() 
	{
		Hive_OM_Ressources returning = new Hive_OM_Ressources() ; 
		
		HashMap<Enum_Spec_Ressource,Integer> refStorage = Utils_RoomStorageCapacity.storage_Reactor.get(1) ;
		returning.setMaxIndustrie(refStorage.get(Enum_Spec_Ressource.INDUSTRIE));
		returning.setMaxFood(refStorage.get(Enum_Spec_Ressource.FOOD));
		
		returning.setIndustrie(500);
		returning.setFood(500);
		returning.setImperialCredit(1000);
		returning.setGoldenAquila(100);
		
		return returning ; 
	}
	
	//	//	//	//	//
	//  SIMPLE TYPE // 
	//	//	//	//	//
	@XmlElement
	private int industrie, maxIndustrie ; 
	
	@XmlElement
	private int food, maxFood ; 
	
	@XmlElement
	private int weapon,maxWeapon ;
	
	@XmlElement
	private int population, maxPopulation ;
	
	@XmlElement
	private int imperialCredit, goldenAquila ;
	
	public int getIndustrie()
	{return industrie;}
	
	public void setIndustrie(int Industrie)
	{this.industrie = Industrie;}
	
	public int getMaxIndustrie()
	{return maxIndustrie;}
	
	public void setMaxIndustrie(int maxIndustrie)
	{this.maxIndustrie = maxIndustrie;}
	
	public int getFood()
	{return food;}
	
	public void setFood(int food)
	{this.food = food;}
	
	public int getMaxFood()
	{return maxFood;}
	
	public void setMaxFood(int maxFood)
	{this.maxFood = maxFood;}
	
	public int getWeapon()
	{return weapon;}
	
	public void setWeapon(int weapon)
	{this.weapon = weapon;}
	
	public int getMaxWeapon()
	{return maxWeapon;}
	
	public void setMaxWeapon(int maxWeapon)
	{this.maxWeapon = maxWeapon;}
	
	public int getPopulation()
	{return population;}
	
	public void setPopulation(int population)
	{this.population = population;}
	
	public int getMaxPopulation()
	{return maxPopulation;}
	
	public void setMaxPopulation(int maxPopulation)
	{this.maxPopulation = maxPopulation;}

	public int getImperialCredit()
	{return imperialCredit;}

	public void setImperialCredit(int imperialCredit)
	{this.imperialCredit = imperialCredit;}
	
	public int getGoldenAquila()
	{return goldenAquila;}

	public void setGoldenAquila(int goldenAquila)
	{this.goldenAquila = goldenAquila;}

}
