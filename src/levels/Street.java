package levels;

import items.background.Building;
import main.Camera;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.StateBasedGame;

import characters.mainCharacter.MainCharacter;

public class Street extends LevelBase{
	
	public Street()throws SlickException {
		numberOfBuildings = 2;
		ID = 1000;
		mainCharacter = new MainCharacter();
		//enemies.add(new FirstEnemyMelee());
	}

	@Override
	public void init(GameContainer arg0, StateBasedGame arg1)
			throws SlickException {
		createBuildings(numberOfBuildings, arg1, ID);
		getCharactersRender();
		camera = new Camera(mainCharacter, 0, numberOfBuildings*Building.getScale());
		enemyFollow(mainCharacter);
		bulletHittable();
	}

	@Override
	public void render(GameContainer arg0, StateBasedGame arg1, Graphics arg2)
			throws SlickException {
		camera.render(arg0, arg1, arg2);
		renderAll(arg0, arg1, arg2);
	}

	@Override
	public void update(GameContainer arg0, StateBasedGame arg1, int arg2)
			throws SlickException {
		getID();
		camera.update(arg0, arg1, arg2);
		rearrangeRenderArray();
		updateMainCharacter(arg0, arg1, arg2);
		updateEnemy(arg0, arg1, arg2);
		updateBullets(arg0, arg1, arg2);
		for(int i = 0; i<buildings.size();i++){
		enterLevel(mainCharacter, buildings.get(i), arg0, arg1);
		}
	}

	@Override
	public int getID() {
		return ID;
	}
	

}
