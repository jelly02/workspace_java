package week10;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;


public class MyFrame extends JFrame{
	
	public MyFrame() {
		add(new MyPanel());
		setSize(300, 500);
		setVisible(true);
	}
	
	public static void main(String[] args) {
		new MyFrame();
	}
}
