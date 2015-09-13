package characters.enemies.weapons;

import java.util.ArrayList;

import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;

import weapons.Bullet;

public abstract class EnemyWeaponBase {
	protected int damage;
	protected int magazine;
	protected int attackRange;
	protected int attackTime;
	protected int duration;
	protected int speedX;
	protected int speedY;
	protected Image image;
	protected boolean destructible;
	protected static ArrayList<Bullet> enemyBullets = new ArrayList<Bullet>();
	public EnemyWeaponBase()throws SlickException {
		image = new Image("data/weapons/bullet.png");
	}
	public int getAttackRange() {
		return attackRange;
	}
	public void setAttackRange(int attackRange) {
		this.attackRange = attackRange;
	}
	public int getAttackTime() {
		return attackTime;
	}
	public void setAttackTime(int attackTime) {
		this.attackTime = attackTime;
	}
	public int getDamage() {
		return damage;
	}
	public void setDamage(int damage) {
		this.damage = damage;
	}
	public int getMagazine() {
		return magazine;
	}
	public void setMagazine(int magazine) {
		this.magazine = magazine;
	}	
	public void shoot(int x, int y, boolean direction)throws SlickException{
		enemyBullets.add(new Bullet(damage, x, y, direction, speedX, speedY, duration, image, destructible));
	}
	public ArrayList<Bullet> getEnemyBullets() {
		return enemyBullets;
	}
	public void setEnemyBullets(ArrayList<Bullet> bullets) {
		enemyBullets = bullets;
	}
}
