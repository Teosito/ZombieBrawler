package main;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;

import characters.Characters;


public class Camera extends BasicGameState{
	
	private float x;
	private float y;
	private int minLevel;
	private int maxLevel;
	private Characters character;
	
	public Camera(Characters character,int minLevel,int maxLevel){
		this.character = character;
		this.minLevel = minLevel;
		this.maxLevel = maxLevel;
		
	}

	@Override
	public void init(GameContainer arg0, StateBasedGame arg1)
			throws SlickException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void render(GameContainer arg0, StateBasedGame arg1, Graphics arg2)
			throws SlickException {
		arg2.translate(-x, -y);
		
	}

	@Override
	public void update(GameContainer arg0, StateBasedGame arg1, int arg2)
			throws SlickException {
		x=character.getX()-Options.WIDTH/2;
		if(x<minLevel){
			x=0;
			}
		if(x+Options.WIDTH>maxLevel){
			x=maxLevel-Options.WIDTH;
		}
		}

	@Override
	public int getID() {
		// TODO Auto-generated method stub
		return 0;
	}
	public float getX(){
		return x;
	}
}
