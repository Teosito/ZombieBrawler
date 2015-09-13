package weapons;

import java.util.ArrayList;

import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;

public abstract class WeaponBase {

	protected static ArrayList<Bullet> bullets = new ArrayList<Bullet>();
	public ArrayList<Bullet> getBullets() {
		return bullets;
	}
	public void setBullets(ArrayList<Bullet> bullets) {
		WeaponBase.bullets = bullets;
	}
	protected int magazine;
	protected int reloadTime;
	protected int shootingTime;
	protected int damage;
	protected int speedX;
	protected int speedY;
	protected double duration;
	protected Image image;
	protected boolean destructible;
	
	public boolean isDestructible() {
		return destructible;
	}
	public void setDestructible(boolean destructible) {
		this.destructible = destructible;
	}
	public int getSpeedX() {
		return speedX;
	}
	public void setSpeedX(int speedX) {
		this.speedX = speedX;
	}
	public double getDuration() {
		return duration;
	}
	public void setDuration(double duration) {
		this.duration = duration;
	}
	public int getMagazine() {
		return magazine;
	}
	public void setMagazine(int magazine) {
		this.magazine = magazine;
	}
	public int getReloadTime() {
		return reloadTime;
	}
	public void setReloadTime(int reloadTime) {
		this.reloadTime = reloadTime;
	}
	public int getShootingTime() {
		return shootingTime;
	}
	public void setShootingTime(int shootingTime) {
		this.shootingTime = shootingTime;
	}
	public int getDamage(){
		return damage;
	}
	public void setDamage(int damage){
		this.damage = damage;
	}
	public void shoot(int x, int y, boolean direction)throws SlickException{
		bullets.add(new Bullet(damage, x, y, direction, speedX, speedY, duration, image, destructible));
	}

}
