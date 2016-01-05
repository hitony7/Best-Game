import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.Timer;

public class Spawner implements ActionListener {
	public Timer spawninterval;
	public ArrayList<Monster> mobs;
	
	public Spawner(){
		 spawninterval = new Timer(1000, this);
		 spawninterval.start();
		 mobs = new ArrayList<Monster>();
	}
	
	
	public void draw(Graphics g) {
		for (int i = 0; i < mobs.size(); i++) { // loop
			mobs.get(i).draw(g); // for every monster
		}
     }
	public void monMove(){
		for (int i = 0; i < mobs.size(); i++) {
			mobs.get(i).move();
		}	
	}
	
	public ArrayList<Monster> getmobs() {
		return mobs;
	}


	@Override
	public void actionPerformed(ActionEvent e) {
		System.out.println("newthing");
		mobs.add(new Monster(550, 60, 100, 100, 1));
		
	}
	
}
