package items.background;

import java.util.Random;

import main.Options;

import org.newdawn.slick.Animation;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.SpriteSheet;
import org.newdawn.slick.geom.Rectangle;
import org.newdawn.slick.state.StateBasedGame;

public class Building extends BackgroundItems{
	
	private Random random;
	private int ID;
	private int number;
	private Animation animation;
	public Building(int x, int ID)throws SlickException {
		doorX = 20;
		scale = 500;
		y = Options.HEIGHT-Options.MOVEMENTPLACE-scale+100;
		this.x = x;
		image = new SpriteSheet("data/background/buildings.png", 102, 117);
		animation = new Animation(image, 1);
		random = new Random();
		number = (int) random.nextInt((image.getHorizontalCount()-1)+2-1);
		hitbox = new Rectangle(x, y+scale-10, 100, 10);
		this.ID = ID;
		
	}
	public Building()throws SlickException {
		scale = 500;
		x = 200;
		image = new SpriteSheet("data/background/buildings.png", 102, 117);
		animation = new Animation(image, 1);
		random = new Random();
		number = (int) random.nextInt((image.getHorizontalCount()-1)+2-1);

		y = Options.HEIGHT-Options.MOVEMENTPLACE-scale+100;
		
	}
	public void init(GameContainer arg0, StateBasedGame arg1)
			throws SlickException {
		}
		
	@Override
	public void render(GameContainer arg0, StateBasedGame arg1, Graphics arg2)
			throws SlickException {
		animation.setCurrentFrame(number);
		animation.stop();
		animation.draw(x,y,scale,scale);
		arg2.draw(hitbox);
		// TODO Auto-generated method stub
		
	}
	@Override
	public void update(GameContainer arg0, StateBasedGame arg1, int arg2)
			throws SlickException {
		// TODO Auto-generated method stub
		
	}
	@Override
	public int getID() {
		// TODO Auto-generated method stub
		return ID;
	}
	public int getDoorX() {
		return doorX;
	}
	public void setDoorX(int doorX) {
		this.doorX = doorX;
	}
	
}
