import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.io.File;
import java.net.URL;
import java.util.ArrayList;

import javax.swing.JPanel;

import resources.Pic;

public class Screen extends JPanel implements Runnable {

	private static final long serialVersionUID = 1L;
	// Game Conditions
	public static boolean runGame = true;
	public static boolean isFirst = true;
	public static boolean spawnfirst = true;
	// Main Thread
	public Thread thread = new Thread(this);

	// Referencing class
	public Frame frame;
	public Player player;
	public Room room;
	public LevelLoad levelLoad;
	public Spawner spawner;
	public Hud hud;
	public Highscore highscore = new Highscore(this);
	public boolean reset = false;

	/**
	 * Screen constructor adds keylistener and sets the panel size equal the the
	 * frame.
	 * 
	 */
	public Screen(Frame frame) {
		frame.addKeyListener(new KeyMove(this));
		frame.setSize(new Dimension(frame.getWidth(), frame.getHeight() + 28));
		define();
		thread.start(); // Starts Thread
	}

	/**
	 * Paints room and player Lightweight vs paint
	 */
	public void paintComponent(Graphics g) {
		g.clearRect(0, 0, getWidth(), getHeight());// Clears
		room.draw(g);
		player.draw(g);
		hud.draw(g);

		if (spawner != null) {
			// only draw if in right room and not null
			spawner.draw(g, room.ID);
		}

		if (highscore.hide == false) {
			highscore.draw(g);
		}
	}

	/**
	 * Make new instances of room,players,and level load.
	 */
	public void define() {
		// initialize instance
		hud = new Hud(this);
		room = new Room("spawn");
		player = new Player("Jason Tran", room.ID);
		levelLoad = new LevelLoad(this);
		System.out.println(player);
	}

	/**
	 * Collisions checker
	 */
	public void checkC() {
		// bulletCheck to blocks
		// Loops through (columns,rows,bullets(Dynamic Data))
		ArrayList<Bullet> bullet = player.getbullet(); // gets bullet arraylist
		checkmobs(bullet);
		for (int y = 0; y < room.blocks.length; y++) {
			for (int x = 0; x < room.blocks[0].length; x++) {
				for (int i = 0; i < bullet.size(); i++) {
					if (bullet.get(i).collison(room.blocks[y][x])
							&& room.blocks[y][x].passable == false) {
						bullet.remove(i); // delete bullet
					}
				}

			}
		}
		// Player block check
		// Loops through(columns,rows) then checks if passable set to old
		// location
		for (int y = 0; y < room.blocks.length; y++) {
			for (int x = 0; x < room.blocks[0].length; x++) {
				if (player.collison(room.blocks[y][x])
						&& room.blocks[y][x].passable != true) {
					player.x = player.oldx;
					player.y = player.oldy;
				}
			}
		}
		// Player exit check
		// Loops through(columns,rows) then checks if blocks is exit
		for (int y = 0; y < room.blocks.length; y++) {
			for (int x = 0; x < room.blocks[0].length; x++) {
				if (player.collison(room.blocks[y][x])
						&& room.blocks[y][x].id != 0) {
					if (player.y + player.height < 0 || player.y > getHeight()
							|| player.x + player.width < 0
							|| player.x > getWidth()) {
						// if outside the frame the check which room goto
						whichroom(room.blocks[y][x].id, room.ID, y, x);
					}
				}
			}
		}
		for (int y = 0; y < room.layer2.length; y++) {
			for (int x = 0; x < room.layer2[0].length; x++) {
				if (player.collison(room.layer2[y][x])
						&& room.layer2[y][x].id == 1 && player.interact && player.coin >= 10) {
					player.coin -= 10;
				    player.items.effectRand();
					
				}
			}
		}
	}

