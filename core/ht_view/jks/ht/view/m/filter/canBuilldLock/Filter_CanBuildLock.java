package jks.ht.view.m.filter.canBuilldLock;

import static jks.ht.Vars.GVars_Heart.save;
import static jks.ht.building.Vars.FVars_Building.lockRefX;
import static jks.ht.building.Vars.FVars_Building.lockRefY;
import static jks.ht.building.Vars.FVars_Building.roomSizeX;
import static jks.ht.building.Vars.FVars_Building.roomSizeY;
import static jks.ht.index.imageBank.Index_Color.maxGreen;
import static jks.ht.index.imageBank.Index_Color.maxYellow;
import static jks.ht.index.imageBank.Index_Color.minYellow;
import static jks.ht.index.imageBank.Index_Color.transGreen;
import static jks.ht.index.imageBank.Index_PulsingType.show_draw_Close_Bonus;
import static jks.ht.index.imageBank.Index_PulsingType.show_draw_Close_CanBuild;
import static jks.tools2D.camera.GVars_Camera.render_ShapeFill;
import static jks.tools2D.camera.GVars_Camera.render_ShapeLine;

import com.badlogic.gdx.graphics.glutils.ShapeRenderer.ShapeType;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.utils.Array;

import jks.ht.building.Vars.FVars_Building;
import jks.ht.building.Vars.Utils_Building;
import jks.ht.building.buildResults.Model_Results;
import jks.ht.building.enums.Enum_CanBuildState;
import jks.ht.building.room.ARoom_Model;
import jks.ht.doc.enums.Enum_Spec_Room;
import jks.ht.interface2D.overlay.Overlay_BuildInfo;
import jks.ht.interface2D.overlay.constructionChoice.Overlay_ConstructionChoice;
import jks.ht.tools.Utils.Utils_Interface;
import jks.ht.tools.model.Vector2Int;
import jks.ht.view.m.filter.AView_Model_Filter;
import jks.tools.visual.NearBuildInfo_Fusion;
import jks.tools.visual.NearBuildInfo_Model;
import jks.tools2D.camera.GVars_Camera;
import jks.tools2D.view.utils.Utils_View;



public class Filter_CanBuildLock extends AView_Model_Filter
{

	CanBuildLockList canBuild ;
	
	Enum_CanBuildState lastSelect_State ; 
	Enum_CanBuildState bufferSelectState ; 
	
	Array<Enum_CanBuildState> affectedStates ; 
	
	Vector2Int bufferSelect_Pos;
	Vector2Int lastSelect_Pos ; 
	
	Model_Results clickResult ; 
	Enum_Spec_Room currentType ; 
	
	Array<Image> imageToDraw ; 
	
	ARoom_Model wantFuseWith;
	
	public Filter_CanBuildLock(Enum_Spec_Room type)
	{
		currentType = type ; 
		canBuild = new CanBuildLockList(currentType) ;
		
	}
	
	@Override
	public void clickAction(Vector2Int pos) 
	{
		actOnClick(pos);
		setValuesBaseOnClick();
	}

	private void actOnClick(Vector2Int pos)
	{
		Enum_CanBuildState build = canBuild.getCanBuild(pos) ; 
		if(build != null)
		{
			clickResult = null ; 
			bufferSelectState = build ; 
			bufferSelect_Pos = pos; 
				
			if(bufferSelectState != null)
			{
				if(isLastClickSame())
					return ;  
				
				selectNewTile(pos);
			}
				
		}	
	}

	private void setValuesBaseOnClick()
	{
		if(clickResult != null)
		{
			canBuild = new CanBuildLockList(currentType) ;
			lastSelect_State = null ; 
			lastSelect_Pos = null ; 
			clickResult = null ;
		}
	}

	private void selectNewTile(Vector2Int pos)
	{
		wantFuseWith = null ; 
		lastSelect_State = bufferSelectState ;
		lastSelect_Pos = pos ; 
		
		switch (lastSelect_State) 
		{
			case canBuild:
			{
				canBuild.setAt(lastSelect_Pos,Enum_CanBuildState.willBuild) ;
				Utils_View.setOverlay(new Overlay_BuildInfo());
				break ;
			}
			case canBuildAndNearInfo :
			{
				canBuild.setAt(lastSelect_Pos,Enum_CanBuildState.willBuild) ; 
				Array<NearBuildInfo_Model> nearInfo = canBuild.refSide_list_NearInfo.get(lastSelect_Pos) ;
				// Checking for possible fusion
				for(NearBuildInfo_Model near : nearInfo)
				{
					if(near instanceof NearBuildInfo_Fusion)
					{
						wantFuseWith = save.getHiveMap().get(near.from.getFrom(lastSelect_Pos)) ; 
						for(Vector2Int position : ((NearBuildInfo_Fusion)near).wouldAddAt)
						{
							
						}
					}
				}
				
				break ;
			}
			case alreadyExist :
			case underground :
			default : 
			break ; 
		}
	}

