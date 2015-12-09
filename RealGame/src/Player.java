import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;

public class Player extends Object {

	public enum face {
		UP, DOWN, LEFT, RIGHT;
	}

	int currentRoomId;
	int oldx, oldy;
	String name;
	BufferedImage image;

	public boolean pUP;
	public boolean pDOWN;
	public boolean pRIGHT;
	public boolean pLEFT;
	public boolean space;
	public ArrayList<Bullet> bullet;
	public face f = Player.face.LEFT;

	public Player(String name) {
		this.name = name;
		x = 300;
		y = 300;
		height = 100;
		width = 80;
		speed = 8;
		image = imageLoad("turtle.png");
		bullet = new ArrayList<Bullet>();
	}

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
		if (space) {
			fire();
		}

	}

	public void bulletMove() {
		for (int i = 0; i < bullet.size(); i++) {
			if (bullet.get(i) != null) {
				bullet.get(i).shoot();
			}
		}

	}

	private void fire() {
		// Creates New Bullets
		bullet.add(new Bullet(this, getX(), getY(), 20, 20));
		space = false;
	}

	public ArrayList<Bullet> getbullet() {
		return bullet;
	}

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}

	public void draw(Graphics g) {
		g.drawString(name, x, y - 10);
		g.drawImage(image, x, y, width, height, null);
		if (bullet != null) {
			for (int i = 0; i < bullet.size(); i++) {
				bullet.get(i).draw(g);
			}

		}
	}

}
