package johnkapri.game.input;

import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import johnkapri.game.Game;
import johnkapri.game.InputListener.ConsoleListener;
import johnkapri.game.display.Display;

public class InputHandler implements KeyListener, FocusListener, ConsoleListener{

	public boolean[] keys = new boolean[65536];
	private Display display;
	private Game game;
	
	private String input;
	
	public InputHandler(Game game, Display display) {
		this.display = display;
		this.game = game;
		game.listener.addListener(this);
	}

	public void keyTyped(KeyEvent e) {
		if(keys[KeyEvent.VK_CONTROL]) {
			if(e.getKeyCode() == KeyEvent.VK_S) {
				game.saveGame();
			}
		}
		if(e.getKeyCode() == KeyEvent.VK_ESCAPE) {
			game.exitGame();
		}
	}
	
	/*public String getInput() {
		input = null;
		while(input == null) {
			try {
				Thread.sleep(20L);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		return input;
		return game.listener.getInput();
	}*/
	
	/*public boolean yesNo() {
		String in = getInput();
		if(in.equalsIgnoreCase("y") || in.equalsIgnoreCase("yes")) {
			return true;
		} else if(in.equalsIgnoreCase("n") || in.equalsIgnoreCase("no")) {
			return false;
		} else {
			display.addText("Invalid input! Only 'yes' or 'no' allowed! Try again...");
			return yesNo();
		}
	}*/

	public void keyPressed(KeyEvent e) {
		int code = e.getKeyCode();
		if (code > 0 && code < keys.length) {
			keys[code] = true;
		}
	}

	public void keyReleased(KeyEvent e) {
		int code = e.getKeyCode();
		if (code > 0 && code < keys.length) {
			keys[code] = false;
		}
	}

	public void focusGained(FocusEvent e) {
		
	}

	public void focusLost(FocusEvent e) {
		for(int i = 0; i < keys.length; i++) {
			keys[i] = false;
		}
	}

	public void consoleInput(String input) {
		this.input = input;
	}
}
