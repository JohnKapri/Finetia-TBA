package johnkapri.game.input.action;

import johnkapri.game.display.Display;

public class ActionWhereAmI extends Action{

	public ActionWhereAmI(int id, String command) {
		super(id, command);
	}

	public boolean performed(ActionHandler act, String[] args) {
		act.getDisplay().addText("You are at x: " + act.getPlayer().getX() + ", y: " + act.getPlayer().getY()+"\r\n");
		return true;
	}

	public boolean printHelp(Display display) {
		display.addText("whereami:\r\n--Prints the current coordinates in the world.\r\n");
		return true;
	}

}
