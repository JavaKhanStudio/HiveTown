package jks.test;

import java.util.HashMap;
import java.util.Map;

import com.badlogic.gdx.ApplicationListener;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class InputDemo2 implements ApplicationListener, InputProcessor 
{
    private SpriteBatch batch;
    private String message = "Touch something already!";
    private int w,h;
    
    class TouchInfo 
    {
        public float touchX = 0;
        public float touchY = 0;
        public boolean touched = false;
    }
    
    private Map<Integer,TouchInfo> touches = new HashMap<Integer,TouchInfo>();
    
    @Override
    public void create() 
    {        
        batch = new SpriteBatch();    
       
        w = Gdx.graphics.getWidth();
        h = Gdx.graphics.getHeight();
        Gdx.input.setInputProcessor(this);
        for(int i = 0; i < 5; i++){
            touches.put(i, new TouchInfo());
        }
    }

    @Override
    public void dispose() {
        batch.dispose();
    }

    @Override
    public void render() {        
        Gdx.gl.glClearColor(1, 1, 1, 1);
        
        batch.begin();
        
        message = "";
        for(int i = 0; i < 5; i++){
            if(touches.get(i).touched)
                message += "Finger:" + Integer.toString(i) + "touch at:" +
                        Float.toString(touches.get(i).touchX) +
                        "," +
                        Float.toString(touches.get(i).touchY) +
                        "\n";
                                
        }
        
        
        batch.end();
    }

    @Override
    public void resize(int width, int height) {
    }

    @Override
    public void pause() {
    }

    @Override
    public void resume() {
    }

    @Override
    public boolean keyDown(int keycode) {
      
        return false;
    }

    @Override
    public boolean keyUp(int keycode) {
    	
        return false;
    }

    @Override
    public boolean keyTyped(char character) {
    	
        return false;
    }

    @Override
    public boolean touchDown(int screenX, int screenY, int pointer, int button) {
    	System.out.println("test2");
    	if(pointer < 5){
            touches.get(pointer).touchX = screenX;
            touches.get(pointer).touchY = screenY;
            touches.get(pointer).touched = true;
        }
        return true;
    }

    @Override
    public boolean touchUp(int screenX, int screenY, int pointer, int button) {
    	System.out.println("test2");
    	if(pointer < 5){
            touches.get(pointer).touchX = 0;
            touches.get(pointer).touchY = 0;
            touches.get(pointer).touched = false;
        }
        return true;
    }

    @Override
    public boolean touchDragged(int screenX, int screenY, int pointer) {
    	System.out.println("test2");
        return false;
    }

    @Override
    public boolean mouseMoved(int screenX, int screenY) {
    	System.out.println("move");
        return false;
    }

    @Override
    public boolean scrolled(int amount) {
        // TODO Auto-generated method stub
        return false;
    }
}