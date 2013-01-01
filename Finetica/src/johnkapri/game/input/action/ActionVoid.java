package johnkapri.game.input.action;

import johnkapri.game.display.Display;

public class ActionVoid extends Action {

	public ActionVoid(int id, String command) {
		super(id, command);
	}

	public boolean performed(ActionHandler act, String[] args) {
		return true;
	}

	public boolean printHelp(Display display) {
		return true;
	}
}
