import java.awt.Dimension;

import javax.swing.JFrame;

public class Frame extends JFrame {

	private static final long serialVersionUID = 1L;
	//Frame properties 
	public static String title = "legal legindz";
	public static Dimension size = new Dimension(1200, 720);

	/**
	 * Window constructor
	 */
	public Frame() {
		setTitle(title);
		setSize(size);
		setUndecorated(false);
		setVisible(true);
		setResizable(false);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		init();

	}

	/**
	 * Adds Screen(Jpanel) to this frame(JFrame)
	 */

	public void init() {
		Screen screen = new Screen(this);
		add(screen);

		setVisible(true);
	}

	/**
	 * 
	 * @Main Method Starts the screen
	 */

	public static void main(String args[]) {
		new Frame();
	}

}
