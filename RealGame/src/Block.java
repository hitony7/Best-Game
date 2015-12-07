import java.awt.Graphics;
import java.awt.Image;

public class Block extends Object {
	int id;
	int wallID = 1;
	Image wallPic = imageLoad("Brick_white_wall.jpg");

	public Block(int x, int y, int height, int width, int id) {
		// Block Constructor
		this.x = x;
		this.y = y;
		this.height = height;
		this.width = width;
		this.id = id;
	}

	public void draw(Graphics g) {
		// Background and walls
		if (id == wallID) {
			g.drawImage(wallPic, x, y, height, width, null);

		}
	}

	public void drawLayer2(Graphics g) {
		// Object(Interactive Stuff)
		if (id == wallID) {
			g.drawImage(wallPic, x, y, height, width, null);

		}
	}
}
