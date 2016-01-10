import java.awt.Rectangle;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.URL;

import javax.imageio.ImageIO;
import javax.swing.JLabel;

public class Object extends JLabel {
	// Properties of all objects
	int x;
	int y;
	int height;
	int width;
	int speed;

	/**
	 * Movement for all objects
	 */
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

	/**
	 * Makes two rectangle and put it on the object then uses .intercept
	 * @param object2
	 * @return
	 */
	public boolean collison(Object object2) {
		// TODO refector 
		//PS ANTHONY USE THIS IF YOU ARE JUST JLABELS (EXMAPLES IF YOU USE .SETLOCATION OR .SETBOUNDS)
		//return this.getBounds().intersects(object2.getBounds());
		
		//TONY's OTHER THING
		Rectangle r = new Rectangle(this.x, this.y, this.height, this.width);
		Rectangle r2 = new Rectangle(object2.x, object2.y, object2.height,
	    object2.width);
		return r.intersects(r2);
	}

	

	/**
	 * Loads image from resources package
	 * @param string
	 * @return
	 */
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
    /**
     * Debugging 
     */
	public String toString() {
		return "Current x,y:" + x + "," + y + " | Current height,width: "
				+ height + "," + width;
	}

}
