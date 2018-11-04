package jks.ht.interface2D.overlay;

import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.Window;

public abstract class OverlayModel extends Window
{
	
	public OverlayModel(String title, Skin skin) 
	{super(title, skin);}
	
	//	public OverlayModel(String title, Skin skin) 
//	{
//		super(title, skin);
//	}
	public abstract void destroy() ;
	public abstract boolean disableMainClickAction() ;

}
