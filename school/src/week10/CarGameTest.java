package week10;

import javax.swing.JFrame;

public class CarGameTest extends JFrame{

	public CarGameTest() {
		setSize(300, 300);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		add(new MyPanel());
		setVisible(true);
	}
	
	public static void main(String[] args) {
		CarGameTest s= new CarGameTest();
	}
}