	private boolean isLastClickSame()
	{
		if(lastSelect_Pos != null && lastSelect_State != null)
		{
			// Last click was on the same place and was for a build
			if(bufferSelect_Pos.equals(lastSelect_Pos) && bufferSelectState == Enum_CanBuildState.willBuild)
			{
				if(wantFuseWith != null) // cherche a faire une fusion
					clickResult = Utils_Building.buildFuse(bufferSelect_Pos,wantFuseWith);
				else 					 // Add a new room 
					clickResult = Utils_Building.buildNew(bufferSelect_Pos,currentType);
				
				return true ;
				
			}
			else
			{
				wantFuseWith = null ; 
				canBuild.setAt(lastSelect_Pos, lastSelect_State);
			}
		}
		
		return false ; 
	}
	
	@Override
	public void moveAction() 
	{}
	
	

	
	@Override
	public void draw() 
	{
		render_ShapeLine.begin(ShapeType.Line);
		
		int y = 0; 
		
		for(int x = 0 ; x < canBuild.whatCanBeBuild_Left.size ; x++)
		{
			y = 0 ;
			for(Enum_CanBuildState canBeBuild : canBuild.whatCanBeBuild_Left.get(x))
			{
				draw_info(canBeBuild,-x,y) ;
				y ++ ;
			}
		}
		
		render_ShapeLine.end();
	}

	@Override
	public void update(float delta)
	{
		show_draw_Close_CanBuild.nextCycle(delta);
		show_draw_Close_Bonus.nextCycle(delta);
	}
	
	private void draw_info(Enum_CanBuildState canBeBuild,int x, int y)
	{
		switch(canBeBuild)
		{
			case canBuild : 
			{
				switch(GVars_Camera.currentDistance)
				{
					case CLOSE :
					{draw_Close_CanBuild(x,y) ; break ;}
					case FAR :
					case VERY_FAR :
					{draw_Far_CanBuild(x, y); break ;}
					default :
						System.out.println("Can't find type");
				}
				
				break ; 
			}
			case canBuildAndNearInfo :
			{
				
				switch(GVars_Camera.currentDistance)
				{
					case CLOSE :
					case FAR :
					case VERY_FAR :
					{
						draw_Close_CanBuildAndBonus(x, y); break ;
					}
					default :
						System.out.println("Can't find type");
				}
				
				break ;
			}
			case couldBuild :
			{
				switch(GVars_Camera.currentDistance)
				{
					case CLOSE :
					case FAR :
					case VERY_FAR :
					{draw_Close_CouldBuild(x, y); break ;}
					default :
						System.out.println("Can't find type");
				}
				
				break ; 
			}
			case willBuild :
			{
				switch(GVars_Camera.currentDistance)
				{
					case CLOSE :
					case FAR :
					case VERY_FAR :
					{draw_Close_WillBuild(x, y); break ;}
					default :
						System.out.println("Can't find type");
				}
				
				break ; 
			}
			case underground :
			case alreadyExist :
			default :
			{break ;}
		}
	}
	
	private void draw_Close_CanBuild(int x,int y)
	{show_draw_Close_CanBuild.drawFor_Room(x,y,1,1) ;}
	
	private void draw_Far_CanBuild(int x,int y)
	{
		render_ShapeLine.setColor(maxGreen);
		drawFrom_Rectangle(0,x,y) ;
	}
	
	private void draw_Close_CouldBuild(int x, int y)
	{
		render_ShapeLine.setColor(maxYellow);
		drawFrom_Rectangle(0,x,y) ;
		render_ShapeLine.setColor(minYellow);
		drawFrom_Rectangle(5,x,y) ;
	}
	
	private void draw_Close_CanBuildAndBonus(int x, int y)
	{
		show_draw_Close_Bonus.drawFor_Room(x, y, 1, 1);
		
	}
	
	
	
	private void draw_Close_WillBuild(int x, int y)
	{
		render_ShapeLine.setColor(transGreen);
		drawFrom_LineInRectangle(0,x,y) ;
	}
	
	
	private void drawFrom_LineInRectangle(int number,int x, int y)
	{
		render_ShapeLine.line(
					lockRefX + (x * roomSizeX), 
					lockRefY + (y * roomSizeY), 
					lockRefX + (x * roomSizeX) + roomSizeX, 
					lockRefY + (y * roomSizeY) + roomSizeY);
	}
	
	private void draw_NearInfo()
	{
		
	}
	
	private void drawFrom_Rectangle(float decal,int x,int y)
	{render_ShapeLine.rect(lockRefX + (x * roomSizeX) + decal + 1, lockRefY + (y * roomSizeY) + decal + 1, FVars_Building.roomSizeX - decal - 1, FVars_Building.roomSizeY - (decal + 1) * 2);}

	@Override
	public boolean disableMainClickAction() 
	{return true;}

}
