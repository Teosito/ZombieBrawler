package characters.enemies.states;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.StateBasedGame;

import characters.enemies.EnemyBase;

public class EnemyStillState extends EnemyBaseState{
	private EnemyBase enemy;
	public EnemyStillState(EnemyBase enemy) {
		this.enemy = enemy;
		// TODO Auto-generated constructor stub
	}
	@Override
	public void init(GameContainer arg0, StateBasedGame arg1)
			throws SlickException {
		
	}

	@Override
	public void render(GameContainer arg0, StateBasedGame arg1, Graphics arg2)
			throws SlickException {
		enemy.getImage().draw(enemy.getX(), enemy.getY());
		arg2.draw(enemy.getHitbox());
	}

	@Override
	public void update(GameContainer arg0, StateBasedGame arg1, int arg2)
			throws SlickException {
		enemy.getHitbox().setX(enemy.getX());
		enemy.getHitbox().setY(enemy.getY());
		for(int i = 0; i < enemy.getCharactersFollowed().size();i++){
			if(attack(enemy, enemy.getCharactersFollowed().get(i))){
				return;
			}
			if(follow(enemy, enemy.getCharactersFollowed().get(i))){
				enemy.setState(new EnemyMovingState(enemy));
			}
		}
	}
	@Override
	public int getID() {
		return 0;
	}
}
