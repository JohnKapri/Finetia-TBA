package johnkapri.game.input.action;

import johnkapri.game.Game;
import johnkapri.game.InputListener;
import johnkapri.game.InputListener.ConsoleListener;
import johnkapri.game.display.Display;
import johnkapri.game.gameobjects.Player;
import johnkapri.game.world.World;

public class ActionHandler implements ConsoleListener {

	private Game game;
	private Display display;
	private World world;
	private Player player;
	private InputListener input;

	public ActionHandler(Game game, Display display, World world,
			Player player, InputListener input) {
		this.game = game;
		this.display = display;
		this.world = world;
		this.player = player;
		this.input = input;
		game.listener.addListener(this);
	}

	public Game getGame() {
		return game;
	}

	public Display getDisplay() {
		return display;
	}

	public World getWorld() {
		return world;
	}

	public Player getPlayer() {
		return player;
	}

	public InputListener getInputListener() {
		return input;
	}

	public void actionCalled(String string) {
		String[] buffer = string.split(" ");
		String[] args = null;
		if (buffer.length > 1) {
			args = new String[buffer.length - 1];
			for (int i = 1; i < buffer.length; i++) {
				args[i - 1] = buffer[i];
			}
		}
		if (!Action.getAction(buffer[0]).performed(this, args)) {
			display.addText("Command '" + buffer[0] + "' is unknown! Try 'help'...");
		}
	}

	public void consoleInput(String input) {
		actionCalled(input);
	}
}
