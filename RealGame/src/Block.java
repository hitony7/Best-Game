import java.awt.Graphics;
import java.awt.Image;

public class Block extends Object {
	// single block properties
	int id;
	int wallID = 1;
	int floorID = 0;
	static int exitID = 2;
	int spawner = 2;
	int shop = 1;
	boolean passable;

	public Block(int x, int y, int height, int width) {
		// Block Constructor
		this.x = x;
		this.y = y;
		this.height = height;
		this.width = width;
	}

	/**
	 * draws block depending on id
	 * 
	 * @param g
	 */

	public void draw(Graphics g) {
		// Background and walls
		if (id == wallID) {
			g.drawImage(BlcImages.wallPic, x, y, height, width, null);
			passable = false;
		}
		if (id == floorID) {
			g.drawImage(BlcImages.floorPic, x, y, height, width, null);
			passable = true;
		}
		if (id == exitID || id == 3 || id == 4 || id == 5) {
			g.drawImage(BlcImages.floorPic, x, y, height, width, null);
			passable = true;
		}
	}

	/**
	 * draw second layer of the block
	 * 
	 * @param g
	 */

	public void drawLayer2(Graphics g) {
		// Object(Interactive Stuff)
		if (id == spawner) {
			g.drawImage(BlcImages.crack, x, y, height, width, null);
		}
		if (id == shop) {
			g.drawImage(BlcImages.randShop, x, y, height, width, null);
		}
	}
}
