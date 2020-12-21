package spaceGame;


import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;

import javax.swing.*;

public class Space_frame extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	Space_canvas canvas = new Space_canvas();
	
	public Space_frame() {
		
		add(canvas);
		addKeyListener(new KeyAdapter() {
			
			public void keyPressed(KeyEvent e) {
				switch(e.getKeyCode()) {
				
				case KeyEvent.VK_SPACE:
					if (canvas.still_alive()) {
						add_laser();
					}
					break;
				}
			}
		});
		
		addMouseMotionListener(new MouseMotionAdapter(){
			public void mouseMoved(MouseEvent e) {
				if (canvas.still_alive()) {
					canvas.set_ship_x(e.getX() - 8);
					repaint();
				}
			}
		});
		
		addMouseListener(new MouseAdapter() {
		    public void mouseClicked(MouseEvent e) {
		    		if (canvas.still_alive()) {
		    			add_laser();
		    		}
		    }
		});
		
	}
	
	public void add_laser() {
		canvas.add_laser();
	}
	
	public boolean close_out() {
		return canvas.close_out();
	}
	
	
}