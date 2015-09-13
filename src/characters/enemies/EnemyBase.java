package characters.enemies;

import java.util.ArrayList;

import org.newdawn.slick.SlickException;

import characters.Characters;
import characters.enemies.weapons.Claws;
import characters.enemies.weapons.EnemyWeaponBase;

public abstract class EnemyBase extends Characters{
	protected int visionRange;
	protected EnemyWeaponBase weapon;
	protected static ArrayList<Characters> charactersFollowed = new ArrayList<Characters>();
	
	public EnemyWeaponBase getWeapon() {
		return weapon;
	}
	public void setWeapon(EnemyWeaponBase weapon) {
		this.weapon = weapon;
	}


	public void useAttack(EnemyBase enemy,Characters character)throws SlickException{
		boolean direction;
		int createdBullet;
		if(character.getX()<enemy.getX()){
			direction = false;
			createdBullet = -enemy.getImage().getWidth();
		}
		else{
			direction = true;
			createdBullet = enemy.getImage().getWidth();
		}
		if(enemy.getWeapon().getMagazine()>0){
			enemy.getWeapon().setMagazine(enemy.getWeapon().getMagazine()-1);
		}
		if(enemy.getWeapon().getMagazine()==0){
			enemy.setWeapon(new Claws());
		}
		weapon.shoot(x+createdBullet, y+enemy.getImage().getHeight()/2, direction);
		//character.setHitpoints(character.getHitpoints()-weapon.getDamage());
	}
	public ArrayList<Characters> getCharactersFollowed() {
		return charactersFollowed;
	}


	public int getVisionRange() {
		return visionRange;
	}

	public void setVisionRange(int visionRange) {
		this.visionRange = visionRange;
	}
	
	public static void addCharactersFollowed(Characters character){
		charactersFollowed.add(character);
	}
	
	
}
