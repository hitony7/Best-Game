import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.TextArea;

import javax.swing.JLabel;

public class Hud {
	JLabel health = new JLabel();
	JLabel coins = new JLabel();
	Rectangle back = new Rectangle(10,10,150,50);
	

	Screen screen;

	public Hud(Screen screen) {
		this.screen = screen;
	}

	public void draw(Graphics g) {
		//Graphics2D g2 = (Graphics2D) g;
		//g2.fill(back);
		g.drawImage(BlcImages.backpanel, back.x, back.y, back.width, back.height, null);
		g.setFont(new Font("TimesRoman", Font.PLAIN, 20));
	
		
		g.setColor(Color.WHITE);
		g.drawString("Health: " +  screen.player.health, 15, 30);
		g.drawString("Coins: " +  screen.player.coin, 15, 50);
	}
}