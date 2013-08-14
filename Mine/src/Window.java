import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;


@SuppressWarnings("serial")
public class Window extends JFrame {
	public static myPanel panel;
	Window(Dimension size){
		this.setTitle("Mining game");
		this.setSize(size);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		panel = new myPanel(size);
		this.setUndecorated(true);
		this.setContentPane(panel);
		this.setVisible(true);
		
		
		this.addWindowFocusListener(new WindowAdapter() {
			public void windowGainedFocus(WindowEvent e) {
				panel.requestFocus();
				panel.requestFocusInWindow();
			}
		});
		
	}
	
	
	class myPanel extends JPanel implements ActionListener{
		Point viewPos = new Point(), playerPos = new Point(), dview = new Point(), dplayer = new Point();
		BufferedImage view;
		Graphics2D g2;
		Dimension size;
		ArrayList<Integer> keys = new ArrayList<Integer>();
		Timer timer = new Timer(20, this);
		int movCount=-1, movx=0, movy = 0, increment = 5;
		boolean edge= false;
		public myPanel(Dimension newPanelSize){
			
			this.size = new Dimension(newPanelSize.width/map.TileSize, newPanelSize.height/map.TileSize);
			view = new BufferedImage((this.size.width+2)*map.TileSize, (this.size.height+2)*map.TileSize, BufferedImage.TYPE_INT_RGB);
			g2 = view.createGraphics();
			
			this.addKeyListener(new KeyListener() {
				public void keyTyped(KeyEvent e) {
				}
				public void keyReleased(KeyEvent e) {
					keys.remove((Object)e.getKeyCode());
				}
				public void keyPressed(KeyEvent e) {
					if(!keys.contains(e.getKeyCode())){
						keys.add(e.getKeyCode());
						timer.start();
					}
					if(e.getKeyCode()==KeyEvent.VK_ESCAPE)System.exit(0);
				}
			});
			timer.setInitialDelay(0);
		}
		
		public void paintComponent(Graphics g){
			for(int i = viewPos.y -1, y=0; i <= viewPos.y + size.height; i++, y+=map.TileSize){
				for(int j = viewPos.x -1, x=0; j <= viewPos.x + size.width; j++, x+=map.TileSize){
					g2.drawImage(map.getTile(j, i), x + dview.x, y+ dview.y, null);
				}
			}
			g.drawImage(view, -map.TileSize, -map.TileSize, null);
			g.setColor(Color.red);
			g.fillOval((playerPos.x-viewPos.x)*map.TileSize + dplayer.x, (playerPos.y-viewPos.y)*map.TileSize + dplayer.y, map.TileSize, map.TileSize);
		}
		
		public void refresh(Point pos, Point player){
			playerPos.setLocation(player);
			viewPos.setLocation(pos);
			repaint();
		}
		
		public void move(Point pos, Point player, int dx, int dy, boolean edge){
			this.edge = edge;
			viewPos.setLocation(pos);
			playerPos.setLocation(player);
			dview.setLocation(0,0);
			dplayer.setLocation(0,0);
			movx=dx;
			movy=dy;
			movCount=0;
			repaint();
		}
		
		public void actionPerformed(ActionEvent e){
			if (movCount>=0){
				if(edge)
					dplayer.translate(movx*increment, movy*increment);
				else
					dview.translate(-movx*increment, -movy*increment);
				movCount+=increment;
				if(movCount>=map.TileSize)movCount=-1;
				repaint();
				return;
			}
			for(Integer k:keys){
				switch (k) {
				case KeyEvent.VK_RIGHT:
					game.playerMove(game.player,1, 0);
					return;
				case KeyEvent.VK_LEFT:
					game.playerMove(game.player,-1, 0);
					return;
				case KeyEvent.VK_UP:
					game.playerMove(game.player,0, -1);
					return;
				case KeyEvent.VK_DOWN:
					game.playerMove(game.player,0, 1);
					return;
				}
			}
			timer.stop();
		}
		
	}
}

