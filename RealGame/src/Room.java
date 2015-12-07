import java.awt.Graphics;

public class Room {
	String ID;
	public Block[][] blocks;

	public int worldWidth = 1;
	public int worldHeight = 1;
	public int blockSize = 100;

	public Room(String ID) {
		DefineRoom();
		System.out.println(ID);
	}

	public void DefineRoom() {
		// Define Block type/Location
		blocks = new Block[worldWidth][worldHeight];
		for (int y = 0; y < blocks.length; y++) {
			for (int x = 0; x < blocks[0].length; x++) {
				blocks[y][x] = new Block(20, 20, blockSize, blockSize, 1);
			}
		}
	}

	public void draw(Graphics g) {
		// Draw the Room
		for (int y = 0; y < blocks.length; y++) {
			for (int x = 0; x < blocks[0].length; x++) {
				blocks[y][x].draw(g);
			}
		}
	}
}
