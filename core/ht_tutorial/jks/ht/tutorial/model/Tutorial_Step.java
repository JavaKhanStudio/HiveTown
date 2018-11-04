package jks.ht.tutorial.model;

public abstract interface Tutorial_Step 
{

	public void init() ;
	public void read() ;
	public boolean checkIfGood() ; 
	public void draw(float delta) ;
}
