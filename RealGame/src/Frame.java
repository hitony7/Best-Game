
import java.awt.Dimension;

import javax.swing.JFrame;

public class Frame extends JFrame {

	private static final long serialVersionUID = 1L;

	public static String title = "legal legindz";
	public static Dimension size = new Dimension(1280, 720);

	public Frame() {
		// Window constructor
		setTitle(title);
		setSize(size);
		setUndecorated(false);
		setVisible(true);
		setResizable(false);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		init();

	}

	public void init() {
		Screen screen = new Screen(this);
		add(screen);

		setVisible(true);
	}

	public static void main(String args[]) {
		new Frame();
	}

}
