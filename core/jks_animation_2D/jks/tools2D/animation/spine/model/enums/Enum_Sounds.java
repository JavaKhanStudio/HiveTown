package jks.tools2D.animation.spine.model.enums;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Sound;

public enum Enum_Sounds 
{
	shoot("sounds/shoot.ogg"), 
	hit("sounds/footstep1.ogg"), 
	footstep1("sounds/footstep1.ogg"), 
	footstep2("sounds/footstep2.ogg"), 
	squish("sounds/squish.ogg"), 
	hurtPlayer("sounds/hurt-player.ogg"), 
	hurtAlien("sounds/hurt-alien.ogg");


	Enum_Sounds(String path)
	{
		sound = Gdx.audio.newSound(Gdx.files.internal(path));
	}
	
	public Sound sound;
	public float volume = 1;

	public void play () 
	{sound.play(volume);}
}
