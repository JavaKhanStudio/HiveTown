package jks.ht.doc.enums;

public enum Enum_Spec_Ressource
{
	// Need storage
	FOOD(Enum_Spec_Room.FOOD),
	INDUSTRIE(Enum_Spec_Room.INDUSTRIE),
	WEAPON(Enum_Spec_Room.WEAPON),
	POPULATION,
	SOLDIER,
	// Don't need storage
	IMPERIAL_CREDIT("credit"),
	GOLDEN_AQUILA("goldenAquila"),
	// Special Ressource
	POLLUTION("pollution"),
	HERESY("heresy"),
	;
	
	private static final String path = "building/ressource/";
	
	Enum_Spec_Ressource()
	{
		
	}
	
	Enum_Spec_Ressource(Enum_Spec_Room roomRef)
	{
		setIconPath(roomRef.getIconPath()) ; 
	}
	
	private String iconPath ;
	
	Enum_Spec_Ressource(String IconPath)
	{
		setIconPath(path + IconPath + ".png");
	}

	public String getIconPath() 
	{return iconPath;}

	public void setIconPath(String iconPath) 
	{this.iconPath = iconPath;}
}
