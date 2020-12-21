package spaceGame;

import java.awt.*;

public class Spaceship{
	int x = 250;
	int y = 600;
	int height = 30;
	int width = 16;
	Color gray = Color.decode("#E8E5DB");
	Color blue = Color.decode("#64C2C2");
	
	public void draw_ship(Graphics g) {
		int[] x_coords_1 = {x + 1, x + 1, x - (width + 1)};
		int[] y_coords_1 = {y, y + height, y + height};
		
		int[] x_coords_2 = {x + (width - 1), x + (width - 1), x + (width * 2)};
		int[] y_coords_2 = {y, y + height, y + height};
		
		
		g.setColor(gray);
		g.fillOval(x, y, width, height);
		g.fillPolygon(x_coords_1, y_coords_1, 3);
		g.fillPolygon(x_coords_2, y_coords_2, 3);
		
		g.setColor(blue);
		g.drawPolygon(x_coords_1, y_coords_1, 3);
		g.drawPolygon(x_coords_2, y_coords_2, 3);
		g.fillOval(x + 4, y + 5 , width / 2, height / 2);
		
		g.setColor(gray);
		g.fillRect(x + 4, y + 15, 8, 10);
	}
	
	public void move_x(int x2) {
		x += x2;
	}
	
	public int get_x() {
		return x;
	}
	
	public void set_x(int x2) {
		x = x2;
	}

}

