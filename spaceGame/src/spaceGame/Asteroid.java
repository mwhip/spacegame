package spaceGame;

import java.awt.*;
import javax.swing.*;
import java.util.Random;

public class Asteroid extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	Random rand = new Random();
	int speed = 2;
	
	int x = rand.nextInt(480);
	int y = 10;
	int size = rand.nextInt(10) + 40;
	int size_1 = size / 3;
	int size_2 = size / 5;
	int size_3 = size / 7;
	Color grey = Color.decode("#696562");
	Color dark_grey = Color.decode("#2b2926");
	
	public void draw_asteroid(Graphics g) {
		g.setColor(grey);
		g.fillOval(x, y, size, size);
		
		g.setColor(dark_grey);
		g.fillOval(x + 7, y + 10, size_1, size_1);
		g.fillOval(x + 25,  y + 25, size_2, size_2);
		g.fillOval(x + 30, y + 6, size_3, size_3);
		
		g.setColor(Color.BLACK);
		g.drawOval(x, y, size, size);
		g.drawOval(x + 7, y + 10, size_1, size_1);
		g.drawOval(x + 25,  y + 25, size_2, size_2);
		g.drawOval(x + 30, y + 6, size_3, size_3);
		
	}
	
	public void set_y(int y2) {
		y += y2;
	}
	
	public int get_y() {
		return y;
	}
	
	public void shift_asteroid() {
		set_y(speed);
	}
	
	public int get_center_x() {
		return x + (size / 2);
	}
	
	public int get_center_y() {
		return y + (size / 2);
	}
	
	public int get_size() {
		return size;
	}
	
	
}
