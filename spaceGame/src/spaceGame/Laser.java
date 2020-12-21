package spaceGame;


import java.awt.*;

public class Laser{
	int x;
	int y = 560;
	int size1 = 2;
	int size2 = 35;
	
	public void draw_laser(Graphics g) {
		g.setColor(Color.RED);
		g.fillRect(x, y, size1, size2);}
	
	public int get_top() {
		return x - 1;
	}
	
	public void set_x(int x2) {
		x = x2;
	}

	public int get_y() {
		// TODO Auto-generated method stub
		return y;
	}
	public void shift_laser() {
		// TODO Auto-generated method stub
		y-= 2;
		
	}

}
