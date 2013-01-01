package johnkapri.game.input.action;

import johnkapri.game.display.Display;

public class ActionExit extends Action {

	public ActionExit(int id, String command) {
		super(id, command);
	}

	public boolean performed(ActionHandler act, String[] args) {
		act.getDisplay().addText("### Do you really want to quit? Y/N");
		if (act.getInputListener().yesNo(act.getDisplay())) {
			act.getGame().exitGame();
			return true;
		}
		return true;
	}

	public boolean printHelp(Display display) {
		display.addText("exit:\r\n--Exits the game without saving.\r\n");
		return true;
	}

}
