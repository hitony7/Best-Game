import java.awt.Color;
import java.awt.Graphics;


public class Monster extends Object {
	int health;
	int healthspace = 3;
	int healthHeight = 6;
	int damage = 1;
	int baseCoins = 3;
	int maxCoins = 15; 
	int type;
	int speed = 5;
	
	public Monster(int x, int y, int width, int height, int type){
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
		this.type = type;
		health = 20;
	}
	
	public void move(){
	 y += speed;
		
	}
	public int randCoin(){
		 return (int) (Math.random() * (maxCoins - baseCoins) + baseCoins);
	}
	
	public void draw(Graphics g) {
			g.drawImage(BlcImages.monsterb, x, y, width, height, null);
			g.setColor(new Color(204,0,0));
			g.fillRect(x + ((width/2) - 10 )  , y - (healthspace + healthHeight), health, healthHeight);
	}


}
