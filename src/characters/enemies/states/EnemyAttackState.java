package characters.enemies.states;

import java.util.Timer;
import java.util.TimerTask;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.StateBasedGame;

import characters.enemies.EnemyBase;

public class EnemyAttackState extends EnemyBaseState{
	private EnemyBase enemy;
	private boolean finish = false;
	public EnemyAttackState(EnemyBase enemy)throws SlickException {
		this.enemy = enemy;
		for(int i = 0; i < enemy.getCharactersFollowed().size();i++){
			enemy.useAttack(enemy, isClose(enemy, enemy.getCharactersFollowed().get(i)));
		}
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
		new Timer().schedule(new TimerTask() {          
		    @Override
		    public void run() {
		    	finish = true;
		    }
		}, 1000);
		
		if(finish){
			enemy.setState(new EnemyStillState(enemy));
		}
		// TODO Auto-generated method stub
		
	}

	@Override
	public int getID() {
		// TODO Auto-generated method stub
		return 0;
	}

}
