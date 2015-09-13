package main;

import org.newdawn.slick.Image;

public abstract class Objects {
	protected int x;
	protected int y;
	protected Image image;
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
	public float getImageWidth() {
		return image.getWidth();
	}
	public Image getImage() {
		return image;
	}
	public void setImage(Image image) {
		this.image = image;
	}
	

}
