package spaceGame;

import java.awt.*;
import java.awt.event.*;
import java.util.Random;
import javax.swing.*;
import java.util.ArrayList;

public class Space_canvas extends JPanel{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	Spaceship ship = new Spaceship();
	ArrayList<Asteroid> asteroids = new ArrayList<>();
	ArrayList<Asteroid> old_asteroids = new ArrayList<>();
	ArrayList<Laser> lasers = new ArrayList<>();
	ArrayList<Laser> old_lasers = new ArrayList<>();
	Timer laser_timer;
	Timer ast_timer;
	boolean alive = true;
	int score = 0;
	boolean close = false;
	
	Laser laser = new Laser();
	Random rand = new Random();
	
	public Space_canvas() {
		laser_timer = new Timer(3, new ActionListener() {
          @Override
          public void actionPerformed(ActionEvent e) {
          		
          		for (Laser laser: lasers) {
              		laser.shift_laser();
              		
              		if (laser.get_y() < 1) {
              			old_lasers.add(laser);
              		}
              }
              
              for (Laser laser: lasers) {
      				for (Asteroid asteroid: asteroids) {
      					if (touching(laser, asteroid)) {
      						old_lasers.add(laser);
      						old_asteroids.add(asteroid);
      						score += 1;
      					}
          			
      				}
      			}
              
              for (Laser laser: old_lasers) {
              		lasers.remove(laser);
              }
              
              repaint();
              
          }
      });
		
		ast_timer = new Timer(16, new ActionListener() {
          @Override
          public void actionPerformed(ActionEvent e) {
          		int new_one = rand.nextInt(100);
          		if (new_one % 2 == 0 && new_one % 14 == 0 && new_one % 12 == 0) {
          			asteroids.add(new Asteroid());
          		}
          		
              for (Asteroid asteroid: asteroids) {
                  asteroid.shift_asteroid();
                  if (asteroid.get_y() > 650) {
                  		alive = false;
                  		stop_timer();
                  		end_game(score);
                  }
              }
              
              for (Asteroid asteroid: old_asteroids) {
              		asteroids.remove(asteroid);
              }
              
              repaint();
              
          }
      });
		
      laser_timer.start();
      ast_timer.start();
      
	}
	
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		
		setBackground(Color.BLACK);
		ship.draw_ship(g);
		for (Asteroid asteroid: asteroids) {
			asteroid.draw_asteroid(g);
		}
		for (Laser laser: lasers) {
			laser.draw_laser(g);
		}
		
		repaint();
	}
	
	public void move_ship_x(int x) {
		ship.move_x(x);
	}
	
	public void set_ship_x(int x) {
		ship.set_x(x);
	}
	
	public int get_ship_x() {
		return ship.get_x();
	}
	
	public void add_laser() {
		Laser laser = new Laser();
		laser.set_x(ship.get_x() + 8);
		lasers.add(laser);
	}
	
	public void stop_timer() {
		laser_timer.stop();
		ast_timer.stop();
	}
	
	public boolean still_alive() {
		return alive;
	}
	
	public boolean touching(Laser laser, Asteroid asteroid) {
		boolean touch = false;
		double ast_x = asteroid.get_center_x();
		double ast_y = asteroid.get_center_y();
		double las_x = laser.get_top();
		double las_y = laser.get_y();
		
		double size = asteroid.get_size();
		double ast_left = ast_x - (size / 2);
		double ast_right = ast_x + (size / 2);
		if ((las_x > ast_left && las_x < ast_right)) {
			if (las_y <= ast_y) {
				touch = true;
			}
		}
		
		return touch;
	}
	
	public void end_game(int score) {
		JFrame end_frame = new JFrame();
		
		JButton button = new JButton("EXIT");
		JLabel message = new JLabel("You lost!", SwingConstants.CENTER);
		JLabel your_score = new JLabel("Your score -> " + score, SwingConstants.CENTER);
		
		end_frame.setSize(200, 100);
		end_frame.setTitle("You Lost :P");
		end_frame.setLocation(550, 400);
		
		end_frame.add(button, BorderLayout.SOUTH);
		end_frame.add(message, BorderLayout.NORTH);
		end_frame.add(your_score, BorderLayout.CENTER);
		
		end_frame.repaint();
		
		button.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e)
		    {
		       System.exit(0);
		    }
		});
		
		end_frame.setVisible(true);
	}
	
	public boolean close_out() {
		return close;
	}
	

	
}

