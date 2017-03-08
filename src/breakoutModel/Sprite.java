package breakoutModel;

import java.awt.Rectangle;

public class Sprite {
	
	protected int x;
	protected int y;
	protected int height;
	protected int width;
	
	
	Rectangle getRect() {
		return new Rectangle(x, y,width,height);
	}
	
	public double getX() {
		return x;
	}
	
	public double getY() {
		return y;
	}
	
	public void setX(int d) {
		this.x = d;
	}
	
	public void setY(int d) {
		this.y = d;
	}
	
	public int getPaddleHeight() {
		return height;
	}
	
	public int getPaddleWidth() {
		return width;
	}
}
