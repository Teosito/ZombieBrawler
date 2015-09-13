package characters.enemies;

import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.geom.Rectangle;

import characters.enemies.states.EnemyStillState;
import characters.enemies.weapons.Claws;


public class FirstEnemyMelee extends EnemyBase{
	public FirstEnemyMelee()throws SlickException {
		image = new Image("data/character/enemies/zombie.png"); 
		state = new EnemyStillState(this);
		hitpoints = 5;
		speed = 1;
		speedX = speed;
		speedY = speed;
		stamina = 0;
		maxStamina = 0;
		visionRange = 100;
		weapon = new Claws();
		hitbox = new Rectangle(x, y, 100, 100);
	}

}
