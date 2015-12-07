import java.awt.Graphics;

public class Room {
	String ID;
	public Block[][] blocks;
	public Block[][] layer2;

	public int worldWidth = 10;
	public int worldHeight = 10;
	public int blockSize = 100;

	public Room(String ID) {
		DefineRoomLayer1();
		DefineRoomLayer2();
		System.out.println(ID);
	}

	public void DefineRoomLayer1() {
		// Define Block type/Location
		blocks = new Block[worldWidth][worldHeight];
		for (int y = 0; y < blocks.length; y++) {
			for (int x = 0; x < blocks[0].length; x++) {
				blocks[y][x] = new Block(x*blockSize, y*blockSize, blockSize, blockSize, 1);
			}
		}
	}
	
	private void DefineRoomLayer2() {
		layer2 = new Block[worldWidth][worldHeight];
		for (int y = 0; y < layer2.length; y++) {
			for (int x = 0; x < layer2[0].length; x++) {
				layer2[y][x] = new Block(x*blockSize, y*blockSize, blockSize, blockSize, 0);
			}
		}
	}

	public void draw(Graphics g) {
		// Draw the Room
		for (int y = 0; y < blocks.length; y++) {
			for (int x = 0; x < blocks[0].length; x++) {
				blocks[y][x].draw(g);
				layer2[y][x].draw(g);
			}
		}
	}
}
                     