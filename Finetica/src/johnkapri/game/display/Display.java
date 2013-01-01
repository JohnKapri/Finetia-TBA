package johnkapri.game.display;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Font;
import java.io.BufferedReader;
import java.io.Console;
import java.io.IOException;
import java.io.InputStreamReader;

import javax.swing.JFrame;

public class Display extends JFrame {

	public static final int WIDTH = 600;
	public static final int HEIGHT = WIDTH / 4 * 3;
	
	Console con;
//	TextArea out;
//	public TextArea in;
	Font font;
	
	public Display () {
		setMinimumSize(new Dimension(WIDTH, HEIGHT));
		setMaximumSize(new Dimension(WIDTH, HEIGHT));
		setPreferredSize(new Dimension(WIDTH, HEIGHT));

		this.setName("Finetica");

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout(new BorderLayout());
		
		//font = new Font("Papyrus", Font.BOLD, 20);
		/*try {
			font = Font.createFont(Font.TYPE1_FONT, Game.class.getResourceAsStream("/res/font1.ttf"));
		} catch (FontFormatException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}*/

		/*out = new TextArea("", 10, 50, TextArea.SCROLLBARS_NONE);
		out.setFont(font);
		out.setEditable(false);
		out.setFocusable(false);
		in = new TextArea();
		in.setPreferredSize(new Dimension(WIDTH, 24));
		in.setEditable(false);
		in.setFocusable(false);
		add(out, BorderLayout.CENTER);
		add(in, BorderLayout.SOUTH);
		pack();

		setResizable(false);
		setLocationRelativeTo(null);
		setVisible(true);
		requestFocus();*/
	}
	
	public String getInput() {
		//return in.getText();
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		try {
			return reader.readLine();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public void addText(String text) {
		//out.append(text);
		System.out.print(text);
	}
	
	private static final long serialVersionUID = 1L;
}
