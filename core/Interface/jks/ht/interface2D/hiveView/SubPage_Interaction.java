package jks.ht.interface2D.hiveView;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.InputListener;
import com.badlogic.gdx.scenes.scene2d.ui.ImageButton;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.utils.ChangeListener;

import jks.ht.Vars.GVars_Heart;
import jks.ht.interface2D.GVars_Interface;
import jks.ht.interface2D.Index_InterfaceIcon;
import jks.ht.interface2D.overlay.constructionChoice.Overlay_ConstructionChoice;
import jks.ht.tools.Utils.Utils_Interface;
import jks.tools2D.inputs.GVars_Inputs;
import jks.tools2D.inputs.Utils_Input;
import jks.tools2D.view.utils.Utils_View;

public class SubPage_Interaction extends Table
{
		 
	int iconSize ;
	int decal = 16 ; 
	int sidePosition ;
	
	private ImageButton buildIcon ;
	private ImageButton missionsIcon;
	private ImageButton statsIcon ; 
	
	public SubPage_Interaction()
	{
		this.setLayoutEnabled(false);
		iconSize = Gdx.graphics.getWidth()/14 ; 
		sidePosition = Gdx.graphics.getWidth() - decal - iconSize ;
		turnIntoSelection() ; 
		GVars_Interface.interaction = this ; 
		
	}
	
	public void turnIntoSelection()
	{
		this.clear();
		
		buildIcon = new ImageButton(Index_InterfaceIcon.icon_build) ;
		buildIcon.setSize(iconSize, iconSize);
		buildIcon.setPosition(sidePosition, Gdx.graphics.getHeight() - decal - iconSize);
		buildEvent_build(buildIcon) ;
		
		missionsIcon = new ImageButton(Index_InterfaceIcon.icon_missions) ;
		missionsIcon.setSize(iconSize, iconSize);
		missionsIcon.setPosition(sidePosition, Gdx.graphics.getHeight() - decal * 2 - iconSize*2);
		buildEvent_build(missionsIcon) ;
		
		statsIcon = new ImageButton(Index_InterfaceIcon.icon_stats) ;
		statsIcon.setSize(iconSize, iconSize);
		statsIcon.setPosition(sidePosition, Gdx.graphics.getHeight() - decal * 3 - iconSize * 3);
		buildEvent_build(statsIcon) ;
		
		this.add(buildIcon);
		this.add(missionsIcon);
		this.add(statsIcon);
	}
	
	public ImageButton turnIntoDeselection()
	{
		this.clear();
		
		
		
		ImageButton cancel = new ImageButton(Index_InterfaceIcon.icon_Cancel) ; 
		cancel.setSize(iconSize, iconSize);
		cancel.setPosition(sidePosition, Gdx.graphics.getHeight() - decal - iconSize);
		
		if(GVars_Heart.getTutorial() != null)
			return cancel;
		
		cancel.addListener(new InputListener()
		{
			@Override
	        public boolean touchDown (InputEvent event, float x, float y, int pointer, int button) 
	        {
				GVars_Inputs.blockActionForClick = true ; 
				return true ; 
	        }

			@Override
	        public void touchUp (InputEvent event, float x, float y, int pointer, int button) 
	        {
				Utils_View.removeCurrentOverlay() ;
				GVars_Interface.interaction.turnIntoSelection();
				Utils_View.removeFilter() ;
			}
		});
	      
		this.add(cancel) ; 
		return cancel ; 
	}
	
	private void buildEvent_build(ImageButton buildIcon) 
	{
		buildIcon.addListener(new ChangeListener() 
		{
			public void changed (ChangeEvent event, Actor actor) 
			{
				Utils_View.removeCurrentOverlay();
				Utils_Input.deselectRoom();
				
				Overlay_ConstructionChoice.build() ;
			}
		});
		
		buildIcon.addListener(new InputListener()
		{
			@Override
	        public boolean touchDown (InputEvent event, float x, float y, int pointer, int button) 
	        {
				GVars_Inputs.blockActionForClick = true ; 
				return true ; 
	        }
		});
	}
	
	public void setAsTutorial() 
	{
		buildIcon.setDisabled(true);
		missionsIcon.setDisabled(true);
		statsIcon.setDisabled(true);
	}
	
	
	public int getSidePosition() 
	{return sidePosition;}

	public void setSidePosition(int sidePosition) 
	{this.sidePosition = sidePosition;}

	public ImageButton getBuildIcon() 
	{return buildIcon;}

	public void setBuildIcon(ImageButton buildIcon) 
	{this.buildIcon = buildIcon;}

	public ImageButton getMissionsIcon()
	{return missionsIcon;}

	public void setMissionsIcon(ImageButton missionsIcon) 
	{this.missionsIcon = missionsIcon;}
}
