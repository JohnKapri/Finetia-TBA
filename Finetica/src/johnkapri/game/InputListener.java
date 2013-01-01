package johnkapri.game;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import johnkapri.game.display.Display;

public class InputListener implements Runnable {

	boolean running;
	List<ConsoleListener> listener = new ArrayList<ConsoleListener>();
	BufferedReader reader;
	String input;
	boolean request;

	public InputListener() {
		reader = new BufferedReader(new InputStreamReader(System.in));
	}

	public void start() {
		Thread t = new Thread(this);
		running = true;
		t.start();
	}

	public void stop() {
		running = false;
	}

	public String getInput() {
		if (running) {
			request = true;
			input = null;
			while (input == null) {
				try {
					Thread.sleep(20L);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
			request = false;
			return input;
		} else {
			try {
				return reader.readLine();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return null;
	}

	public boolean yesNo(Display display) {
		String in = getInput();
		if (in.equalsIgnoreCase("y") || in.equalsIgnoreCase("yes")) {
			return true;
		} else if (in.equalsIgnoreCase("n") || in.equalsIgnoreCase("no")) {
			return false;
		} else {
			display.addText("Invalid input! Only 'yes' or 'no' allowed! Try again...");
			return yesNo(display);
		}
	}

	public void run() {
		String in;
		while (running) {
			try {
				in = reader.readLine();
				if (in != null) {
					if (request) {
						input = in;
					} else {
						for (ConsoleListener l : listener) {
							l.consoleInput(in);
						}
					}
				}
				in = null;
				try {
					Thread.sleep(15L);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	public void addListener(ConsoleListener listener) {
		this.listener.add(listener);
	}

	public void removeListener(ConsoleListener listener) {
		this.listener.remove(listener);
	}

	public interface ConsoleListener {
		public abstract void consoleInput(String input);
	}
}
