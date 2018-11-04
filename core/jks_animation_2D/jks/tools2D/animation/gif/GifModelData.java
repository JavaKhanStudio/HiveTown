package jks.tools2D.animation.gif;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

import jks.tools2D.tools.GifDecoder;

import com.badlogic.gdx.graphics.g2d.Animation.PlayMode;

public class GifModelData
{
	
	Animation<TextureRegion> gifBody ;
	
	public GifModelData(String url)
	{
		gifBody = GifDecoder.loadGIFAnimation(url) ;
	}
	
	public GifModelData(String url, int FRAME_COLS, int FRAME_ROWS,int nbFrame,float speed)
	{
		Texture walkSheet = new Texture(Gdx.files.internal(url));

		TextureRegion[][] tmp = TextureRegion.split(walkSheet, 
				walkSheet.getWidth()  / FRAME_COLS,
				walkSheet.getHeight() / FRAME_ROWS);

		// Place the regions into a 1D array in the correct order, starting from the top 
		// left, going across first. The Animation constructor requires a 1D array.
		TextureRegion[] walkFrames = new TextureRegion[nbFrame];
		int index = 0;
		for (int i = 0; i < FRAME_ROWS; i++)
		{
			for (int j = 0; j < FRAME_COLS; j++) 
			{
				walkFrames[index++] = tmp[i][j];
				
				if(index == nbFrame)
					break ;
			}
		}

		// Initialize the Animation with the frame interval and array of frames
		gifBody = new Animation<TextureRegion>(speed, walkFrames);
		gifBody.setPlayMode(PlayMode.LOOP);
	}

	public GifModelData(Animation animation) 
	{gifBody = animation ;}
	
}
