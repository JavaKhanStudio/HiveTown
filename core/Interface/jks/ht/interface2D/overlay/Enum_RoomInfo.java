package jks.ht.interface2D.overlay;

public enum Enum_RoomInfo 
{
	SIZE("Size"),
	LEVEL("Level"),
	POPULATION("Occupation"),
	;
	
	
	String description ;
	
	Enum_RoomInfo(String description)
	{
		this.description = description ;
	}

	public String getDescription() 
	{return description;}
}
