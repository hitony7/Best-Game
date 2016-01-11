
public class PlayerItems {
	Player player;
	
	public PlayerItems(Player player){
		this.player = player;
		
	}
	
	public void playersetHP(){
		player.health = health10();
	}
	
	public int health10() {
		return  player.health + 10;
	}
	public int attackMuit() {
		return (int) ((int) player.timecool * 0.50) ;
	}
	public int speedUp() {
		return  player.speed + 1;
	}


}
