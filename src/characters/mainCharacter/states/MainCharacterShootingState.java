package characters.mainCharacter.states;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.StateBasedGame;

import characters.mainCharacter.MainCharacter;

public class MainCharacterShootingState extends MainCharacterBaseState{
	private MainCharacter mainCharacter;
	private int recoilTime;

	public MainCharacterShootingState(MainCharacter mainCharacter) {
		this.mainCharacter = mainCharacter;
		recoilTime = MainCharacter.getWeapon().getShootingTime();
		mainCharacter.setShoot(true);
	}
	@Override
	public void init(GameContainer arg0, StateBasedGame arg1)
			throws SlickException {		
	}

	@Override
	public void render(GameContainer arg0, StateBasedGame arg1, Graphics arg2)
			throws SlickException {
		mainCharacter.getImage().draw(mainCharacter.getX(), mainCharacter.getY());
	}

	@Override
	public void update(GameContainer arg0, StateBasedGame arg1, int arg2)
			throws SlickException {

		mainCharacter.setShoot(false);
		if(recoilTime>=0){
			recoilTime--;
		}else{
			mainCharacter.setState(new MainCharacterStillState(mainCharacter));
		}		
	}
	@Override
	public int getID() {
		// TODO Auto-generated method stub
		return 0;
	}

}
