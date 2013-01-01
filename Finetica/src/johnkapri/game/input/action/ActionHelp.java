package johnkapri.game.input.action;

import johnkapri.game.display.Display;

public class ActionHelp extends Action{

	public ActionHelp(int id, String command) {
		super(id, command);
	}

	public boolean performed(ActionHandler act, String[] args) {
		if(args == null) {
			for(Action a : Action.actions) {
				if(a == null) {
					break;
				}
				a.printHelp(act.getDisplay());
			}
		} else {
			Action.getAction(args[0]).printHelp(act.getDisplay());
		}
		return true;
	}

	public boolean printHelp(Display display) {
		display.addText("help:\r\n--Shows this help.\r\n");
		return true;
	}

}
