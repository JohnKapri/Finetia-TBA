package johnkapri.game.input.action;

import johnkapri.game.display.Display;

public abstract class Action {

	public static Action[] actions = new Action[1024];
	public static final ActionVoid actionVoid = new ActionVoid(0, "");
	public static final ActionHelp actionHelp = new ActionHelp(1, "help");
	public static final ActionExit actionExit = new ActionExit(2, "exit");
	public static final ActionMove actionMove = new ActionMove(3, "move");
	public static final ActionWhereAmI actionWhereAmI = new ActionWhereAmI(4, "whereami");
	
	int id;
	String command;
	
	public Action(int id, String command) {
		if(actions[id] != null) {
			throw new IllegalArgumentException("Duplicant action ID at " + id + " with " + actions[id].toString() + " and " + this.toString());
		} else {
			actions[id] = this;
			this.id = id;
			this.command = command;
		}
	}
		
	public static Action getAction(String command) {
		String input = new StringBuilder().append(command).toString();
		for(Action a : Action.actions) {
			if(a != null && input.equalsIgnoreCase(a.command)) {
				return a;
			}
		}
		return Action.actionVoid;
	}
	
	public abstract boolean performed(ActionHandler act, String[] args);
	
	public abstract boolean printHelp(Display display);
}
