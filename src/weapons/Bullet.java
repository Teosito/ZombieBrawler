package weapons;

import java.util.ArrayList;

import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.geom.Rectangle;
import org.newdawn.slick.state.BasicGameState;

import characters.Characters;
import items.Items;

public class Bullet extends Items{
	private static ArrayList<Characters> HITTABLE = new ArrayList<Characters>();
	private BasicGameState state;
	private int damage;
	private boolean direction;
	private double speedX;
	private double speedY;
	private double duration;
	private boolean finish = false;
	private boolean destructible;
	public Bullet(int damage, int x, int y, boolean direction,double speedX, double speedY, double duration, Image image, boolean destructible) throws SlickException{
		this.damage = damage;
		this.x = x;
		this.y = y;
		this.image = image;
		this.direction = direction;
		this.speedX = speedX;
		this.speedY = speedY;
		this.duration = duration;
		this.destructible = destructible;
		hitbox = new Rectangle(x, y, image.getWidth(), image.getHeight());
		state = new BulletMoving(this);
	}
	
	public static ArrayList<Characters> getHITTABLE() {
		return HITTABLE;
	}

	public static void setHITTABLE(ArrayList<Characters> hITTABLE) {
		HITTABLE = hITTABLE;
	}

	public static void addHittable(Characters character){
		HITTABLE.add(character);
	}
	
	public boolean isDestructible() {
		return destructible;
	}

	public void setDestructible(boolean destructible) {
		this.destructible = destructible;
	}

	public double getSpeedY() {
		return speedY;
	}

	public boolean isFinish() {
		return finish;
	}

	public void setFinish(boolean finish) {
		this.finish = finish;
	}

	public double getDuration() {
		return duration;
	}
	public void setDirection(boolean direction) {
		this.direction = direction;
	}

	public BasicGameState getState() {
		return state;
	}

	public void setState(BasicGameState state) {
		this.state = state;
	}


	public int getDamage(){
		return damage;
	}

	public boolean isDirection() {
		return direction;
	}
	public double getSpeedX(){
		return speedX;
	}
}
