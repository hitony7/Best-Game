import java.awt.Graphics;

public class Room {

	String ID;
	// Data structures
	public Block[][] blocks;
	public Block[][] layer2;

	public int worldWidth = 15; // max width of room
	public int worldHeight = 9; // max height of room
	public int blockSize = 80;

	/**
	 * constructor defines layer
	 * 
	 * @param ID
	 */
	public Room(String ID) {
		DefineRoomLayer1();
		DefineRoomLayer2();
		System.out.println(ID);
	}

	/**
	 * defines layer1
	 */
	public void DefineRoomLayer1() {
		// Define Block type/Location
		blocks = new Block[worldHeight][worldWidth];
		for (int y = 0; y < blocks.length; y++) {
			for (int x = 0; x < blocks[0].length; x++) {
				blocks[y][x] = new Block(x * blockSize, y * blockSize,
						blockSize, blockSize);
			}
		}
	}

	/**
	 * defines layer 2 (interactive stuff)
	 */
	private void DefineRoomLayer2() {
		layer2 = new Block[worldHeight][worldWidth];
		for (int y = 0; y < layer2.length; y++) {
			for (int x = 0; x < layer2[0].length; x++) {
				layer2[y][x] = new Block(x * blockSize, y * blockSize,
						blockSize, blockSize);
			}
		}
	}

	/**
	 * draws blocks
	 * 
	 * @param g
	 */
	public void draw(Graphics g) {
		for (int y = 0; y < blocks.length; y++) {            
			for (int x = 0; x < blocks[0].length; x++) {     
				blocks[y][x].draw(g);
				// layer2[y][x].draw(g);
			}
		}
	}
}
