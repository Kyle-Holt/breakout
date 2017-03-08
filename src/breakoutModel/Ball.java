package breakoutModel;

import java.awt.Graphics;
import java.awt.Rectangle;

public class Ball {

	protected static double startingX_location;
	protected double x_location;
	protected double velX = 2;
	protected double y_location;
	protected double velY = 2;
	protected double vX;
	protected double vY;
	protected static int radius;
	protected boolean ballGone;
	
	public static void main(String[] args) {

	}
	
	public void draw(Graphics g) {
		g.drawOval((int) x_location - (int) radius,(int) y_location - (int) radius,(int) 2*(int)radius,(int) 2*(int)radius);
	}

	public void ballWallCollision(Board b) {
		//collision with bottom wall
		if (ballLeft() < 0) {
			setX_velocity(-getX_velocity());
		}
		
		
		if (ballRight() > b.getBoardWidth()) {
			setX_velocity(-getX_velocity());
		}
		if (ballTop() < 2*getRadius()) {
			setY_velocity(-getY_velocity());
		}
		
		setX(getX()+getX_velocity());
		
		setY(getY()+getY_velocity());
	}

	public void setRadius(int d) {
		radius = d;
	}
	
	public void setXStart(double d) {
		startingX_location = d;
	}
	
	public void setX(double d) {
		x_location = d;
	}
	
	public void setY(double d) {
		y_location = d;
	}
	
	public void setX_velocity(double d) {
		velX = d;
	}
	
	public void setY_velocity(double d) {
		velY = d;
	}
	
	public void setX_acceleration(double d) {
		vX = d;
	}
	
	public void setY_acceleration(double d) {
		vY = d;
	}
	
	public double getX_velocity() {
		return velX;
	}
	
	public double getY_velocity() {
		return velY;
	}
	
	public double getX_acceleration() {
		return vX;
	}
	
	public double getY_acceleration() {
		return vY;
	}
	
	public double getX() {
		return x_location;
	}
	
	public double getY() {
		return y_location;
	}
	
	public double getRadius() {
		return radius;
	}
	
	double ballLeft() {
		return x_location - radius;
	}
	
	double ballRight() {
		return x_location + radius;
	}
	
	double ballTop() {
		return y_location + radius;
	}
	
	double ballBottom() {
		return y_location - radius;
	}
	
	Rectangle getRect() {
		return new Rectangle((int) x_location, (int)y_location,2*(int)radius,2*(int)radius);
	}
}
