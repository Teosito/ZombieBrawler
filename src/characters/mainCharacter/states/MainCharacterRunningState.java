package characters.mainCharacter.states;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.StateBasedGame;

import characters.mainCharacter.MainCharacter;

public class MainCharacterRunningState extends MainCharacterBaseState{

	private MainCharacter mainCharacter;
	public MainCharacterRunningState(MainCharacter mainCharacter) {
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
		if(mainCharacter.getStamina()<=0){
			mainCharacter.setState(new MainCharacterWalkingState(mainCharacter));
		}
		characterMove(arg0, mainCharacter.getSpeedX()*2, mainCharacter);
		if(arg0.getInput().isKeyDown(Input.KEY_Z)==false){
			mainCharacter.setState(new MainCharacterWalkingState(mainCharacter));
		}
		mainCharacter.setStamina(mainCharacter.getStamina()-2);
		
	}

	@Override
	public int getID() {
		// TODO Auto-generated method stub
		return 0;
	}
	

}
