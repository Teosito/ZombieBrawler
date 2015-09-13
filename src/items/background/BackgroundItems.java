package items.background;

import org.newdawn.slick.SpriteSheet;
import org.newdawn.slick.geom.Shape;
import org.newdawn.slick.state.BasicGameState;

public abstract class BackgroundItems extends BasicGameState{
	protected int x;
	protected int y;
	protected SpriteSheet image;
	protected Shape hitbox;
	protected int doorX;
	protected static int scale;
	public int getX() {
		return x;
	}
	public void setX(int x) {
		this.x = x;
	}
	public int getY() {
		return y;
	}
	public void setY(int y) {
		this.y = y;
	}
	public SpriteSheet getImage() {
		return image;
	}
	public void setImage(SpriteSheet image) {
		this.image = image;
	}
	public Shape getHitbox() {
		return hitbox;
	}
	public void setHitbox(Shape hitbox) {
		this.hitbox = hitbox;
	}
	public static int getScale() {
		return scale;
	}
	public static void setScale(int scale) {
		BackgroundItems.scale = scale;
	}	
	public float getImageWidth() {
		return image.getWidth();
	}
	public int getDoorX() {
		// TODO Auto-generated method stub
		return doorX;
	}
	
}
