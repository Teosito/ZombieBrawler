package characters.enemies.weapons;

import org.newdawn.slick.SlickException;

public class Spit extends EnemyWeaponBase{
	public Spit()throws SlickException {
		damage = 1;
		magazine = 5;
		speedX = 3;
		attackRange = 100;
		attackTime = 2;
		duration = 5;
	}

}
