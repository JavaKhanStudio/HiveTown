package jks.ht.interface2D.overlay.constructionChoice;

import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.ui.Table;

import jks.ht.index.imageBank.Index_Sign;
import jks.ht.interface2D.Index_InterfaceIcon;
import jks.ht.tools.Utils.Utils_Interface;
import jks.tools2D.animation.gif.AnimatedActor;

public class BonusEffect
{
	boolean positif ;
	String imgPath ;
	
	public static final float iconScale = 0.50f; 
	
	public BonusEffect(String imgPath,boolean positif)
	{
		this.imgPath = imgPath ; 
		this.positif = positif ; 
	}
	
	
	public Table buildIt(float sizeX, float sizeY, float positionX, float positionY)
	{
		Table returning = new Table() ;
		returning.setLayoutEnabled(false) ;
		returning.setSize(sizeX, sizeY) ; 
		
		Image iconImage = new Image(Utils_Interface.buildDrawingRegionTexture(imgPath)) ; 
		iconImage.setSize(sizeX, sizeY);
//		iconImage.setPosition(positionX, positionY);
		
		returning.add(iconImage) ; 
		returning.add(buildBonusSign(new Vector2(sizeX,sizeY)));
		
		returning.setPosition(positionX, positionY);
		return returning ; 
	}
	
	private AnimatedActor buildBonusSign(Vector2 size)
	{
		Vector2 newSize = size.scl(iconScale); 
		Vector2 newPosition = new Vector2(size.x,size.y); 
		
		AnimatedActor actor ; 
		if(positif)
		{
			actor = new AnimatedActor(Index_Sign.plus, newSize,newPosition) ; 	
		}
		else
		{
			actor = new AnimatedActor(Index_Sign.minus, newSize,newPosition) ; 	
		}
		
		
		return actor ; 
	}
}
