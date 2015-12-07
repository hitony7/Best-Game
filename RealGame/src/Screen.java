import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.util.ArrayList;

import javax.swing.JPanel;

public class Screen extends JPanel implements Runnable {

	private static final long serialVersionUID = 1L;

	public static boolean runGame = true;

	public static Frame frame;
	public Thread thread = new Thread(this);
	public static int myWidth, myHeight;

	public Player player;
	public Room room;

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
		System.out.println(player);
	}

	public void checkC() {
		ArrayList<Bullet> bullet = player.getbullet();
		// bulletCheck
		for (int i = 0; i < bullet.size(); i++) {
			if (bullet.get(i).collison(room.blocks[0][0])) {
				bullet.remove(i);
			}
		}
		// Needs Double for loop x and y;
		for (int i = 0; i < 5; i++) {
			if (player.collison(room.blocks[0][0])) {
				player.x = player.x - 1;
			}
		}
	}

	public void run() {
		// Runs game loop
		while (true) {
			if (runGame) {
				update(); // update
				checkC(); // check collision
				repaint(); // render
			}
			try {
				thread.sleep(1000 / 60);// 1000/60 = 60fps
			} catch (Exception e) {

			}

		}

	}

	private void update() {
		player.bulletMove();
		player.physic();

	}

}
