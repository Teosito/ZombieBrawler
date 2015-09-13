package characters.enemies.weapons;

import org.newdawn.slick.SlickException;

public class Claws extends EnemyWeaponBase{
	public Claws()throws SlickException {
		damage = 1;
		magazine = -1;
		attackRange = 10;
		attackTime = 2;
		duration = 1;
	}

}
