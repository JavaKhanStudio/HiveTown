//package jks.ht.main;
//
//import java.io.FileInputStream;
//import java.io.FileNotFoundException;
//
//import com.badlogic.gdx.ApplicationListener;
//import com.badlogic.gdx.Gdx;
//import com.badlogic.gdx.graphics.GL20;
//import com.badlogic.gdx.graphics.g2d.Animation;
//import com.badlogic.gdx.graphics.g2d.SpriteBatch;
//import com.badlogic.gdx.graphics.g2d.TextureRegion;
//import com.esotericsoftware.kryo.Kryo;
//import com.esotericsoftware.kryo.io.Input;
//
//import jks.tools2D.Kryo.KryoModel_Animation;
//import jks.tools2D.animation.gif.GifModel;
//import jks.tools2D.tools.GifDecoder;
//import jks.tools2D.tools.TransformToKryo;
//
//public class EmptyGame implements ApplicationListener 
//{
//
//	 private SpriteBatch batch;
//	 GifModel model ;
//	
//	@Override
//	public void create()
//	{
//		 batch = new SpriteBatch();   
//			GifDecoder.saveGifTextureAsTexture("test/giphy.gif", "Test");
////			TransformToKryo.convertGifToKryo("test/giphy.gif", "Test");
//			//model = new GifModel(loadAnimation()) ;
//
//	}
//
//	@Override
//	public void resize(int width, int height)
//	{}
//
//	@Override
//	public void render()
//	{
//		Gdx.gl.glClearColor(1, 1, 1, 1);
//        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
////        model.draw(batch);
////        try
////		{
////			//TransformToKryo.convertGifToKryo("test/giphy.gif", "Test");
////        	
////		} catch (FileNotFoundException e)
////		{
////			e.printStackTrace();
////		}
//        
//        batch.begin();
//        batch.end();
//        System.exit(1);
//	}
//	
//	public KryoModel_Animation loadAnimation() throws FileNotFoundException
//	{
////		 Input input = new Input(new FileInputStream("Test.kryogif"));
////		 Kryo kryo = new Kryo();
//		 KryoModel_Animation someObject = kryo.readObject(input,  KryoModel_Animation.class);
//		 input.close();
//		 return someObject ;
//	}
//
//	@Override
//	public void pause()
//	{}
//
//	@Override
//	public void resume()
//	{}
//
//	@Override
//	public void dispose()
//	{}
//
//}
