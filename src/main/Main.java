package main;


import levels.Street;

import org.newdawn.slick.AppGameContainer;
import org.newdawn.slick.Game;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.StateBasedGame;


public class Main extends StateBasedGame{
	public Main(String name) {
		super(name);
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) throws SlickException{
		AppGameContainer app = new AppGameContainer((Game) new Main(""));
		app.setDisplayMode(Options.WIDTH, Options.HEIGHT, false);
		app.setAlwaysRender(true);
		app.setShowFPS(true);
		app.setTargetFrameRate(60);
		app.setVSync(false);
		app.start();
		//currentScreen = new CurrentScreen();
		
	}

	@Override
	public void initStatesList(GameContainer arg0) throws SlickException {
		this.addState(new Street());
	}


}