	/**
	 * monster collsion checks
	 * 
	 * @param bullet
	 */
	private void checkmobs(ArrayList<Bullet> bullet) {
		if (spawner != null) {
			ArrayList<Monster> monster = spawner.getmobs();
			// monster and players
			for (int i = 0; i < monster.size(); i++) {
				if (monster.get(i).collison(player) && room.ID == "monster") {
					player.health -= monster.get(i).damage;
					// monster.remove(i);
				}
			}
			// monster and bullets
			for (int x = 0; x < monster.size(); x++) {
				for (int i = 0; i < bullet.size(); i++) {
					if (bullet.get(i).collison(monster.get(x))) {
						System.out.println(monster.get(x).health -= bullet
								.get(i).damage);
						monster.get(x).health -= bullet.get(i).damage;
						// monster.remove(x); //bug
						bullet.remove(i);
					}
				}

			}
			// monster and walls
			for (int y = 0; y < room.blocks.length; y++) {
				for (int x = 0; x < room.blocks[0].length; x++) {
					for (int i = 0; i < monster.size(); i++) {
						if (monster.get(i).collison(room.blocks[y][x])
								&& room.blocks[y][x].passable == false) {
							monster.get(i).x = monster.get(i).oldx;
							monster.get(i).y = monster.get(i).oldy;

						}
					}

				}
			}
			// monster and monsters
			if (true) {
				for (int i2 = 0; i2 < monster.size(); i2++) {
					for (int i = 0; i < monster.size(); i++) {
						if (monster.get(i).collison(monster.get(i2)) && i2 != i) {
							monster.get(i).x = monster.get(i).oldx;
							monster.get(i).y = monster.get(i).oldy;
							monster.get(i2).x = monster.get(i2).oldx;
							monster.get(i2).y = monster.get(i2).oldy;

						}
					}
				}

			}
			checkHP(monster);
		}

	}

	/**
	 * gets blockID and room to switch rooms then gets the players current y and
	 * x position, to set them on the proper side of the room
	 * 
	 * @param currentid
	 * @param roomID
	 * @param blocky
	 * @param blockx
	 */
	private void whichroom(int currentid, String roomID, int blocky, int blockx) {
		if (currentid == 3) {
			if (roomID == "spawn") {
				if (spawnfirst) {
					spawner = new Spawner(this); // if first time entering
													// monster room then initial
													// spawn class
					spawnfirst = false;
				}
				System.out.println(roomID);
				loadRoom("monster.txt");
				room.ID = "monster";
				player.y = room.blocks[9][blockx].y;
			} else if (roomID == "monster") {
				System.out.println(roomID);
				loadRoom("test.txt");
				room.ID = "spawn";
				player.y = room.blocks[0][blockx].y;
			}
		}
		if (currentid == 2) {
			if (roomID == "spawn") {
				System.out.println(roomID);
				loadRoom("right.txt");
				room.ID = "right";
				System.out.println(blockx);
				player.x = room.blocks[blocky][0].x;
			} else if (roomID == "right") {
				System.out.println(roomID);
				loadRoom("test.txt");
				room.ID = "spawn";
				player.x = room.blocks[blocky][15].x;
			}
		}
		if (currentid == 5) {
			if (roomID == "spawn") {
				System.out.println(roomID);
				loadRoom("left.txt");
				room.ID = "left";
				System.out.println(blockx);
				player.x = room.blocks[blocky][15].x;
			} else if (roomID == "left") {
				System.out.println(roomID);
				loadRoom("test.txt");
				room.ID = "spawn";
				player.x = room.blocks[blocky][0].x;
			}
		}
		if (currentid == 4) {
			if (roomID == "spawn") {
				System.out.println(roomID);
				loadRoom("down.txt");
				room.ID = "down";
				player.y = room.blocks[0][blockx].y;
			} else if (roomID == "down") {
				System.out.println(roomID);
				loadRoom("test.txt");
				room.ID = "spawn";
				player.y = room.blocks[9][blockx].y;
			}
		}

	}

	/**
	 * checks all monster health then remove hp > 0 ones. +coins are given to
	 * player
	 * Player health + highscore added
	 * @param monster
	 */
	private void checkHP(ArrayList<Monster> monster) {
		if (player.health < 0 && !player.dead) {
			highscore.add(player.countsec, player.name);
			player.dead = true;

		}
		for (int i = 0; i < monster.size(); i++) {
			if (monster.get(i).health <= 0) {
				player.coin += monster.get(i).randCoin();
				 monster.remove(i);
			}
		}

	}

	/**
	 * The game loop(Thread)
	 */
	public void run() {
		while (true) {
			if (isFirst) {
				loadRoom("test.txt"); // First run needs to read room before
										// updating
				isFirst = false;
			} else if (runGame) {
				update(); // update
				checkC(); // check collision
				repaint(); // render
				if(reset){
					isFirst = true;
					define();
					spawnfirst = true;
					reset = false;
				}
			}
			try {
				Thread.sleep(1000 / 60);// 1000/60 = 60fps
			} catch (Exception e) {

			}

		}

	}

	/**
	 * File loader turns string into a file to be read in levelload
	 */
	private void loadRoom(String path) {
		String url = Pic.class.getResource(path).getFile();
		File file = new File(url);
		levelLoad.loadSave(file);
	}

	/**
	 * File loader turns string into a file to be read in levelload
	 */
	private void update() {
		if (spawner != null) {
			spawner.monMove(); // only run if spawner is on
		}
		player.bulletMove();
		player.physic();
	}

}
