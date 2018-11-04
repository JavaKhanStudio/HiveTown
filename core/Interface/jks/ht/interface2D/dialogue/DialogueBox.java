package jks.ht.interface2D.dialogue;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.rafaskoberg.gdx.typinglabel.TypingLabel;

import jks.ht.interface2D.GVars_Interface;

public class DialogueBox extends Table 
{
	
	TypingLabel textLabel ; 
	Image cadre ;
	float speakerSize ; 
	
	float decalY ; 
	float decalX ;
	float textHeight ;
	
	
	
	public DialogueBox(String text, Speaker speaker)
	{
		this.setLayoutEnabled(false);
		this.setSize(Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
		speakerSize = Gdx.graphics.getWidth()/4 ; 
		decalY = Gdx.graphics.getWidth()/15 ; 
		decalX = Gdx.graphics.getWidth()/10 ; 
		textHeight = Gdx.graphics.getHeight()/8 ;
		
		
		textLabel = new TypingLabel(text, GVars_Interface.baseSkin) ; 
		textLabel.setSize(Gdx.graphics.getWidth() - (2*decalX), textHeight);
		textLabel.setPosition(decalX, decalY);
		textLabel.setWrap(true);
		
		cadre = new Image(new Texture(Gdx.files.internal("interface/cadre.png"))) ; 
		cadre.setSize(Gdx.graphics.getWidth(), textHeight + decalY * 2);
		
		this.add(cadre) ;
		this.add(buildSpeaker(speaker,false));
		this.add(textLabel) ; 
	}
	
	public Table buildSpeaker(Speaker speaker, boolean right)
	{
		Table returningTable = new Table() ; 
		returningTable.setLayoutEnabled(false);
		returningTable.setSize(speakerSize, speakerSize);

		Image speakerImage = new Image(speaker.speakerImage) ; 
		speakerImage.setSize(speakerSize,speakerSize);
		
		if(right)
			speakerImage.setX(Gdx.graphics.getWidth() - speakerSize - decalX);
		else
			speakerImage.setX(0);
		
		returningTable.setY(textHeight + decalY * 2);
		returningTable.add(speakerImage) ;
		return returningTable ; 
	}
	
	
}
