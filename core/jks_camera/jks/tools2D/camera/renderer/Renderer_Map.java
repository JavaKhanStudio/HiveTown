package jks.tools2D.camera.renderer;

import java.util.HashMap;

import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.maps.tiled.renderers.OrthoCachedTiledMapRenderer;

import jks.tools2D.camera.Enum_LayoutType;

public class Renderer_Map extends OrthoCachedTiledMapRenderer
{
	private HashMap<Enum_LayoutType,int[]> layout ; 

	public Renderer_Map(TiledMap map,HashMap<Enum_LayoutType,int[]> Layout)
	{
		super(map, 1, 5000) ; 
		this.setBlending(true);
		this.setMaxTileSize(512, 512);
		layout = Layout; 
	}
	
	public void render(Enum_LayoutType typeToRender)
	{this.render(layout.get(typeToRender));}
	
	public static Renderer_Map mock(TiledMap map)
	{
		HashMap<Enum_LayoutType,int[]> layout = new HashMap<Enum_LayoutType,int[]>() ; 
		layout.put(Enum_LayoutType.BACKGROUND, new int[] {0,1,2}) ; 
		return new Renderer_Map(map,layout) ; 
	}
}
