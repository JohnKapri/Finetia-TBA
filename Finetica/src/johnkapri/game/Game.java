package johnkapri.game;

import johnkapri.game.display.Display;

public class Game {

	private Display display;

	public Game() {
		display = new Display();
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Game game = new Game();
	}

}
