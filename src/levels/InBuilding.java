package levels;

import main.Camera;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.StateBasedGame;

import characters.enemies.FirstEnemyMelee;

public class InBuilding extends LevelBase{
	
	public InBuilding(int ID)throws SlickException {
	numberOfBuildings = 2;
	this.ID = ID;
	enemies.add(new FirstEnemyMelee());
	camera = new Camera(mainCharacter, 0, 10000);
	getCharactersRender();
	}
	@Override
	public void init(GameContainer arg0, StateBasedGame arg1)
			throws SlickException {
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
		camera.update(arg0, arg1, arg2);
		rearrangeRenderArray();
		updateMainCharacter(arg0, arg1, arg2);
		updateEnemy(arg0, arg1, arg2);
		updateBullets(arg0, arg1, arg2);
		exitLevel(arg0, arg1);
	}

	@Override
	public int getID() {
		return ID;
	}
}
