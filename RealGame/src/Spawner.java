import java.awt.event.ActionListener;

import javax.swing.Timer;

public class Spawner {
	public Timer spawninterval;
	
	public Spawner(){
		 spawninterval = new Timer(1000 / 60, (ActionListener) this);
	}
	
		

}
