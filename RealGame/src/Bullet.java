
import java.awt.Graphics;
import java.awt.image.BufferedImage;

public class Bullet extends Object {
	private final Player player;
	public boolean inGame = false;
	BufferedImage image;
	int speed = 10;
	final Player.face f;

	public Bullet(Player player, int x, int y, int height, int width) {
		this.player = player;
		f = this.player.f;
		this.x = x;
		this.y = y;
		this.height = height;
		this.width = width;
		image = imageLoad("Bullet.png");
		inGame = true;
	}

	public void shoot() {
		// Shooting depending on direction
		if (f == Player.face.LEFT)
			x -= speed;
		else if (f == Player.face.RIGHT)
			x += speed;
		else if (f == Player.face.UP)
			y -= speed;
		else if (f == Player.face.DOWN)
			y += speed;
	}

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}

	public void draw(Graphics g) {
	
			g.drawImage(image, x, y, width, height, null);
		

	}
}
