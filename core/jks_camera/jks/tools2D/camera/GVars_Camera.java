package jks.tools2D.camera;

import static jks.tools2D.camera.Fvars_Camera.cameraHeight;
import static jks.tools2D.camera.Fvars_Camera.cameraMaxWidth;
import static jks.tools2D.camera.Fvars_Camera.cameraMinWidth;
import static jks.tools2D.camera.Fvars_Camera.cameraWidth;
import static jks.tools2D.camera.Fvars_Camera.isConsider_Far_Value;
import static jks.tools2D.camera.Fvars_Camera.startZoom;
import static jks.tools2D.camera.Fvars_Camera.zoomPower;

import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShaderProgram;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.utils.viewport.ExtendViewport;
import com.esotericsoftware.spine.SkeletonRenderer;

import jks.ht.Vars.GVars_Heart;
import jks.ht.view.enums.Enum_ViewDistance;
import jks.tools2D.camera.renderer.Renderer_Map;

public class GVars_Camera 
{
	public static OrthographicCamera camera;
	
	public static ShapeRenderer render_ShapeLine;
	public static ShapeRenderer render_ShapeFill;
	
	public static ShapeRenderer render_ScreenFill;
	public static Renderer_Map  render_Map ; 
	public static SpriteBatch batch; 
	

	public static Vector2 cameraVelocity = new Vector2();
	public static float zoomSpeed = 0;
	public static float currentminHeightY ; 
	
	public static Enum_ViewDistance currentDistance = Enum_ViewDistance.CLOSE;
	public static ShaderProgram shaderProgram;
	
	private static SkeletonRenderer skeletonRenderer;
	
	public static void init()
	{
		//shaderProgram = new ShaderProgram() ;
		GVars_Camera.batch = new SpriteBatch();
		camera = new OrthographicCamera();
		camera.zoom = startZoom ; 
		camera.position.add(350,Fvars_Camera.minHeightY * (camera.zoom/zoomPower),0) ;
		GVars_Heart.viewport = new ExtendViewport(cameraMinWidth, cameraHeight, cameraMaxWidth, cameraWidth, camera);
		
		render_ShapeLine = new ShapeRenderer() ;
		render_ShapeFill = new ShapeRenderer() ;
		render_ScreenFill = new ShapeRenderer() ;
		
		skeletonRenderer = new SkeletonRenderer();
		skeletonRenderer.setPremultipliedAlpha(true);
	
		
	}
	
	public static void initMapVisual(TiledMap map)
	{render_Map = Renderer_Map.mock(map) ;}
	
	public static void updateCamera (float delta) 
	{
		currentminHeightY = Fvars_Camera.minHeightY * (camera.zoom/30) ;
		
		if(camera.position.y + (cameraVelocity.y * delta) < currentminHeightY)
		{
			cameraVelocity.y = (currentminHeightY - camera.position.y) ;
			camera.position.add(cameraVelocity.x * delta, cameraVelocity.y, 0);
		}
		else
		{
			camera.position.add(cameraVelocity.x * delta, cameraVelocity.y * delta, 0);
		}
	
		calculateVelocity(delta) ;
		calculateZoom(delta) ;
		camera.update();
		
		batch.setProjectionMatrix(camera.combined);
		render_ShapeLine.setProjectionMatrix(camera.combined);
		render_ShapeFill.setProjectionMatrix(camera.combined);
		//do not setProjectionMatrix on the render_ScreenFill
		render_Map.setView(camera);
	}
	
	private static void calculateVelocity(float delta)
	{
		
		if(cameraVelocity.x != 0)
		{
			desceX = descelerationSpeed * delta ;
			
			if(Math.abs(cameraVelocity.x) - desceX < 0)
			{cameraVelocity.x = 0 ;}
			else
			{
				if(cameraVelocity.x > 0)
				{cameraVelocity.x -= desceX ;}
				else
				{cameraVelocity.x += desceX ;}
			}
		}
		
		if(cameraVelocity.y != 0)
		{
			desceY = descelerationSpeed * delta ;
			if(Math.abs(cameraVelocity.y) - desceY < 0)
			{cameraVelocity.y = 0 ;}
			else
			{
				if(cameraVelocity.y > 0)
				{cameraVelocity.y -= desceY ;}
				else
				{cameraVelocity.y += desceY ;}
			}
		}
	}
	
	private static void calculateZoom(float delta)
	{
		camera.position.add(cameraVelocity.x * delta, cameraVelocity.y * delta, 0);
		camera.zoom += zoomSpeed ; 
		if(camera.zoom < isConsider_Far_Value)
		{currentDistance = Enum_ViewDistance.CLOSE ;}
		else
		{currentDistance = Enum_ViewDistance.FAR ;}
			
		zoomSpeed = 0 ; 
	}
	
	private static float desceX ; 
	private static float desceY ; 
	private static float descelerationSpeed = 180 ;
	
	public static OrthographicCamera getCamera()
	{return camera;}

	public static void setCamera(OrthographicCamera camera)
	{GVars_Camera.camera = camera;}
}
