package jks.tools.visual;

import com.badlogic.gdx.utils.Array;

import jks.ht.tools.enums.Enum_Direction;
import jks.ht.tools.model.Vector2Int;

public class NearBuildInfo_Fusion extends NearBuildInfo_Model
{
	public int price ;
	public Array<Vector2Int> wouldAddAt ; 
	
	
	public NearBuildInfo_Fusion(Enum_Direction from, Array<Vector2Int> WouldAt)
	{
		super(from) ;
		wouldAddAt = WouldAt ;
	}
}
