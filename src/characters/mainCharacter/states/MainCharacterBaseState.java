package characters.mainCharacter.states;

import main.Options;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.BasicGameState;

import characters.mainCharacter.MainCharacter;
import weapons.Handgun;
import weapons.Shotgun;

public abstract class MainCharacterBaseState extends BasicGameState{

	public void changeWeapon(GameContainer arg0, MainCharacter mainCharacter) throws SlickException{
		if(arg0.getInput().isKeyDown(Input.KEY_1)){
			if(arg0.getInput().isKeyPressed(Input.KEY_1)){
				MainCharacter.setWeapon(new Handgun());
			}
		}
		if(arg0.getInput().isKeyDown(Input.KEY_2)){
			if(arg0.getInput().isKeyPressed(Input.KEY_2)){
				MainCharacter.setWeapon(new Shotgun());
			}
		}
	}
	public void characterMove(GameContainer arg0, int speed, MainCharacter mainCharacter){
		
		mainCharacter.getHitbox().setX(mainCharacter.getX()+(mainCharacter.getImage().getWidth()/6));
		mainCharacter.getHitbox().setY(mainCharacter.getY()+(mainCharacter.getImage().getHeight()-mainCharacter.getHitbox().getHeight()));
		if(arg0.getInput().isKeyDown(Input.KEY_RIGHT)){
			mainCharacter.setX(mainCharacter.getX()+speed);
			mainCharacter.setDirection(true);
		}
		if(arg0.getInput().isKeyDown(Input.KEY_LEFT)){
			mainCharacter.setX(mainCharacter.getX()-speed);
			mainCharacter.setDirection(false);
		}
		if(arg0.getInput().isKeyDown(Input.KEY_UP)){
			if(mainCharacter.getY()>main.Options.HEIGHT-Options.MOVEMENTPLACE){
				mainCharacter.setY(mainCharacter.getY()-speed);
			}
		}
		if(arg0.getInput().isKeyDown(Input.KEY_DOWN)){
			if(mainCharacter.getY()<main.Options.HEIGHT-mainCharacter.getImage().getHeight()){
				mainCharacter.setY(mainCharacter.getY()+speed);
			}	
		}
		if(!arg0.getInput().isKeyDown(Input.KEY_LEFT) 
				&& !arg0.getInput().isKeyDown(Input.KEY_RIGHT)
				&& !arg0.getInput().isKeyDown(Input.KEY_UP)
				&& !arg0.getInput().isKeyDown(Input.KEY_DOWN)){
			mainCharacter.setState(new MainCharacterStillState(mainCharacter));
		}
	}
	public void recover(double recoverSpeed, MainCharacter mainCharacter){
		if(mainCharacter.getStamina()<mainCharacter.getMaxStamina())
		mainCharacter.setStamina(mainCharacter.getStamina()+recoverSpeed);
	}
	public void shoot(GameContainer arg0, MainCharacter mainCharacter){
		if(arg0.getInput().isKeyPressed(Input.KEY_X)){
			if(arg0.getInput().isKeyDown(Input.KEY_X)){
				mainCharacter.setState(new MainCharacterShootingState(mainCharacter));
			}
		}
	}
}
