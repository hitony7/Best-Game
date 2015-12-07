import java.awt.Rectangle;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.URL;

import javax.imageio.ImageIO;
import javax.swing.JLabel;

public class Object extends JLabel {
	int x;
	int y;
	int height;
	int width;
	int speed;

	public void right() {
		this.x = this.x + this.speed;
	}

	public void left() {
		this.x = this.x - this.speed;
	}

	public void down() {
		this.y = this.y + this.speed;
	}

	public void up() {
		this.y = this.y - this.speed;
	}

	// Makes two rectangle and put it on the object then uses .intercept
	public boolean collison(Object object2) {
		Rectangle r = new Rectangle(this.x, this.y, this.height, this.width);
		Rectangle r2 = new Rectangle(object2.x, object2.y, object2.height,object2.width);
		return r.intersects(r2);
	}

	// Loads Image
	public static BufferedImage imageLoad(String string) {
		BufferedImage image = null;
		try {
			URL imageURL = resources.Pic.class.getResource(string);
			image = ImageIO.read(imageURL);	
		} catch (IOException e) {
			e.printStackTrace();
		}
		return image;
	}
	// Debug
	public String toString() {
		return "Current x,y:" + x + "," + y + " | Current height,width: "
				+ height + "," + width;
	}

}
