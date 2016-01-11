import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.Timer;

import javax.imageio.ImageIO;

public class Player extends Object implements ActionListener {

	// Properties
	public String name;
	public int health = 20;
	public int coin = 0;
	public boolean running;
	public int runSpeed = 15;
	BufferedImage image;
	public boolean canShoot = true; // player state on shooting
	public boolean interact = false;
	// players locations/direction
	int currentRoomId;
	int oldx, oldy;
	public int timecool = 200;
	Timer shootcd = new Timer(timecool, this); // cooldown deafult 0.2 seconds (1000 = 1sec)
	// Movement direction
	public boolean pUP;
	public boolean pDOWN;
	public boolean pRIGHT;
	public boolean pLEFT;

	// Direction of player shooting
	public boolean fUP;
	public boolean fDOWN;
	public boolean fRIGHT;
	public boolean fLEFT;

	public String loc;
	// dynamic data structures
	public ArrayList<Bullet> bullet; // needed because no set amount of bullets

	/**
	 * constructor for player defines x, y, width, height loads image
	 * 
	 * @param name
	 */
	public Player(String name, String id) {
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
	 * moves and changes changing direction of bullet
	 */
	public void physic() {
		oldx = x; // for collsion
		oldy = y;
		// player movement
		if (pUP) {
			up();
		}
		if (pDOWN) {
			down();
		}
		if (pLEFT) {
			left();
		}
		if (pRIGHT) {
			right();
		}
		// shooting if cooldown
		if (canShoot) {
			// if pressing and direction for wasd then fire(method)
			if (fUP || fDOWN || fRIGHT || fLEFT) {
				fire();
			}

		}

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
		bullet.add(new Bullet(this, getX(), getY(), 20, 20, this.fUP,
				this.fDOWN, this.fLEFT, this.fRIGHT)); // Creates New bullet at
														// player
		shootcd.start(); // cooldowntimer start
		canShoot = false; // cooldown var stop(unable to shoot)
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

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == shootcd) {
			// if timer is shootcd then allow the player to shoot
			canShoot = true;
			shootcd.stop(); // cooldowntimer stop
		}

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
