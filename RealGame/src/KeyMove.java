import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyMove implements KeyListener {

	Screen screen;

	public KeyMove(Screen screen) {
		this.screen = screen;
	}

	@Override
	public void keyPressed(KeyEvent e) {
		//
		if (e.getKeyCode() == KeyEvent.VK_Q) {
			screen.player.interact = true;
		}
		// Player move direction
		if (e.getKeyCode() == KeyEvent.VK_UP) {
			screen.player.pUP = true;
		}
		if (e.getKeyCode() == KeyEvent.VK_DOWN) {
			screen.player.pDOWN = true;
		}
		if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
			screen.player.pRIGHT = true;
		}
		if (e.getKeyCode() == KeyEvent.VK_LEFT) {
			screen.player.pLEFT = true;
		}
		// Player shoot direction
		if (e.getKeyCode() == KeyEvent.VK_W) {
			screen.player.fUP = true;
		}
		if (e.getKeyCode() == KeyEvent.VK_S) {
			screen.player.fDOWN = true;
		}
		if (e.getKeyCode() == KeyEvent.VK_D) {
			screen.player.fRIGHT = true;
		}
		if (e.getKeyCode() == KeyEvent.VK_A) {
			screen.player.fLEFT = true;
		}
		// trouble shooting
		if (e.getKeyCode() == KeyEvent.VK_E) {
			for (int i = 0; i < screen.room.blocks.length; i++) {
				for (Block block : screen.room.blocks[i]) {
					// System.out.println(block.id);
				}
			}
		}

	}

	@Override
	public void keyReleased(KeyEvent e) {
		// Player move direction set false
		if (e.getKeyCode() == KeyEvent.VK_UP) {
			screen.player.pUP = false;
		}
		if (e.getKeyCode() == KeyEvent.VK_DOWN) {
			screen.player.pDOWN = false;
		}
		if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
			screen.player.pRIGHT = false;
		}
		if (e.getKeyCode() == KeyEvent.VK_LEFT) {
			screen.player.pLEFT = false;
		}
		// Player shoot direction set false
		if (e.getKeyCode() == KeyEvent.VK_W) {
			screen.player.fUP = false;
		}
		if (e.getKeyCode() == KeyEvent.VK_S) {
			screen.player.fDOWN = false;
		}
		if (e.getKeyCode() == KeyEvent.VK_D) {
			screen.player.fRIGHT = false;
		}
		if (e.getKeyCode() == KeyEvent.VK_A) {
			screen.player.fLEFT = false;
		}
		if (e.getKeyCode() == KeyEvent.VK_Q) {
			screen.player.interact = false;
		}

	}

	@Override
	public void keyTyped(KeyEvent arg0) {

	}

}