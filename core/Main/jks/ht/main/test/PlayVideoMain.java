package jks.ht.main.test;
//package jks.ht.main;
//
//
//
//import java.io.FileNotFoundException;
//
//import com.badlogic.gdx.ApplicationListener;
//import com.badlogic.gdx.Gdx;
//import com.badlogic.gdx.graphics.OrthographicCamera;
//import com.badlogic.gdx.utils.viewport.ExtendViewport;
//import com.badlogic.gdx.video.VideoPlayer;
//import com.badlogic.gdx.video.VideoPlayerCreator;
//
//import jks.tools2D.camera.Fvars_Camera;
//
//public class PlayVideoMain  implements ApplicationListener 
//{
//
//	public static OrthographicCamera camera;
//	public static ExtendViewport viewport;
//	static final float  cameraMinWidth = 16, cameraMaxWidth = 28, 
//	 		cameraHeight = 16, cameraWidth = 16 ;
//	
//	@Override
//	public void create()
//	{
//		
//		camera = new OrthographicCamera();
//		camera.zoom = 1 ; 
//		camera.position.add(350,Fvars_Camera.minHeightY * (camera.zoom/32),0) ;
//		viewport = new ExtendViewport(cameraMinWidth, cameraHeight, cameraMaxWidth, cameraWidth, camera);
//		
//		VideoPlayer play = VideoPlayerCreator.createVideoPlayer(viewport) ; 
//		
//		
//		try
//		{play.play(Gdx.files.internal("test/test.mp4")) ;} 
//		catch (FileNotFoundException e)
//		{e.printStackTrace();}
//	}
//
//	@Override
//	public void resize(int width, int height)
//	{
//		
//	}
//
//	@Override
//	public void render()
//	{
//		
//	}
//
//	@Override
//	public void pause()
//	{
//		
//	}
//
//	@Override
//	public void resume()
//	{
//		
//	}
//
//	@Override
//	public void dispose()
//	{
//		
//	}
//
//}
