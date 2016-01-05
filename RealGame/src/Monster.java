import java.awt.Graphics;


public class Monster extends Object {
	int health;
	int type;
	int speed = 10;
	
	public Monster(int x, int y, int width, int height, int type){
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
		this.type = type;
	}
	
	public void move(){
	 y += speed;
		
	}
	
	
	public void draw(Graphics g) {
			g.drawImage(BlcImages.monsterb, x, y, width, height, null);
	}


}
