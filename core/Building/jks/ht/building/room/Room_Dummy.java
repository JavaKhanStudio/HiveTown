package jks.ht.building.room;

public class Room_Dummy extends ARoom_Model
{

	public Room_Dummy(int PosX, int PosY, int SizeX, int SizeY) 
	{
		super(PosX, PosY, SizeX, SizeY);
	}

	@Override
	public int getMaxCapacity()
	{return 100;}

	

}
