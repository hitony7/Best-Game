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
		System.out.println("work");
		try {
			Scanner scanner = new Scanner(path);
			
			scanner.close();
			System.out.println("fileloaded");
		} catch (Exception e) {
		}
	}
}