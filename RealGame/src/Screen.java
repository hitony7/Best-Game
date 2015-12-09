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

	public static boolean runGame = true;
	public static boolean isFirst = true;

	public static Frame frame;
	public Thread thread = new Thread(this);
	public static int myWidth, myHeight;

	public Player player;
	public Room room;
	public LevelLoad levelLoad;

	public Screen(Frame frame) {
		frame.addKeyListener(new KeyMove(this));
		frame.setSize(new Dimension(frame.getWidth(), frame.getHeight()));
		myWidth = this.getWidth();
		myHeight = this.getHeight();
		define();
		thread.start();
	}

	public void paintComponent(Graphics g) {
		// Render
		g.clearRect(0, 0, getWidth(), getHeight());// Clears
		room.draw(g);
		player.draw(g);
	}

	public void define() {
		// initialize instance
		room = new Room("spawn");
		player = new Player("Jason Tran");
		levelLoad = new LevelLoad(this);
		System.out.println(player);
	}

	public void checkC() {
		ArrayList<Bullet> bullet = player.getbullet();
		for(int y=0;y<room.blocks.length;y++) {
			for(int x=0;x<room.blocks[0].length;x++) {
				for (int i = 0; i < bullet.size(); i++) {
					if (bullet.get(i).collison(room.blocks[y][x]) && room.blocks[y][x].passable == false) {
						bullet.remove(i);
					}
				}
			
				
			}
		}
	
		// bulletCheck

		// Needs Double for loop x and y;
		for (int i = 0; i < 5; i++) {
			if (player.collison(room.blocks[0][0])) {
				player.x = player.x;
			}
		}
	}

	public void run() {
		// Runs game loop
		while (true) {
			if (isFirst) {
				loadRoom("test.txt");
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

	private void loadRoom(String path) {
		String url = Pic.class.getResource(path).getFile();
		 File file = new File (url);
		 levelLoad.loadSave(file);
	}

	private void update() {
		player.bulletMove();
		player.physic();
	}

}
