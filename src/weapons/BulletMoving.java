package weapons;

import java.util.Timer;
import java.util.TimerTask;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;

public class BulletMoving extends BasicGameState{
	private Bullet bullet;
	
	public BulletMoving(Bullet bullet) {
			this.bullet=bullet;
	}
	@Override
	public void init(GameContainer arg0, StateBasedGame arg1)
			throws SlickException {
		// TODO Auto-generated method stub
		
	}
	
	@Override
	public void render(GameContainer arg0, StateBasedGame arg1, Graphics arg2)
			throws SlickException {
		bullet.getImage().draw(bullet.getX(),bullet.getY());
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update(GameContainer arg0, StateBasedGame arg1, int arg2)
			throws SlickException {
		bullet.setY((int) (bullet.getY()+bullet.getSpeedY()));
		new Timer().schedule(new TimerTask() {          
		    @Override
		    public void run() {
		    	bullet.setFinish(true);
		    }
		}, (long) (bullet.getDuration()*1000));
		
		if(bullet.isDirection()){
			bullet.setX((int) (bullet.getX()+bullet.getSpeedX()));
		}else{
			bullet.setX((int) (bullet.getX()-bullet.getSpeedX()));
		}		
		bullet.getHitbox().setX(bullet.getX());
		bullet.getHitbox().setY(bullet.getY());
		
	}

	@Override
	public int getID() {
		// TODO Auto-generated method stub
		return 0;
	}

}
