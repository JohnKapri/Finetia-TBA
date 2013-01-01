package johnkapri.game.input.action;

import johnkapri.game.display.Display;
import johnkapri.game.world.World;

public class ActionMove extends Action {

	public ActionMove(int id, String command) {
		super(id, command);
	}

	public boolean performed(ActionHandler act, String[] args) {
		if (args.length > 1) {
			return false;
		}
		for (World.Direction dir : World.Direction.values()) {
			if (args[0].equalsIgnoreCase(dir.name())) {
				if (act.getPlayer().go(dir)) {
					act.getDisplay().addText(act.getPlayer().lookAround());
					return true;
				}
			}
		}
		return false;
	}

	public boolean printHelp(Display display) {
		display.addText("move [direction]:\r\n--Moves the player in the specified direction. Directions may be 'NORTH', 'SOUTH', 'WEST' or 'EAST'.\r\n");
		return true;
	}
}
