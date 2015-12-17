import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;

import javax.imageio.ImageIO;

public class Player extends Object {

	public enum face {
		UP, DOWN, LEFT, RIGHT;
	}

	// Properties
	public String name;
	public int health;
	public int coin;
	public boolean running;
	public int runSpeed = 15;
	// players locations/direction
	int currentRoomId;
	int oldx, oldy;
	Timer runcd = new Timer();
	Timer slowing = new Timer();
	BufferedImage image;
	public boolean pUP;
	public boolean pDOWN;
	public boolean pRIGHT;
	public boolean pLEFT;
	public boolean space;
	public String loc;

	public face f = Player.face.LEFT;

	public ArrayList<Bullet> bullet; // dynamic data structures

	/**
	 * constructor for player defines x, y, width, height loads image
	 * 
	 * @param name
	 */
	public Player(String name , String id) {
		this.name = name;
		setBounds(x, y, width, height);
		loc = id;
		x = 300;
		y = 300;
		height = 80;
		width = 80;
		speed = 5;
		image = imageLoad("turtle.png");
		bullet = new ArrayList<Bullet>();
	}

	/**
	 * moves and changes changing direction (f)
	 */
	public void physic() {
		oldx = x;
		oldy = y;
		if (pUP) {
			f = Player.face.UP;
			up();
		}
		if (pDOWN) {
			f = Player.face.DOWN;
			down();
		}
		if (pLEFT) {
			f = Player.face.LEFT;
			left();
		}
		if (pRIGHT) {
			f = Player.face.RIGHT;
			right();
		}
		if (running) {
			running();
		}
		if (space) {
			fire();
		}

	}

	public void running() {
		speed = runSpeed;
		runcd.schedule(new TimerTask() {
			@Override
			public void run() {
				if (speed != 5) {
					deacceleration();
				}
			}

			private void deacceleration() {
				speed -= 1;
				System.out.println("slow");
			}
		}, 1000);

	}

	/**
	 * makes the bullet move
	 */
	public void bulletMove() {
		for (int i = 0; i < bullet.size(); i++) {
			bullet.get(i).shoot();
		}

	}

	/**
	 * creates the bullet and adds to arraylist
	 */
	private void fire() {
		bullet.add(new Bullet(this, getX(), getY(), 20, 20)); // Creates New
																// Bullets
		space = false; // reset space
	}

	/**
	 * getters
	 * 
	 * @return
	 */
	public ArrayList<Bullet> getbullet() {
		return bullet;
	}

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}

	/**
	 * draw method draws bullets, name, image
	 * 
	 * @param g
	 */
	public void draw(Graphics g) {
		g.drawString(name, x, y - 10); // name above player
		g.drawImage(image, x, y, width, height, null); // player image
		for (int i = 0; i < bullet.size(); i++) { // loop
			bullet.get(i).draw(g); // for every bullet
		}

	}

}
