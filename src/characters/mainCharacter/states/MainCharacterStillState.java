package characters.mainCharacter.states;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.StateBasedGame;

import characters.mainCharacter.MainCharacter;

public class MainCharacterStillState extends MainCharacterBaseState{
	private MainCharacter mainCharacter;

	public MainCharacterStillState(MainCharacter mainCharacter) {
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
		arg2.draw(mainCharacter.getHitbox());
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update(GameContainer arg0, StateBasedGame arg1, int arg2)
			throws SlickException {
		changeWeapon(arg0, mainCharacter);
		mainCharacter.getHitbox().setX(mainCharacter.getX()+(mainCharacter.getImage().getWidth()/6));
		mainCharacter.getHitbox().setY(mainCharacter.getY()+(mainCharacter.getImage().getHeight()-mainCharacter.getHitbox().getHeight()));
		recover(mainCharacter.getRecoverSpeed(), mainCharacter);
		shoot(arg0, mainCharacter);
		if(arg0.getInput().isKeyDown(Input.KEY_RIGHT)||
				arg0.getInput().isKeyDown(Input.KEY_LEFT)||
				arg0.getInput().isKeyDown(Input.KEY_UP)||
				arg0.getInput().isKeyDown(Input.KEY_DOWN)){
			mainCharacter.setState(new MainCharacterWalkingState(mainCharacter));
		}	
	}
	@Override
	public int getID() {
		return 0;
	}
}
