package jks.ht.interface2D.hiveView;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture.TextureFilter;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.ProgressBar;
import com.badlogic.gdx.scenes.scene2d.ui.ProgressBar.ProgressBarStyle;
import com.badlogic.gdx.scenes.scene2d.ui.Table;

import jks.ht.doc.enums.Enum_Spec_Colors;
import jks.ht.doc.enums.Enum_Spec_Ressource;
import jks.ht.doc.enums.Enum_Spec_Room;
import jks.ht.gamelogic.ressources.GVars_PlayerRessource;
import jks.ht.interface2D.GVars_Interface;
import jks.ht.tools.Utils.Utils_Interface;

public class SubPage_HiveView_Ressource extends Table
{
	static final int iconSizeX = 45 ; 
	static int barWith = 160 ; 
	static int decalY = 10 ;
	static int decalX = 40 ; 
	
	ProgressBar barFood ; 
	ProgressBar barIndustrie ; 
	ProgressBar barWeapon ; 
	
	
	ProgressBar barPopulation ; 
	ProgressBar barHome ; 
	
	Label imperialCredit ; 
	Label goldenAquila ; 
	
	
	public SubPage_HiveView_Ressource()
	{
		this.setLayoutEnabled(false);
		GVars_Interface.baseSkin.getDrawable("white").setMinHeight(iconSizeX/2.5f); ;
		
		barFood = buildRessource_ProgressBar(Enum_Spec_Room.FOOD.getIconPath(),1,1,Enum_Spec_Colors.BTYPE_RESSOURCE.color) ;
		barFood.setRange(0, GVars_PlayerRessource.getMaxFood());
		barFood.setValue(GVars_PlayerRessource.getFood()) ; 
		
		barIndustrie = buildRessource_ProgressBar(Enum_Spec_Room.INDUSTRIE.getIconPath(),1,2,Enum_Spec_Colors.BTYPE_RESSOURCE.color) ;
		barIndustrie.setRange(0, GVars_PlayerRessource.getMaxIndustrie());
		barIndustrie.setValue(GVars_PlayerRessource.getIndustrie()) ; 
	
		barHome = buildRessource_ProgressBar(Enum_Spec_Room.HOME.getIconPathTOP(),2,1,Enum_Spec_Colors.BTYPE_HABITATION.color) ;
		barHome.setRange(0, GVars_PlayerRessource.getMaxPopulation());
		barHome.setValue(GVars_PlayerRessource.getPopulation()) ; 
		
		barWeapon = buildRessource_ProgressBar(Enum_Spec_Room.WEAPON.getIconPath(),2,2,Enum_Spec_Colors.BTYPE_WAR.color) ;
		barWeapon.setRange(0, GVars_PlayerRessource.getMaxWeapon());
		barWeapon.setValue(GVars_PlayerRessource.getWeapon()) ; 
		
		imperialCredit = buildRessource_Numeric(Enum_Spec_Ressource.IMPERIAL_CREDIT.getIconPath(),3,1) ; 
		updateNumeric(imperialCredit,GVars_PlayerRessource.getImperialCredit(),0) ;
		
		goldenAquila = buildRessource_Numeric(Enum_Spec_Ressource.GOLDEN_AQUILA.getIconPath(),3,2) ; 
		updateNumeric(goldenAquila,GVars_PlayerRessource.getGoldenAquila(),0) ;
	}
	
	public ProgressBar buildRessource_ProgressBar(String iconPath, int x, int y, Color color)
	{
		ProgressBarStyle style = new ProgressBarStyle();
		style.background = GVars_Interface.baseSkin.newDrawable("white", color) ;
		style.knobAfter = GVars_Interface.baseSkin.newDrawable("white", Color.DARK_GRAY) ;
		
		ProgressBar bar = new ProgressBar(0,100,1,false,style) ;
		bar.setWidth(barWith);
		bar.setValue(0) ;
		setIsPosition(bar,x,y) ;
		
		
		this.add(buildImage(iconPath, x, y));
		this.add(bar);
		
		return bar ; 
	}	
	
	public Label buildRessource_Numeric(String imagePath, int x,int y)
	{
		Label label = new Label("", GVars_Interface.baseSkin) ; 
		label.setSize(iconSizeX, iconSizeX/2);
		label.setAlignment(0);
		setIsPosition(label,x,y) ;
		
		this.add(buildImage(imagePath, x, y));
		this.add(label);
		
		return label ; 
	}
	
	public Image buildImage(String iconPath,int x, int y)
	{
		Image image = new Image(Utils_Interface.buildDrawingRegionTexture(iconPath)) ; 
		image.setSize(iconSizeX, iconSizeX);
		image.setPosition(decalX + ((x - 1) * (barWith + iconSizeX * 2)), Gdx.graphics.getHeight() - ((iconSizeX * 1) * y) - decalY );	
		return image ; 
	}
	
	public void setIsPosition(Actor actor, int x, int y)
	{actor.setPosition(decalX + ((x - 1) * (barWith + iconSizeX * 2)) + iconSizeX, Gdx.graphics.getHeight() - ((iconSizeX * 1) * y) - decalY + iconSizeX/5);}
	
	public void updateSelected(Enum_Spec_Ressource type,int bonus, int newMax)
	{
		switch(type)
		{
			case FOOD : updateBar(barFood,bonus,newMax); break ;
			case INDUSTRIE : updateBar(barFood,bonus,newMax); break ; 
			case POPULATION : updateBar(barFood,bonus,newMax); break ; 
			case WEAPON : updateBar(barFood,bonus,newMax); break ;
			
			case IMPERIAL_CREDIT : 
		}
	}
	
	
	public void updateNumeric(Label label,int current,int max)
	{
		String sendString = ""; 
		
		if(current < 1000)
		{
			sendString = current + "" ; 
		}
		else if(current < 100000)
		{
			sendString = current/1000 + "k" ; 
		}
		
		if(max == 0)
		{
			label.setText(sendString);
		}
		else 
		{
			
		}
	}
	
	public void updateBar(ProgressBar bar, int ressourceSurge, int newMax)
	{
		if(ressourceSurge != 0)
		{
			bar.setValue(bar.getValue() + ressourceSurge) ; 
		}
		
		if(newMax != 0)
		{
			bar.setRange(0, newMax);
		}
	}

	public void setAsTutorial() 
	{
		// TODO Auto-generated method stub
		
	}
	
	
}