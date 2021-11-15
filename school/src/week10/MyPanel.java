package week10;

import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class MyPanel extends JPanel {
	
	BufferedImage img = null;
	int img_x = 100, img_y = 100;
	
	public MyPanel() {
		
		try {
			img = ImageIO.read(new File ("img/car.gif"));
		}catch(IOException e) {
			System.out.println("no image");
			System.exit(1);
		}
		
		addMouseListener(new MouseListener() {
			
			@Override
			public void mouseReleased(MouseEvent e) {}
			
			@Override
			public void mousePressed(MouseEvent e) {
				img_x = e.getX();
				img_y = e.getY();
				repaint();
				
			}
			
			public void mouseExited(MouseEvent e) {}
			public void mouseEntered(MouseEvent e) {}
			public void mouseClicked(MouseEvent e) {}	
		});
	}
	
	
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.drawImage(img, img_x, img_y, null);
	}

}
