package jks.ht.index.imageBank;

import java.util.ArrayList;
import java.util.HashMap;

import com.badlogic.gdx.graphics.Color;
import com.esotericsoftware.spine.Slot;

import jks.tools2D.animation.spine.IndexedData.SpineModelData;
import jks.tools2D.animation.spine.model.enums.Enum_BodyPart;
import jks.tools2D.animation.spine.modif.ModifModel;
import jks.tools2D.animation.spine.modif.Modif_Color;

public class Index_Spire 
{
	
	static SpineModelData ref_Monster ; 
	static SpineModelData ref_MonsterRed; 
	static SpineModelData ref_Soldier; 
	
	public static void init()
	{
		ref_Monster = new SpineModelData("alien/alien.atlas","alien/alien.json",0.10f,null) ;
		ArrayList<ModifModel> modifList = new ArrayList<ModifModel>() ;
		modifList.add(new Modif_Color("head", Color.RED)) ; 
		ref_MonsterRed = new SpineModelData("alien/alien.atlas","alien/alien.json",0.10f,modifList) ;
		
		ref_Soldier = new SpineModelData("spineboy/spineboy.atlas","spineboy/spineboy.json",0.10f,null) ; ; 
	}
	//"spineboy/spineboy.atlas" //"spineboy/spineboy.json"
	public static SpineModelData getSoldier()
	{return ref_Soldier;}
	
	public static SpineModelData getMonster()
	{return ref_Monster;}
	
	public static SpineModelData getMonsterRed()
	{return ref_MonsterRed;}
	
	
}
