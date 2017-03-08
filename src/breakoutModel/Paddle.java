package breakoutModel;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

public class Paddle {

	protected int paddleY;
	protected int pvelY;
	protected int paddleX;
	protected int paddleHeight;
	protected int paddleWidth;
	Board board = new Board();
	
	public void draw(Graphics g) {
		g.setColor(Color.RED);
		g.fillRect(paddleX, paddleY, paddleWidth, paddleHeight);
	}
	public void move() {
		setPaddle_X(getPaddle_X()+ getPaddle_X_velocity());
	}
	
	public void setPaddle_X(int d) {
		paddleX = d;
	}
	
	public void setPaddle_Y(int d) {
		paddleY = d;
	}
	
	public void setPaddle_X_velocity(int d) {
		pvelY = d;
	}
	
	public void setPaddleHeight(int d) {
		paddleHeight = d;
	}
	
	public void setPaddleWidth(int d) {
		paddleWidth = d;
	}
	
	public int getPaddle_X() {
		return paddleX;
	}
	
	public int getPaddle_Y() {
		return paddleY;
	}
	
	public int getPaddle_X_velocity() {
		return pvelY;
	}
	
	public int getPaddleHeight() {
		return paddleHeight;
	}
	
	public int getPaddleWidth() {
		return paddleWidth;
	}
	
	Rectangle getRect() {
		return new Rectangle((int) paddleX, (int)paddleY,(int)paddleWidth,(int)paddleHeight);
	}
}
