import java.io.File;
import java.net.URL;
import java.util.Random;
import java.util.Scanner;



public class LevelLoad {
	Screen screen;

	public LevelLoad(Screen screen) {
		this.screen = screen;
	}

	public void loadSave(File path) {
		try {
			Scanner loadScanner = new Scanner(path);
			
			while (loadScanner.hasNext()) {
				System.out.println("fileloaded");
				for(int y=0;y<screen.room.blocks.length;y++) {
					for(int x=0;x<screen.room.blocks[0] .length;x++) {
						screen.room.blocks[y][x].id = loadScanner.nextInt();
					
						
					}
				}
			}
			
			loadScanner.close();
		} catch(Exception e) { }
	}
}