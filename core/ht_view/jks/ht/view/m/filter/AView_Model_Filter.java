package jks.ht.view.m.filter;

import jks.ht.tools.model.Vector2Int;

public abstract class AView_Model_Filter 
{
	public abstract void draw() ;
	public abstract void update(float delta) ;
	public abstract void clickAction(Vector2Int pos) ;
	public abstract void moveAction() ;
	public abstract boolean disableMainClickAction() ; 
}
