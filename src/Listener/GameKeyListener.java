package Listener;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import settings.Settings;

public class GameKeyListener implements KeyListener {

	public boolean key_w, key_a, key_s, key_d;

	@Override
	public void keyTyped(KeyEvent e) {

	}

	@Override
	public void keyPressed(KeyEvent e) {

		int key = e.getKeyCode();

		if (key == KeyEvent.VK_ESCAPE) { // Spiel beenden
			System.exit(0);
		}
		// Boolean passend zum Key 'true' setzen
		if (key == KeyEvent.VK_W) {
			key_w = true;
		}
		if (key == KeyEvent.VK_A) {
			key_a = true;
		}
		if (key == KeyEvent.VK_S) {
			key_s = true;
		}
		if (key == KeyEvent.VK_D) {
			key_d = true;
		}
		if(key == KeyEvent.VK_T) {
			Settings.DEBUG_MODE = !Settings.DEBUG_MODE;
		}

	}

	@Override
	public void keyReleased(KeyEvent e) {

		int key = e.getKeyCode();

		// Nach Loslassen des Keys passenden Boolean auf 'false' setzen
		
		if (key == KeyEvent.VK_W) {
			key_w = false;
		}
		if (key == KeyEvent.VK_A) {
			key_a = false;
		}
		if (key == KeyEvent.VK_S) {
			key_s = false;
		}
		if (key == KeyEvent.VK_D) {
			key_d = false;
		}
	}

}
