package jks.ht.view.m.vue;

import static jks.ht.Vars.GVars_Heart.getHive ;
import static jks.tools2D.camera.GVars_Camera.*;

import java.util.ArrayList;

import com.badlogic.gdx.Application;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputMultiplexer;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer.ShapeType;
import com.badlogic.gdx.input.GestureDetector;
import com.badlogic.gdx.utils.Array;

import jks.ht.Vars.GVars_Heart;
import jks.ht.building.room.ARoom_Model;
import jks.ht.building.room.Room_Dummy;
import jks.ht.gamelogic.drones.DroneGroup;
import jks.ht.index.imageBank.Index_Speaker;
import jks.ht.index.imageBank.Index_Spire;
import jks.ht.index.imageBank.Index_Sprite;
import jks.ht.interface2D.GVars_Interface;
import jks.ht.interface2D.dialogue.DialogueBox;
import jks.ht.interface2D.hiveView.Page_HiveView;
import jks.ht.models.ToRender;
import jks.ht.tools.Utils.Utils_Debugg;
import jks.ht.tools.model.Vector2Int;
import jks.ht.tutorial.index.Tuto_Test2;
import jks.ht.tutorial.model.Tutorial;
import jks.ht.view.background.Utils_Pollution;
import jks.tools2D.camera.Enum_LayoutType;
import jks.tools2D.camera.GVars_Camera;
import jks.tools2D.camera.renderer.Renderer_Map;
import jks.tools2D.inputs.Manager_Input_Click;
import jks.tools2D.inputs.Manager_Input_Gesture;
import jks.tools2D.inputs.Manager_Input_Keys;
import jks.tools2D.inputs.Utils_Input;

public class Vue_Game extends AVue_Model
{

	public ArrayList<DroneGroup> droneGroup ;
	
	ArrayList<ArrayList<Vector2Int>> position_Left ; 
	ArrayList<ArrayList<Vector2Int>> position_Right ;
	
	
	public static Array<ARoom_Model> drawinglist_room = new Array<ARoom_Model>() ;
	public boolean isOnTutorialMode ; 
	
	public Vue_Game() {} 
	public Vue_Game(boolean istutorial) {isOnTutorialMode = istutorial;} 
	
	public Page_HiveView hiveView ; 
	
	
	@Override
	public void init() 
	{
		toRender = new ArrayList<ToRender>() ;
		
		//Inits
		Index_Sprite.init() ;
		GVars_Interface.reset();
		
		GVars_Heart.initMap(GVars_Heart.mapName);
		
		Gdx.input.setInputProcessor
		(
			new InputMultiplexer
			(
				new Manager_Input_Click(),
				GVars_Interface.mainInterface,
				new Manager_Input_Keys(), 
				new GestureDetector(new Manager_Input_Gesture())
			)
		);

			
		GVars_Camera.cameraVelocity.x = 0 ; GVars_Camera.cameraVelocity.y = 0 ;
		
		//Variable declaration
		droneGroup = new ArrayList<DroneGroup>() ;
		skeletonRenderer.setPremultipliedAlpha(true);
		
		// ADD MAIN INFRA
		for(ARoom_Model room : getHive().getHiveMap().values())
		{room.initShow();}

		hiveView = new Page_HiveView() ; 
		
		if(GVars_Heart.debbug)
		{Utils_Debugg.setAtDebugg();}
		
		if(isOnTutorialMode)
		{
			setTutorial(new Tuto_Test2(this)) ;
			nextTutorialStep();
		}
		
		//DialogueBox dialogue = new DialogueBox("Bonjour, mon nom est Sweet Marie, ceci est mon test, et j'aimerai le voir faire marché!", Index_Speaker.sweetMarie) ; 
		//GVars_Interface.mainInterface.addActor(dialogue);
	}
	
	
	public void initPosition()
	{
		position_Left = new ArrayList<ArrayList<Vector2Int>>() ;
	}
	
	@Override
	public void update(float delta) 
	{
		Utils_Input.updateInput(delta);
		updateCamera(delta);
		
		for(DroneGroup group : droneGroup)
		{group.runGroupActivity();}
		
		for(DroneGroup group : droneGroup)
		{group.update(delta);}
		
		if(filter != null)
		{filter.update(delta);}
	}

	public void drawModel()
	{
		for(DroneGroup group : droneGroup)
		{group.draw(GVars_Camera.batch) ;}
	}
	
	
	@Override
	public void render(float delta) 
	{
		clear() ;
		
		drawBackground() ;
		drawRooms() ; 
		drawModel() ;
		renderBeforeInterface() ;
		drawInterface(delta) ;	
	}
	
	
	
	public void drawRooms()
	{
		batch.begin();
		render_ShapeLine.begin(ShapeType.Line);
		
		for(ARoom_Model room : drawinglist_room)
		{room.draw();}
		
		batch.end();
		render_ShapeLine.end();
	}
	
	
	public void drawBackground()
	{
		Utils_Pollution.buildColors();
		render_Map.render(Enum_LayoutType.BACKGROUND);
	}
	
	public void moveDrones()
	{
		
	}
	
	@Override
	public void destroy() 
	{}

	@Override
	public void restart()
	{}
	
	
	
	public void mockingBuilding()
	{
		for(Array<Vector2Int> position : GVars_Heart.positionPool.getPos_Left())
		{
			for(Vector2Int pos : position)
			{
				drawinglist_room.add(new Room_Dummy(pos.x, pos.y, 1, 1)) ;
			}
		}
	}
	
	public Page_HiveView getInterface()
	{return hiveView ;}
	
	public void setAsTutorial()
	{
		hiveView.interactionSection.setAsTutorial(); 
		hiveView.ressourceSection.setAsTutorial();
	}
}