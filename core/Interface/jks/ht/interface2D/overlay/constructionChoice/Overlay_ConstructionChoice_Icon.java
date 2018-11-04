package jks.ht.interface2D.overlay.constructionChoice;

import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.InputListener;
import com.badlogic.gdx.scenes.scene2d.actions.Actions;
import com.badlogic.gdx.scenes.scene2d.ui.ImageButton;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Table;

import jks.ht.Vars.GVars_Heart;
import jks.ht.doc.enums.Enum_Spec_Room;
import jks.ht.interface2D.GVars_Interface;
import jks.ht.tools.Utils.Utils_Interface;
import jks.ht.view.background.Utils_Pollution;
import jks.ht.view.m.filter.canBuilldLock.Filter_CanBuildLock;
import jks.tools2D.inputs.GVars_Inputs;
import jks.tools2D.view.utils.Utils_View;

public class Overlay_ConstructionChoice_Icon extends Table
{
	
	public ImageButton icon ; 
	Enum_Spec_Room resultingRoom ; 
	//Label roomName ;
	//Label roomCost ;
	
	private final float scalingBy =  0.96f; 
	private float moveBy ; 
	private float scaleSpeed = 0.1f; 
	private boolean selected ; 
	
	public Overlay_ConstructionChoice_Icon(final Enum_Spec_Room roomType)
	{
		super();
		this.setLayoutEnabled(false) ;
		
		resultingRoom = roomType ;
		
		icon = new ImageButton(Utils_Interface.buildDrawingRegionTexture(roomType.getIconPath()))
		{
			@Override
			public void setDisabled(boolean does)
			{
				super.setDisabled(does);
				
				if(does)
					icon.getStyle().over = null ;
				else
					icon.getStyle().over = Utils_Interface.buildDrawingRegionTexture(roomType.getIconPathHover()) ;
			}
		} ;
		
		
		icon.setSize(Overlay_ConstructionChoice.iconSizeX, Overlay_ConstructionChoice.iconSizeY);
		
		icon.getStyle().over = Utils_Interface.buildDrawingRegionTexture(roomType.getIconPathHover()) ;
		icon.setTransform(false);
		
		moveBy = (icon.getWidth() * scalingBy)/30 ;
		
		icon.addListener(new InputListener()
		{
			@Override
	        public boolean touchDown (InputEvent event, float x, float y, int pointer, int button) 
	        {
				if(!icon.isDisabled())
				{
					GVars_Inputs.blockActionForClick = true ; 
					icon.addAction(Actions.scaleTo(scalingBy, scalingBy, scaleSpeed));
					icon.addAction(Actions.moveBy(moveBy,moveBy,scaleSpeed));

				}
				
				return true;
	        }

			@Override
	        public void touchUp (InputEvent event, float x, float y, int pointer, int button) 
	        {
				if(!icon.isDisabled())
				{
					icon.addAction(Actions.scaleTo(1,1,scaleSpeed));
					icon.addAction(Actions.moveBy(-moveBy,-moveBy,scaleSpeed));
			         
					if(selected)
					{
						Utils_View.removeCurrentOverlay() ;
						Utils_View.setFilter(new Filter_CanBuildLock(resultingRoom)) ; 
						GVars_Interface.interaction.turnIntoDeselection();
					}
					else 
					{
						maskAsSelected() ;
						Overlay_ConstructionChoice.currentInfo.selectConstruction(resultingRoom) ; 
					}
				}
			}
		});
	      
		
		this.addActor(icon);
	}
	
	
	
	public void maskAsSelected()
	{
		selected = true ;
		icon.getStyle().up = Utils_Interface.buildDrawingRegionTexture(resultingRoom.getIconPathHover()) ;
		Overlay_ConstructionChoice.unselect() ;
		Overlay_ConstructionChoice.currentSelected = this ;
	}

	public void maskAsDeselected()
	{
		selected = false ;
		icon.getStyle().up = Utils_Interface.buildDrawingRegionTexture(resultingRoom.getIconPath()) ;
	}
}
