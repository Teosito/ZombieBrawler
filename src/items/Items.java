package items;
import main.Objects;

import org.newdawn.slick.geom.Shape;


public abstract class Items extends Objects{
	protected Shape hitbox;
	public Shape getHitbox() {
		return hitbox;
	}
	public void setHitbox(Shape hitbox) {
		this.hitbox = hitbox;
	}

}
