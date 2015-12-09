import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.io.File;
import java.net.URL;
import java.util.ArrayList;

import javax.swing.JPanel;

import resources.Pic;

public class Screen extends JPanel implements Runnable {

	private static final long serialVersionUID = 1L;
	//Game Conditions 
	public static boolean runGame = true;
	public static boolean isFirst = true;
	//Main Thread 
	public Thread thread = new Thread(this);

	//Referencing class 
	public Frame frame;
	public Player player;
	public Room room;
	public LevelLoad levelLoad;
	/**
	 * Screen constructor
	 * adds keylistener and sets the panel size equal the the frame.
	 * 
	 */
	public Screen(Frame frame) {
		frame.addKeyListener(new KeyMove(this));
		frame.setSize(new Dimension(frame.getWidth(), frame.getHeight()+28));
		define();
		thread.start(); //Starts Thread
	}
	
	/**
	 * Paints room and player
	 * Lightweight vs paint
	 */
	public void paintComponent(Graphics g) {
		g.clearRect(0, 0, getWidth(), getHeight());// Clears
		room.draw(g);
		player.draw(g);
	}
	/**
	 * Make new instances of room,players,and level load.
	 */
	public void define() {
		// initialize instance
		room = new Room("spawn");
		player = new Player("Jason Tran");
		levelLoad = new LevelLoad(this);
		System.out.println(player);
	}

	/**
	 * Collisions checker
	 */
	public void checkC() {
		// bulletCheck to blocks 
        //Loops through (columns,rows,bullets(Dynamic Data))
		ArrayList<Bullet> bullet = player.getbullet();
		for (int y = 0; y < room.blocks.length; y++) {
			for (int x = 0; x < room.blocks[0].length; x++) {
				for (int i = 0; i < bullet.size(); i++) {
					if (bullet.get(i).collison(room.blocks[y][x])
							&& room.blocks[y][x].passable == false) {
						bullet.remove(i);
					}
				}

			}
		}
		// Player block check 
		//Loops through(columns,rows) then checks if passable set to old location
		for (int y = 0; y < room.blocks.length; y++) {
			for (int x = 0; x < room.blocks[0].length; x++) {
				if (player.collison(room.blocks[y][x])
						&& room.blocks[y][x].passable != true) {
					player.x = player.oldx;
					player.y = player.oldy;
				}
			}
		}
		//Player exit check
		//Loops through(columns,rows) then checks if blocks is exit
		for (int y = 0; y < room.blocks.length; y++) {
			for (int x = 0; x < room.blocks[0].length; x++) {
				if (player.collison(room.blocks[y][x])
						&& room.blocks[y][x].id == Block.exitID) {
					System.out.println("exiting");
				}
			}
		}
	}
	/**
	 * The game loop(Thread)
	 */
	public void run() {
		while (true) {
			if (isFirst) {
				loadRoom("test.txt"); //First run needs to read room before updating
				isFirst = false;
			} else if (runGame) {
				update(); // update
				checkC(); // check collision
				repaint(); // render
			}
			try {
				Thread.sleep(1000 / 60);// 1000/60 = 60fps
			} catch (Exception e) {

			}

		}

	}
	/**
	 * File loader turns string into a file to be read in levelload
	 */
	private void loadRoom(String path) {
		String url = Pic.class.getResource(path).getFile();
		File file = new File(url);
		levelLoad.loadSave(file);
	}
	/**
	 * File loader turns string into a file to be read in levelload
	 */
	private void update() {
		player.bulletMove();
		player.physic();
	}

}
