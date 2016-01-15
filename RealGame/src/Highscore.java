import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

import resources.Pic;

public class Highscore {
	Screen screen;
	public boolean hide = true;
	public static int[] highScore = new int[10];
	public static String[] highScoreName = new String[10];
	public static boolean first = true;
	public File file;

	public Highscore(Screen screen) {
		this.screen = screen;
		String url = Pic.class.getResource("high.txt").getFile();
		file = new File(url);
		loadhigh(file);
	}

	public void draw(Graphics g) {
		g.drawString("HighScore", 500, 30);
		for (int i = 0; i < highScore.length; i++) {
			g.drawString(highScoreName[i], 500, 50 + (i * 20));
			g.drawString(String.valueOf(highScore[i]), 700, 50 + (i * 20));
		}
		g.drawImage(BlcImages.backpanel, 490, 10, 250, 300, null);

	}

	public void loadhigh(File path) {
		try {
			Scanner loadScanner = new Scanner(path);
			while (loadScanner.hasNext()) {
				for (int i = 0; i < highScoreName.length; i++) {
					highScoreName[i] = loadScanner.next();
				    highScore[i] = loadScanner.nextInt();
				}
			}
			loadScanner.close();
		} catch (Exception e) {
		}
	}

	  public void saveHigh() throws Exception {
		    FileWriter fw = new FileWriter(file);

		    for (int i = 0; i < highScore.length; i++) {
		      fw.write(highScoreName[i] + "\n" + highScore);
		      System.out.println("asdfasdf");
		    }
		    fw.close();
		  }
		

	public void add(int countsec, String name) {
		if (countsec >= highScore[highScore.length - 1]) {
			highScore[highScore.length - 1] = countsec;
			highScoreName[highScoreName.length - 1] = name;
			sort();

		}
	}

	public void sort() {
		for (int a = 0; a < highScore.length - 1; a++) {
			for (int i = 0; i < highScore.length - 1; i++) {
				if (highScore[i] < highScore[i + 1]) {
					String tempS = highScoreName[i];
					int temp = highScore[i];
					highScore[i] = highScore[i + 1];
					highScoreName[i] = highScoreName[i + 1];
					highScore[i + 1] = temp;
					highScoreName[i + 1] = tempS;
				}
			}

		}
		try {
		//	saveHigh();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void print() {
		for (int i = 1; i < highScore.length; i++) {
			System.out.println(highScore[i]);
		}
	}

}
