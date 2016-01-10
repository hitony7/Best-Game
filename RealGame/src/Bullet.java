import java.awt.Graphics;
import java.awt.image.BufferedImage;

public class Bullet extends Object {
	private final Player player;
	public boolean inGame = false;
	BufferedImage image;
	int speed = 10;
	int speedx;
	int damage;
	final Player.face f;
	public boolean UP;
	public boolean DOWN;
	public boolean RIGHT;
	public boolean LEFT;

	public Bullet(Player player, int x, int y, int height, int width,
			boolean UP, boolean DOWN, boolean LEFT, boolean RIGHT) {
		this.player = player;
		f = this.player.f;
		this.x = x;
		this.y = y;
		this.height = height;
		this.width = width;
		this.UP = UP;
		this.DOWN = DOWN;
		this.LEFT = LEFT;
		this.RIGHT = RIGHT;
		damage = 1;
		image = imageLoad("Bullet.png");
		inGame = true;
	}

	public void shoot() {
		// Shooting depending on direction;
		if (LEFT) {
			x -= speed;
		} else if (RIGHT){
			x += speed;
		}
		if (UP) {
			y -= speed;
		} else if (DOWN){
			y += speed;
		}
	}

	public void shooting() {

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
