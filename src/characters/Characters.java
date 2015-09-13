package characters;

import main.Objects;

import org.newdawn.slick.Image;
import org.newdawn.slick.geom.Shape;
import org.newdawn.slick.state.BasicGameState;

public abstract class Characters extends Objects{
	protected int speed;
	protected int speedX;
	protected int speedY;
	protected Shape hitbox;
	protected int hitpoints;
	protected double stamina;
	protected int maxStamina;
	protected BasicGameState state;
	public BasicGameState getState() {
		return state;
	}
	public double getStamina() {
		return stamina;
	}
	public void setStamina(double stamina) {
		this.stamina = stamina;
	}
	
	public int getMaxStamina() {
		return maxStamina;
	}
	public void setMaxStamina(int maxStamina) {
		this.maxStamina = maxStamina;
	}
	
	public int getHitpoints() {
		return hitpoints;
	}

	public void setHitpoints(int hitpoints) {
		this.hitpoints = hitpoints;
	}

	public void setState(BasicGameState state) {
		this.state = state;
	}
	public int getSpeedX() {
		return speedX;
	}
	public void setSpeedX(int speedX) {
		this.speedX = speedX;
	}
	public int getSpeed() {
		return speed;
	}
	public void setSpeed(int speed) {
		this.speed = speed;
	}
	public int getSpeedY() {
		return speedY;
	}
	public void setSpeedY(int speedY) {
		this.speedY = speedY;
	}
	public Shape getHitbox() {
		return hitbox;
	}
	public void setHitbox(Shape hitbox) {
		this.hitbox = hitbox;
	}
	public Image getImage() {
		return image;
	}
	public void setImage(Image image) {
		this.image = image;
	}
	
	

}
