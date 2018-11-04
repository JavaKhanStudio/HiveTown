package jks.ht.interface2D.mainPage;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.ui.Button;
import com.badlogic.gdx.scenes.scene2d.ui.CheckBox;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.utils.ChangeListener;
import com.badlogic.gdx.utils.Align;

import jks.ht.Vars.GVars_Heart;
import jks.ht.index.imageBank.Index_Image;
import jks.ht.interface2D.GVars_Interface;
import jks.ht.interface2D.Init_UI;
import jks.ht.view.m.vue.Vue_Game;
import jks.tools2D.tools.jksCheckBox;

public class Page_Main extends Table
{
	jksCheckBox checkTutorial ; 
	TextureRegion upRegion ;
	TextureRegion downRegion ;
	BitmapFont buttonFont ;
		
	int screenWidth ;
	int screenHeight ;
	
	int buttonSizeX ;
	int buttonSizeY ;
	
	int buttonX ;
	int buttonY ;
		
	public Button resume ; 
	public Button newGame ;
	public Button options ;
	public Button quit ;   	
	
	
	public Page_Main()
	{
		this.defaults().space(25);
		this.setFillParent(true);
		this.setTransform(false);
		
		buttonX = Gdx.graphics.getWidth()/27 ;
		buttonY = Gdx.graphics.getWidth()/30 ;
		
		Image logo = new Image(Index_Image.logo) ;
		resume =    buildButton(" Resume ", false);
		newGame =   buildButton("New game", false);
		options =   buildButton(" Options ", false);
		quit =  	buildButton(" Quit ", false);
		
		checkTutorial = new jksCheckBox("Tutorial :", GVars_Interface.baseSkin,false) ;
		checkTutorial.setChecked(true);
		
		
		this.add(resume).row();
		this.add(newGame);
		this.add(checkTutorial).row();
		this.add(options).row();
		this.add(quit).row();

		this.center().pad(5).defaults().space(30);
		
		GVars_Interface.mainInterface.addActor(this);
		events() ;
	}
	
	Button buildButton (String text, boolean toggle)
	{
		Button button = new Button(GVars_Interface.baseSkin);
		button.setSize(buttonX, buttonY);
		button.pad(buttonY,buttonX,buttonY,buttonX);
		button.setClip(true);
		
		Label label = new Label(text,GVars_Interface.baseSkin);
//		label.setText(text);
		
		label.setAlignment(Align.center);
		button.add(label);
		
//		TextButton button2 = new TextButton(text, skin, toggle ? "toggle" : "default");
//		button.setClip(true);
//		//button.setFillParent(true);
//		button.getLabel().setFillParent(false);
//		setSize(buttonX, buttonY);
		return button;
	}
	
	
	private void events() 
	{
		resume.addListener(new ChangeListener() 
		{
			public void changed (ChangeEvent event, Actor actor) 
			{	
				System.out.println("Not done yet");
			}
		});
		
		newGame.addListener(new ChangeListener() 
		{
			public void changed (ChangeEvent event, Actor actor) 
			{
				GVars_Heart.newGame() ;
				GVars_Heart.changeView(new Vue_Game(checkTutorial.isChecked()));
			}
		});
		
		options.addListener(new ChangeListener() 
		{
			public void changed (ChangeEvent event, Actor actor) 
			{
				System.out.println("suck on that");
			}
		});
		
		quit.addListener(new ChangeListener() 
		{
			public void changed (ChangeEvent event, Actor actor) 
			{
				System.exit(0);
			}
		});
	}
}
