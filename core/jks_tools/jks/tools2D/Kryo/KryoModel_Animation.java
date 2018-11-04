//package jks.tools2D.Kryo;
//
//import com.badlogic.gdx.graphics.g2d.Animation;
//import com.badlogic.gdx.graphics.g2d.TextureRegion;
//import com.esotericsoftware.kryo.Kryo;
//import com.esotericsoftware.kryo.Serializer;
//import com.esotericsoftware.kryo.io.Input;
//import com.esotericsoftware.kryo.io.Output;
//
//public class KryoModel_Animation extends Serializer<Animation<TextureRegion>>
//{
//
//	private Class genericType;
//	
//	@Override
//	public void write(Kryo kryo, Output output, Animation<TextureRegion> array)
//	{
//		int length = array.getKeyFrames().length;
//		output.writeInt(length, true);
//		
//		if (length == 0) 
//		{
//			genericType = null;
//			return;
//		}
//		
//		if (genericType != null) 
//		{
//			Serializer serializer = kryo.getSerializer(genericType);
//			genericType = null;
//			
//			for (TextureRegion element : array.getKeyFrames())
//				kryo.writeObjectOrNull(output, element, serializer);
//		} 
//		else 
//		{
//			for (TextureRegion element : array.getKeyFrames())
//				kryo.writeClassAndObject(output, element);
//		}	
//	}
//
//	@Override
//	public Animation<TextureRegion> read(Kryo kryo, Input input, Class<Animation<TextureRegion>> type)
//	{
//		
//		return null;
//	}
//	
//
//}
//
//
