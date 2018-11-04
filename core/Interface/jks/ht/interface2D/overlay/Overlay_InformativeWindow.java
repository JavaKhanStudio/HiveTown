package jks.ht.interface2D.overlay;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Touchable;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;

import jks.tools2D.inputs.GVars_Inputs;

public class Overlay_InformativeWindow extends OverlayModel
{

	static float size ; 
	static float decal = 15 ; 
	
	static float height ;
	static float width ;
	static float buttonSize  ;
	
	public Overlay_InformativeWindow(Skin baseSkin)
	{
		super("",baseSkin) ; 
		this.setLayoutEnabled(false) ;
		
		this.setFillParent(false);
		size =  Gdx.graphics.getWidth()/5 ; 
		height = size/3 ;
		width = size/3 ;
		buttonSize = ((height * 3)/4) ;
		
		
		this.setBounds(Gdx.graphics.getWidth() - size - decal , decal,size, size);
			
		setTouchable(Touchable.enabled);
		addListener(new ClickListener()
		{
			@Override
	        public boolean touchDown (InputEvent event, float x, float y, int pointer, int button) 
	        {GVars_Inputs.blockActionForClick = true ;return false ;}
	    });
		
	}


	@Override
	public void destroy() 
	{this.remove() ;}

	@Override
	public boolean disableMainClickAction() 
	{return false;}

}
