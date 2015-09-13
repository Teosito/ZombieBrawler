package weapons;

import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;

public class Shotgun extends WeaponBase{
	public Shotgun() throws SlickException{
		magazine = 15;
		reloadTime = 10;
		shootingTime = 25;
		damage = 1;
		speedX = 20;
		speedY = 1;
		duration = 0.2;
		image = new Image("data/weapons/bullet.png");
		destructible = true;
	}
	@Override
	public void shoot(int x, int y, boolean direction)throws SlickException {
		bullets.add(new Bullet(damage, x, y, direction, speedX/2,speedY, duration, image, destructible));
		bullets.add(new Bullet(damage, x, y, direction, speedX/2,-speedY, duration, image, destructible));
		bullets.add(new Bullet(damage, x, y, direction, speedX/2,0, duration, image, destructible));
		bullets.add(new Bullet(damage, x, y, direction, speedX/3, speedY*2, duration, image, destructible));
		bullets.add(new Bullet(damage, x, y, direction, speedX/3, -speedY, duration, image, destructible));
	}
	

}
