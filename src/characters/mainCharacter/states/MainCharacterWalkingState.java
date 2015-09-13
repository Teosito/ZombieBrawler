package characters.mainCharacter.states;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.StateBasedGame;

import characters.mainCharacter.MainCharacter;


public class MainCharacterWalkingState extends MainCharacterBaseState{
	
	private MainCharacter mainCharacter;
	public MainCharacterWalkingState(MainCharacter mainCharacter) {
		this.mainCharacter = mainCharacter;
		mainCharacter.setShoot(false);
	}

	@Override
	public void init(GameContainer arg0, StateBasedGame arg1)
			throws SlickException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void render(GameContainer arg0, StateBasedGame arg1, Graphics arg2)
			throws SlickException {
		mainCharacter.getImage().draw(mainCharacter.getX(), mainCharacter.getY());
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update(GameContainer arg0, StateBasedGame arg1, int arg2)
			throws SlickException {
		changeWeapon(arg0, mainCharacter);
		recover(mainCharacter.getRecoverSpeed(), mainCharacter);
		shoot(arg0, mainCharacter);
		int speed = mainCharacter.getSpeedX();
		characterMove(arg0, speed, mainCharacter);
		if(arg0.getInput().isKeyDown(Input.KEY_Z)){
			if(mainCharacter.getStamina()>=10){
			mainCharacter.setState(new MainCharacterRunningState(mainCharacter));
			}
		}
	}
	@Override
	public int getID() {
		// TODO Auto-generated method stub
		return 0;
	}

}
