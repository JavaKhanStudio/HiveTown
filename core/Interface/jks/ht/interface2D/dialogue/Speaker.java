package jks.ht.interface2D.dialogue;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;

public class Speaker 
{
	String name ;
	public Texture speakerImage ; 
	
	boolean rightSide ; 
	
	public Speaker(String name, String speakerImagePath)
	{
		this.name = name ; 
		this.speakerImage = new Texture(Gdx.files.internal(speakerImagePath));
	}
	
}
