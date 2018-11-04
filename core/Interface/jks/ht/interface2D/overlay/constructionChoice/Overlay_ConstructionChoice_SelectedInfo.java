package jks.ht.interface2D.overlay.constructionChoice;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.ui.Window;
import com.badlogic.gdx.utils.Align;

import jks.ht.doc.enums.Enum_Spec_Room;
import jks.ht.interface2D.GVars_Interface;
import jks.tools2D.animation.gif.AnimatedActor;

public class Overlay_ConstructionChoice_SelectedInfo extends Window  
{
	private AnimatedActor gifPresentation ;
	
	private Label name_label ;
	private Label type_label ;
	private Table effect_VG ; 
	private Label cout_Label ;
	
	private Label description_visual ;
	
	private static final int decalX = 17; 
	private static final int decalY = 5; 
	
	public Overlay_ConstructionChoice_SelectedInfo(Overlay_ConstructionChoice ref)
	{
		super("test",GVars_Interface.baseSkin) ; 
		this.setLayoutEnabled(false) ;
		
		float startAtX = ref.getPositionX(4) ;
		
		this.setSize(
				Gdx.graphics.getWidth() - startAtX - decalX, 
				Gdx.graphics.getHeight() - ref.getPositionY(1) + ref.iconSizeY/2);
		
		this.setPosition(startAtX - decalX, ref.getPositionY(3) );
		
		name_label = new Label("Selected :",GVars_Interface.baseSkin) ; 
		name_label.setAlignment(Align.center) ;
		name_label.setWidth(this.getWidth());
		name_label.setHeight(ref.iconSizeY/2);
		name_label.setPosition(0, this.getHeight() - name_label.getHeight());

		gifPresentation = new AnimatedActor() ;
		gifPresentation.setSize(this.getWidth()/2.5f, this.getHeight()/1.8f - name_label.getHeight() + decalX * 2);
		float refHeight = this.getHeight()/2 - gifPresentation.getHeight()/2 - name_label.getHeight()/2 ; 
		gifPresentation.setPosition(this.getWidth() - gifPresentation.getWidth() - decalX, refHeight) ; 
		
		
		float labelSizeX = this.getWidth() - gifPresentation.getX() - (decalX * 2) ; 
		float labelSizeY = this.getHeight()/7 ; 
		
		type_label = new Label("Type :",GVars_Interface.baseSkin) ; 
		type_label.setSize(labelSizeX, labelSizeY);
		type_label.setPosition(decalX, refHeight + gifPresentation.getHeight() - (labelSizeY/2)) ; 
		
		
		Label effect_label = new Label("Bonus : ",GVars_Interface.baseSkin) ;
		effect_label.setHeight(labelSizeY);
		effect_label.setPosition(decalX, type_label.getY() - type_label.getHeight() - decalY) ; 
		
		effect_VG = new Table();  
		effect_VG.setLayoutEnabled(false) ;
		effect_VG.setSize(labelSizeX - effect_label .getWidth(), labelSizeY);
		effect_VG.setPosition(decalX + effect_label.getWidth(), type_label.getY() - type_label.getHeight() - decalY) ; 
		
		cout_Label = new Label("Cost : ",GVars_Interface.baseSkin) ;
		cout_Label.setSize(labelSizeX, labelSizeY);
		cout_Label.setPosition(decalX, effect_VG.getY() - effect_VG.getHeight() - decalY) ; 
		
		this.add(name_label);
		this.add(type_label);
		this.add(gifPresentation);
		this.add(effect_label);
		this.add(effect_VG) ; 
		this.add(cout_Label) ; 
		
	}
	
	public void buildDescription()
	{
		
	}
	
	public void buildEffectVisualTable(Enum_Spec_Room room)
	{
		effect_VG.clear();
		
		float size = effect_VG.getHeight(); 
		float position = 0 ; 
		
		for(BonusEffect effect : room.getEffectList())
		{
			effect_VG.add(effect.buildIt(size,size,position,0));
			position += size ;
		}
	}
	
	public void selectConstruction(Enum_Spec_Room room)
	{
		name_label.setText("Selected : " + room.getDisplayName());
		type_label.setText("Type : " + room.getType().name());
		buildEffectVisualTable(room) ;

		gifPresentation.setRef(room.getScreenCapPres());
	}


	public void deselect()
	{
		name_label.setText("Selected :");
	}
	
	
	
	
}
