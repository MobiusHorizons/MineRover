import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

import javax.swing.JPanel;
import javax.swing.Timer;

//@SuppressWarnings("serial")
//public class myPanel extends JPanel implements ActionListener{
//	Point viewPos = new Point(1,1);
//	BufferedImage view;
//	Graphics2D g2;
//	Dimension panelSize;
//	ArrayList<Integer> keys = new ArrayList<Integer>();
//	public myPanel(Dimension newPanelSize){
//		this.panelSize = new Dimension(newPanelSize.width/map.TileSize, newPanelSize.height/map.TileSize);
//		view = new BufferedImage((this.panelSize.width+2)*map.TileSize, (this.panelSize.height+2)*map.TileSize, BufferedImage.TYPE_INT_RGB);
//		g2 = view.createGraphics();
//		
//		this.addKeyListener(new KeyListener() {
//			public void keyTyped(KeyEvent e) {
//			}
//			public void keyReleased(KeyEvent e) {
//				keys.remove((Object)e.getKeyCode());
//				System.out.println(e.isActionKey());
//			}
//			public void keyPressed(KeyEvent e) {
//				if(!keys.contains(e.getKeyCode()))keys.add(e.getKeyCode());
//				if(e.getKeyCode()==KeyEvent.VK_ESCAPE)System.exit(0);
//			}
//		});
//		Timer timer = new Timer(50, this);
//		timer.setInitialDelay(500);
//		timer.start();
//	}
//	
//	public void paintComponent(Graphics g){
//		for(int i = viewPos.y -1, y=0; i < viewPos.y + panelSize.height; i++, y+=map.TileSize){
//			for(int j = viewPos.x -1, x=0; j < viewPos.x + panelSize.width; j++, x+=map.TileSize){
//				g2.drawImage(game.map.getTile(j, i), x, y, null);
//			}
//		}
//		g.drawImage(view, -map.TileSize, -map.TileSize, null);
//	}
//	
//	public void actionPerformed(ActionEvent e){
//		for(Integer k:keys){
//			switch (k) {
//			case KeyEvent.VK_RIGHT:
//				
////				viewPos.x += (viewPos.x + panelSize.width < map.size.width)? 1:0;
////				repaint();
//				return;
//			case KeyEvent.VK_LEFT:
////				viewPos.x -= (viewPos.x > 0)? 1:0;
////				repaint();
//				return;
//			case KeyEvent.VK_UP:
////				viewPos.y -= (viewPos.y > 0)? 1:0;
////				repaint();
//				return;
//			case KeyEvent.VK_DOWN:
////				viewPos.y += (viewPos.y + panelSize.height < map.size.height)? 1:0;
////				repaint();
//				return;
//			}
//		}
//	}
//	
//}
