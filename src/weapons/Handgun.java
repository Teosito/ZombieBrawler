package weapons;

import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;

public class Handgun extends WeaponBase{
	
	public Handgun()throws SlickException {
		magazine = 15;
		reloadTime = 10;
		shootingTime = 5;
		damage = 1;
		speedX = 10;
		speedY= 0;
		duration = 0.5;
		destructible = true;
		image = new Image("data/weapons/bullet.png");
	}

	/*@Override
	public void shoot(int x, int y, boolean direction)throws SlickException {
		bullets.add(new Bullet(damage, x, y, direction, speed, duration, image));
	}*/
	
	

}
