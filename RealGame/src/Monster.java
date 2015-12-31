import java.awt.Graphics;


public class Monster extends Object {
	int health;
	int type;
	
	public Monster(int x, int y, int width, int height, int type){
		setBounds(x, y, width, height);
		this.type = type;
	}
	
	
	public void draw(Graphics g) {
			g.drawImage(BlcImages.monsterb, x, y, width, height, null);
	}


}
