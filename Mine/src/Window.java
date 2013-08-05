import java.awt.Dimension;

import javax.swing.JFrame;


public class Window extends JFrame {
	public static map map = new map(new Dimension(40,40));
	private Dimension size = new Dimension(600, 600);
	private myPanel panel = new myPanel(size);
	
	Window(){
		
		this.setTitle("Mining game");
		this.setSize(size);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setUndecorated(true);
		this.setContentPane(panel);
		panel.requestFocus();
		this.setVisible(true);
	}
	public void Focus(){
		this.panel.requestFocus();
	}
	
	public static void main(String[] args){
		System.out.println("test");
		Window window = new Window();
		window.Focus();
	}
}

