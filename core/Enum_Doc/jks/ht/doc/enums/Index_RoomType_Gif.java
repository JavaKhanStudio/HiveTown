package jks.ht.doc.enums;

import jks.tools2D.animation.gif.GifModelData;
import jks.tools2D.tools.GifDecoder;
import jks.tools2D.tools.GlobalTimmer;

public class Index_RoomType_Gif implements Runnable
{
	private static String path = "building/gif/" ;
	private static String path2 = "building/gif2/" ;
	public static GifModelData roomX ;
	
	public static GifModelData admin ;
	public static GifModelData barrack ;
	public static GifModelData church ;
	public static GifModelData food ;
	public static GifModelData silos ;
	public static GifModelData training ;
	public static GifModelData housing ;
	public static GifModelData industrie ;
	
	public static void init()
	{
		//GlobalTimmer.registerTime("GIF") ; 
		roomX = new GifModelData("test/giphy.png",4,8,29,0.05f) ;
		
		admin = new GifModelData(path + "admin.png",9,9,77,0.05f) ;
		barrack = new GifModelData(path+ "barrack.png",5,5,25,0.05f) ;
		church = new GifModelData(path + "church.png",5,6,26,0.085f) ;
		food = new GifModelData(path + "food.png",9,9,81,0.12f) ;
		silos = new GifModelData(path + "silos.png",8,9,68,0.05f) ;
		training = new GifModelData(path + "training.png",7,7,45,0.05f) ;
		housing = new GifModelData(path + "housing.png",3,4,11,0.05f) ;
		industrie = new GifModelData(path + "industrie.png",2,2,4,0.2f) ;
		//GlobalTimmer.getElapse("GIF") ; 
	}
	
	public static void init3()
	{
		
	}
	
	// too slow
	public static void init2()
	{
		roomX = new GifModelData("test/giphy.gif") ;
		
		admin = new GifModelData(path2 + "admin.gif") ;
		barrack = new GifModelData(path2 + "barrack.gif") ;
		church = new GifModelData(path2 + "church.gif") ;
		food = new GifModelData(path2 + "food.gif") ;
		silos = new GifModelData(path2 + "silos.gif") ;
		training = new GifModelData(path2 + "training.gif") ;
		housing = new GifModelData(path2 + "housing.gif") ;
		industrie = new GifModelData(path2 + "industrie.gif") ;
	}
	
	public static GifModelData getGif(Enum_Spec_Room type)
	{
		switch(type)
		{
			case ADMIN : return admin ; 
			case BARRACK : return barrack ;
			case CHURCH : return church ;
			case FOOD : return food ;
			case SILOS : return silos ;
			case TRAINING : return training ;
			case HOME : return housing ; 
			case INDUSTRIE : return industrie ; 
			
			default : return roomX ;
		}
	}

	@Override
	public void run()
	{init() ; }
	
	
}
