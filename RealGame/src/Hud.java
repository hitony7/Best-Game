import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.TextArea;

import javax.swing.JLabel;
import javax.swing.JTextArea;

public class Hud {
	JLabel health = new JLabel();
	JLabel coins = new JLabel();

	Screen screen;

	public Hud(Screen screen) {
		TextArea text = new TextArea();
		this.screen = screen;
	}

	public void draw(Graphics g) {
		g.setFont(new Font("TimesRoman", Font.PLAIN, 20));
		g.setColor(Color.WHITE);
		g.drawString("Health: " +  screen.player.health, 15, 30);
		g.drawString("Coins: " +  screen.player.coin, 15, 50);
	}
}
