package johnkapri.game.display;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.FontFormatException;
import java.awt.TextArea;
import java.io.Console;
import java.io.File;
import java.io.IOException;

import javax.swing.JFrame;

import johnkapri.game.Game;
import johnkapri.game.world.RegionType;

public class Display extends JFrame {

	public static final int WIDTH = 600;
	public static final int HEIGHT = WIDTH / 4 * 3;
	
	Console con;
	TextArea out;
	TextArea in;
	Font font;
	
	public Display () {
		setMinimumSize(new Dimension(WIDTH, HEIGHT));
		setMaximumSize(new Dimension(WIDTH, HEIGHT));
		setPreferredSize(new Dimension(WIDTH, HEIGHT));

		this.setName("Finetica");

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout(new BorderLayout());
		
		//font = new Font("Papyrus", Font.BOLD, 20);
		try {
			font = Font.createFont(Font.TYPE1_FONT, Game.class.getResourceAsStream("/res/font1.ttf"));
		} catch (FontFormatException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		out = new TextArea("", 10, 50, TextArea.SCROLLBARS_NONE);
		out.setFont(font);
		out.setEditable(false);
		out.setFocusable(false);
		in = new TextArea();
		in.setPreferredSize(new Dimension(WIDTH, 24));
		add(out, BorderLayout.CENTER);
		add(in, BorderLayout.SOUTH);
		pack();

		setResizable(false);
		setLocationRelativeTo(null);
		setVisible(true);
		requestFocus();
		
		for(int i = 0; i < RegionType.values().length; i++) {
			out.append("---" + RegionType.values()[i].getName() + ": \r\n");
			out.append(RegionType.getDesc(RegionType.values()[i]) + "\r\n");
		}
	}
	
	private static final long serialVersionUID = 1L;
}
