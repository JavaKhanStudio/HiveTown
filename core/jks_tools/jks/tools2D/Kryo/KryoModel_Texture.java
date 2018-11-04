//package jks.tools2D.Kryo;
//
//import com.badlogic.gdx.graphics.Texture;
//import com.badlogic.gdx.graphics.TextureData;
//import com.esotericsoftware.kryo.Kryo;
//import com.esotericsoftware.kryo.Serializer;
//import com.esotericsoftware.kryo.io.Input;
//import com.esotericsoftware.kryo.io.Output;
//
//public class KryoModel_Texture extends Serializer<Texture>
//{
//	@Override
//	public void write(Kryo kryo, Output output, Texture object)
//	{
//		Serializer<TextureData> serializer = kryo.getSerializer(TextureData.class);
//		kryo.writeObjectOrNull(output, object.getTextureData(), serializer);
//	}
//
//	@Override
//	public Texture read(Kryo kryo, Input input, Class<Texture> type)
//	{
//		
//		return null;
//	}
//
//}
