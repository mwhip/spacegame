package spaceGame;

import javax.swing.JFrame;

public class Asteroids {

	public static void main(String[] args) {
		Space_frame frame = new Space_frame();
		frame.setTitle("Asteroids");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(500, 700);
		frame.setVisible(true);
		frame.setLocation(400, 100);
		
	}

}

