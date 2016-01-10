import java.awt.Color;
import java.awt.Graphics;

public class Monster extends Object {
	// healthbar above pic space
	int healthspace = 3;
	int healthHeight = 6;
	// Monster properties
	int health;
	int damage = 1;
	int baseCoins = 3;
	int maxCoins = 15;
	int type;
	int speed = 2;
	// to refer the screen
	Screen screen;

	public Monster(int x, int y, int width, int height, int type, Screen screen) {
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
		this.type = type;
		this.screen = screen;
		health = 20;
	}

	/**
	 * logic for monster tracking uses the difference between the player and
	 * monster
	 */
	public void move() {
		int xtemp = this.x - screen.player.getX();
		int ytemp = this.y - screen.player.getY();
		if (xtemp < 0) { // if xdifferance is positive then move left
			x += speed;
		}
		if (xtemp > 0) { // (right)
			x -= speed;
		}
		if (ytemp < 0) { // if ydifferance is positive then move down
			y += speed;
		}
		if (ytemp > 0) {// (up)
			y -= speed;
		}

	}

	/**
	 * random coins drop amount with max and mins
	 * 
	 * @return
	 */
	public int randCoin() {
		return (int) (Math.random() * (maxCoins - baseCoins) + baseCoins);
	}

	/**
	 * draws monster+ health bar
	 * 
	 * @param g
	 */
	public void draw(Graphics g) {
		g.drawImage(BlcImages.monsterb, x, y, width, height, null);
		g.setColor(new Color(204, 0, 0));
		g.fillRect(x + ((width / 2) - 10), y - (healthspace + healthHeight),
				health, healthHeight);
	}

}
