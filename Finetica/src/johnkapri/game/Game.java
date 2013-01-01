package johnkapri.game;

import johnkapri.game.display.Display;
import johnkapri.game.gameobjects.Player;
import johnkapri.game.input.action.ActionHandler;
import johnkapri.game.world.World;

public class Game {

	public InputListener listener;
	private Display display;
	private World world;
	private Player player;
	private ActionHandler action;
	
	public Game(InputListener listener) {
		this.listener = listener;
		display = new Display();
		//input = new InputHandler(this, display);
	}
	
	private void init() {
		world = new World();
		display.addText("######### F I N E T I C A ##########\r\n");
		display.addText("Welcome to Finetica, the text-based open world adventure game. You play the game by typing in what you want to do. Use 'help' to get a list of commands!\r\n");
		display.addText("But first select a playername! Type it in, then press ENTER.\r\n");
		player = new Player(world, listener.getInput());
		display.addText("Very well, " + player.getName() + ", do you wish to start now? Y/N\r\n");
		if(!listener.yesNo(display)) {
			exitGame();
		}
		display.addText("You wake up. Your left arm hurts because you lay on it while you where sleeping on the ground. You stand up and look around.\r\n");
		display.addText(player.lookAround());
		action = new ActionHandler(this, display, world, player, listener);		
		listener.start();
	}

	public void saveGame() {
		
	}
	
	public void exitGame() {
		listener.stop();
		display.dispose();
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		InputListener listener = new InputListener();
		Game game = new Game(listener);
		game.init();
	}
}
