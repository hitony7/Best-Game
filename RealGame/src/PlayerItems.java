public class PlayerItems {
	Player player;

	public PlayerItems(Player player) {
		this.player = player;

	}

	public void playersetHP() {
		player.health = health10();
	}

	public int health10() {
		return player.health + 10;
	}

	public int attackMuit() {
		return (int) ((int) player.timecool * 0.50);
	}

	public int speedUp() {
		return player.speed + 1;
	}

	/**
	 * ran 1/3 chance of each effect
	 */

	public void effectRand() {
		int temp = (int) (Math.random() * (3 - 1) + 1);
		if (temp == 1) {
			player.speed = speedUp();
			System.out.println("speed");
		}
		if (temp == 2) {
			player.timecool = attackMuit();
			System.out.println("attackup");
			if (temp == 3) {
				playersetHP();
				System.out.println("hpup");
			}

		}
	}
}
