package jks.ht.building.Vars;

import jks.ht.Vars.FVars_GlobalData;

public class FVars_Building 
{
	public static final int room_LogicSizeX = 10 ; 
	public static final int room_LogicSizeY = 5 ; 
	
	public static final int roomSizeX = FVars_GlobalData.caseSize * room_LogicSizeX;
	public static final int roomSizeY = FVars_GlobalData.caseSize * room_LogicSizeY; 
	
	public static final int lockRefX = 1300; 
	public static final int lockRefY = FVars_GlobalData.caseSize * 2; 
	
	public static final int grandeurEtage = 2 ; 
	public static final int grandeurBloc = 5 ; 
	public static final int largeurMax = 32;
	public static final int hauteurMax = 32;
	
	public static int roomMaxSize = 2 ; 

}


//public static final ArrayList<Integer> largeurEtage = new ArrayList<Integer>()
//{{
//    add(9);
//    add(6);
//    add(5);
//    add(4);
//    add(3);
//}};

