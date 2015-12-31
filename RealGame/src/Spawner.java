import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Timer;

public class Spawner implements ActionListener {
	public Timer spawninterval;
	
	public Spawner(){
		 spawninterval = new Timer(1000 / 60, this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
	
}
