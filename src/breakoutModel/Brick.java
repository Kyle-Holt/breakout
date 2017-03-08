package breakoutModel;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.Shape;

public class Brick {

	Board board = new Board();
	double brickWidth = 50;
	double brickHeight= 10;
	double x_location;
	double y_location;
	boolean isDestroyed;
	
	public static void main(String[] args) {

	}

	public Brick() {
		isDestroyed = false;
	}
	
	public void draw(Graphics g, double x, double y, double width, double height) {
		g.setColor(Color.BLUE);
		g.drawRect((int) x,(int) y,(int) width,(int) height);
		x_location = x;
		y_location = y;
	}
	
	public boolean collision(Ball b) {
		boolean ballBrickCollision = false;

		//collision from bottom
		if ((b.getX() >= getX()) && (b.getX() <= getX() + getWidth())) {
			if (b.ballTop() == getY() + getHeight()) {
				ballBrickCollision = true;
			}
		}
		//collision from right side
		if ((b.getY() >= getY()) && (b.getY() <= getY() + getHeight())) {
			if (b.ballLeft() == getX() + getWidth()) {
				ballBrickCollision = true;
			}
		}
		//collision from left side
		if ((b.getY() >= getY()) && (b.getY() <= getY() + getHeight())) {
			if (b.ballRight() == getX()) {
				ballBrickCollision = true;
			}
		}
		//collision from top 
		if ((b.getX() >= getX()) && (b.getX() <= getX() + getWidth())) {
			if (b.ballBottom() == getY()) {
				ballBrickCollision = true;
			}
		}
		return ballBrickCollision;
		
	}
	
	public double getWidth() {

		return brickWidth;
	}
	public double getHeight() {

		return brickHeight;
	}
	
	public double getX() {
		return x_location;
	}
	
	public double getY() {
		return y_location;
	}
	
	public boolean isDestroyed() {
		return isDestroyed;
	}
	
	public void setDestroyed(boolean b) {
		isDestroyed = b;
	}
	
	Rectangle getRect() {
		return new Rectangle((int) x_location, (int)y_location,(int) brickWidth,(int) brickHeight);
	}
	public void setX(double d) {
		x_location = d;
	}
	
	public void setY(double d) {
		y_location = d;
	}

}
