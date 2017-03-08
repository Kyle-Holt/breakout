package breakoutModel;

import java.awt.Color;
import java.awt.Component;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.Shape;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;

public class drawGame extends JPanel implements ActionListener, KeyListener {

	int numOfBricks = 250;
	Timer tm = new Timer(5, this);
	static Board board = new Board();
	Ball ball = new Ball();
	Paddle paddle = new Paddle();
	Array[] intArray = new Array[3];
	private Brick bricks[];
	
	int x = 200;
	int y = 500;
	

	public drawGame() {
		
		bricks = new Brick[numOfBricks];
		board.setHeight(15*50);
		board.setWidth(10*50);
		ball.setRadius(10);
		ball.setX(x);
		ball.setY(y);
		ball.setX_velocity(2);
		ball.setY_velocity(2);
		
		paddle.setPaddle_Y(650);
		paddle.setPaddle_X_velocity(0);
		paddle.setPaddle_X(200);
		paddle.setPaddleHeight(10);
		paddle.setPaddleWidth(100);
	
		
		addKeyListener(this);
		setFocusable(true);
		setFocusTraversalKeysEnabled(false);
        for (int k = 0; k < numOfBricks; k++) {
        	bricks[k] = new Brick();
        }
	}
	
	public void paintComponent(Graphics g) {
		super.paintComponent(g);

		paddle.draw(g);
		ball.draw(g);
		int tempY = 0;
		
		//this will assign any number of bricks to the board space and assign them properly	
		for(int i = 0; i < numOfBricks; i++) {
			if (i %10 == 0) {
				tempY += bricks[i].getHeight();
			}
			if(!bricks[i].isDestroyed()) {
				bricks[i].draw(g, (i*bricks[i].getWidth()) % board.getBoardWidth(), tempY, bricks[i].getWidth(), bricks[i].getHeight());
				bricks[i].setX((i*bricks[i].getWidth()) % board.getBoardWidth());
				bricks[i].setY(tempY);
			}
		}
		
		tm.start();
	}
	
	public void actionPerformed(ActionEvent e) {

		ball.ballWallCollision(board);
		paddle.move();
		checkCollision();

		repaint();
	}
	
	public static void main(String[] args) {

		drawGame d = new drawGame();
		
		JFrame jf = new JFrame();
		
		jf.setTitle("Breakout");
		jf.setSize((int) ((int) board.getBoardWidth()+17),(int) board.getBoardHeight());
		jf.setVisible(true);
		jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		jf.add(d);
	}



	public void keyPressed(KeyEvent e) {

		int c = e.getKeyCode();
		
		if (c == KeyEvent.VK_LEFT) {
			paddle.setPaddle_X_velocity(-3);
		}
		else if (c == KeyEvent.VK_RIGHT) {
			paddle.setPaddle_X_velocity(3);
		}
	}

	public void keyReleased(KeyEvent arg0) {
		paddle.setPaddle_X_velocity(0);
	}

	public void keyTyped(KeyEvent arg0) {
		
	}
	private void checkCollision() {
		 for (int i = 0, j = 0; i < numOfBricks; i++) {
	            
	            if (bricks[i].isDestroyed()) {
	                j++;
	            }
	            
	            if (j == numOfBricks) {
	                //message = "Victory";
	                //stopGame();
	            }
	}
		 if ((ball.getRect()).intersects(paddle.getRect())) {

	            int paddleLPos = (int) paddle.getRect().getMinX();
	            int ballLPos = (int) ball.getRect().getMinX();

	            int first = paddleLPos + 8;
	            int second = paddleLPos + 16;
	            int third = paddleLPos + 24;
	            int fourth = paddleLPos + 32;

	            if (ballLPos < first) {
	                ball.setX_velocity(-2);
	                ball.setY_velocity(-2);
	            }

	            if (ballLPos >= first && ballLPos < second) {
	                ball.setX_velocity(-2);
	                ball.setY_velocity(-1 * ball.getY_velocity());
	            }

	            if (ballLPos >= second && ballLPos < third) {
	                ball.setX_velocity(0);
	                ball.setY_velocity(-2);
	            }

	            if (ballLPos >= third && ballLPos < fourth) {
	                ball.setX_velocity(1);
	                ball.setY_velocity((-1 * ball.getY_velocity()));
	            }

	            if (ballLPos > fourth) {
	                ball.setX_velocity(2);
	                ball.setY_velocity(-2);
	            }
	        }
	for (int i = 0; i < numOfBricks; i++) {
        
        if ((ball.getRect()).intersects(bricks[i].getRect())) {

            int ballLeft = (int) ball.getRect().getMinX();
            int ballHeight = (int) ball.getRect().getHeight();
            int ballWidth = (int) ball.getRect().getWidth();
            int ballTop = (int) ball.getRect().getMinY();

            Point pointRight = new Point(ballLeft + ballWidth + 1, ballTop);
            Point pointLeft = new Point(ballLeft - 1, ballTop);
            Point pointTop = new Point(ballLeft, ballTop - 1);
            Point pointBottom = new Point(ballLeft, ballTop + ballHeight + 1);

            if (!bricks[i].isDestroyed()) {
                if (bricks[i].getRect().contains(pointRight)) {
                    ball.setX_velocity(-2);
                } else if (bricks[i].getRect().contains(pointLeft)) {
                    ball.setX_velocity(2);
                }

                if (bricks[i].getRect().contains(pointTop)) {
                    ball.setY_velocity(2);
                } else if (bricks[i].getRect().contains(pointBottom)) {
                    ball.setY_velocity(-2);
                }

                bricks[i].setDestroyed(true);
            }
        }
    }
}
}
