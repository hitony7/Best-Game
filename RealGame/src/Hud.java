import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.TextArea;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JLabel;
import javax.swing.Timer;

public class Hud implements ActionListener {
	Rectangle back = new Rectangle(10, 10, 150, 50);
    Timer timerAlive = new Timer(1000, this);
	Screen screen;

	public Hud(Screen screen) {
		this.screen = screen;
		timerAlive.start();
	}

	public void draw(Graphics g) {
		// Graphics2D g2 = (Graphics2D) g;
		// g2.fill(back);
		g.drawImage(BlcImages.backpanel, back.x, back.y, back.width,
				back.height, null);
		g.setFont(new Font("TimesRoman", Font.PLAIN, 20));

		g.setColor(Color.WHITE);
		g.drawString("Health: " + screen.player.health, 15, 30);
		g.drawString("Coins: " + screen.player.coin, 15, 50);
		g.drawString("Time:" + screen.player.countsec , 1000, 30);
		
		if (screen.player.health < 0){
			g.drawString("Player is Dead", 550, 300);
			g.drawString("Press r to restart", 550, 350);
		}
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
			screen.player.countsec++;	
	}
}