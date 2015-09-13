package characters.mainCharacter;

import items.inventoryObjects.InventoryObjects;

import java.util.ArrayList;

import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.geom.Rectangle;

import weapons.Handgun;
import weapons.WeaponBase;
import characters.Characters;
import characters.mainCharacter.states.MainCharacterStillState;

public class MainCharacter extends Characters {
	protected static WeaponBase weapon;
	protected static ArrayList<InventoryObjects>inventoryObjects = new ArrayList<InventoryObjects>();
	protected double recoverSpeed;
	protected boolean shoot = false;
	protected boolean direction = true;
	protected int shootingTime;
	public MainCharacter() throws SlickException {
		image = new Image("data/character/mainCharacter/characterStill.png");
		state = new MainCharacterStillState(this);
		hitbox = new Rectangle(0, 0, image.getWidth()/2, image.getHeight()/3);
		hitpoints = 100;
		speedX = 3;
		stamina = 100;
		maxStamina = 100;
		recoverSpeed = 0.5;
		weapon = new Handgun();
	}
	public int getShootingTime() {
		return shootingTime;
	}
	public void setShootingTime(int shootingTime) {
		this.shootingTime = shootingTime;
	}
	public boolean isDirection() {
		return direction;
	}
	public void setDirection(boolean direction) {
		this.direction = direction;
	}
	public boolean isShoot() {
		return shoot;
	}
	public void setShoot(boolean shoot) {
		this.shoot = shoot;
	}
	
	public static WeaponBase getWeapon() {
		return weapon;
	}
	public static void setWeapon(WeaponBase weapon) {
		MainCharacter.weapon = weapon;
	}
	public double getRecoverSpeed() {
		return recoverSpeed;
	}
	public void setRecoverSpeed(double recoverSpeed) {
		this.recoverSpeed = recoverSpeed;
	}
	
}
