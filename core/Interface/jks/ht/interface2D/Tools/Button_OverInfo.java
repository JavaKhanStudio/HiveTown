package jks.ht.interface2D.Tools;

import java.util.ArrayList;

import org.apache.commons.collections4.CollectionUtils;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.InputListener;
import com.badlogic.gdx.scenes.scene2d.ui.ImageButton;
import com.badlogic.gdx.scenes.scene2d.utils.ChangeListener.ChangeEvent;
import com.badlogic.gdx.scenes.scene2d.utils.Drawable;
import com.badlogic.gdx.scenes.scene2d.utils.FocusListener;

public class Button_OverInfo extends ImageButton
{

	public Button_OverInfo(Drawable imageUp,ArrayList<String> desactivationReasons) 
	{
		super(imageUp);
		
		if(CollectionUtils.isNotEmpty(desactivationReasons))
		{
			this.setColor(Color.GRAY);
			
			switch(Gdx.app.getType()) 
			{
			   case Android:
			   {
				   this.addListener(new InputListener()
					{
						@Override
				        public boolean touchDown (InputEvent event, float x, float y, int pointer, int button) 
				        {
							return false ; 
				        }

						@Override
				        public void touchUp (InputEvent event, float x, float y, int pointer, int button) 
				        {
							
				        }
					});
				   
				   break ;
			   }
			   case Desktop:
			   {
				   System.out.println("theire is problems");
				   //this.setDisabled(true);
				   this.addListener(new FocusListener() 
				   {
//					  // @Override
//					    public boolean handle() 
//						{
//							System.out.println("Over me");
//						}
				   });
				   
				   this.addListener(new InputListener()
				   {
						@Override
				        public boolean touchDown (InputEvent event, float x, float y, int pointer, int button) 
				        {
							System.out.println("Test");
							return false ; 
				        }

						@Override
				        public void touchUp (InputEvent event, float x, float y, int pointer, int button) 
				        {
							
				        }
					});
				   break ;
			   }  
			}
		}
		
		

		
	}

}
