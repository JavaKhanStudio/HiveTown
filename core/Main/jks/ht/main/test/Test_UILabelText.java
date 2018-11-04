package jks.ht.main.test;

import com.badlogic.gdx.ApplicationListener;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.rafaskoberg.gdx.typinglabel.TypingLabel;

import jks.ht.index.imageBank.Index_Speaker;
import jks.ht.interface2D.GVars_Interface;
import jks.ht.interface2D.dialogue.DialogueBox;
import jks.ht.interface2D.dialogue.Speaker;

public class Test_UILabelText implements ApplicationListener  
{

	TypingLabel label2 ; 
	@Override
	public void create() 
	{
		GVars_Interface.init();
		Index_Speaker.init();
		// BEFORE
//		Label label = new Label("Hello world!", GVars_Interface.baseSkin);
//		label.setBounds(100, 100, 200, 200);

		// AFTER
//		String text = "Hello,{WAIT} world!"
//			    + "{SLOWER} THIS IS ONLY NINJA?";
//		label2 = new TypingLabel(text, GVars_Interface.baseSkin);
//		GVars_Interface.mainInterface.addActor(label);
//		GVars_Interface.mainInterface.addActor(label2);
		DialogueBox dialogue = new DialogueBox("Bonjour, mon nom est Sweet Marie, ceci est mon test, et j'aimerai le voir faire marché!", Index_Speaker.sweetMarie) ; 
		GVars_Interface.mainInterface.addActor(dialogue);
	}
	
	@Override
	public void resize(int width, int height) 
	{
		
	}
	
	@Override
	public void render() 
	{
		Gdx.gl.glClearColor(0, 1, 1, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		float delta = Math.min(Gdx.graphics.getDeltaTime(), 1 / 30f);
//		label2.act(delta);
		GVars_Interface.mainInterface.act();
		GVars_Interface.mainInterface.draw() ;
	}
	
	@Override
	public void pause() 
	{
		
	}
	
	@Override
	public void resume() 
	{
		
	}
	
	@Override
	public void dispose() 
	{
		
	}
	
}
