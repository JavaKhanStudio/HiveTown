package jks.tools2D.camera.renderer;

import com.esotericsoftware.spine.SkeletonRenderer;

public class Singleton_Renderer_Spine
{
	private static SkeletonRenderer skeletonRenderer;
	
	public static SkeletonRenderer getSkeletonRenderer()
	{return skeletonRenderer;}
	
	public static void initSkeletonRenderer()
	{		
		skeletonRenderer = new SkeletonRenderer();
		skeletonRenderer.setPremultipliedAlpha(true);
	}

	
}
