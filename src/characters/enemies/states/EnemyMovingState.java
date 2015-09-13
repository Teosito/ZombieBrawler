package characters.enemies.states;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.StateBasedGame;

import characters.enemies.EnemyBase;

public class EnemyMovingState extends EnemyBaseState{
	private EnemyBase enemy;
	
	public EnemyMovingState(EnemyBase enemy)throws SlickException {
		this.enemy = enemy;
		// TODO Auto-generated constructor stub
	}
	@Override
	public void init(GameContainer arg0, StateBasedGame arg1)
			throws SlickException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void render(GameContainer arg0, StateBasedGame arg1, Graphics arg2)
			throws SlickException {
		enemy.getImage().draw(enemy.getX(), enemy.getY());
		// TODO Auto-generated method stub
	}

	@Override
	public void update(GameContainer arg0, StateBasedGame arg1, int arg2)
			throws SlickException {
		for(int i = 0; i < enemy.getCharactersFollowed().size();i++){	
				if(follow(enemy, enemy.getCharactersFollowed().get(i))){
					if(attack(enemy, enemy.getCharactersFollowed().get(i))){
						return;
					}
				}
			}
		for(int i = 0; i < enemy.getCharactersFollowed().size();i++){
			if(follow(enemy,enemy.getCharactersFollowed().get(i))){
				if(follow(enemy, enemy.getCharactersFollowed().get(i))==false){
				enemy.setState(new EnemyStillState(enemy));
				}
			}
		}
		for(int i = 0; i < enemy.getCharactersFollowed().size();i++){	
			if(follow(enemy, enemy.getCharactersFollowed().get(i))){
				enemy.setX(enemy.getX()+enemy.getSpeedX());
				enemy.setY(enemy.getY()+enemy.getSpeedY());
				break;
			}
		}
		
	}
	@Override
	public int getID() {
		// TODO Auto-generated method stub
		return 0;
	}

}
