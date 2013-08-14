import java.awt.Dimension;
import java.awt.Point;


public class game {
	
	public static player player = new player(20,20);
	
	private static Point playerPos = new Point(), lastPos = new Point();;
	private static int posX, posY, lastX, lastY;
	private static boolean edge;
	public game(){
		new map(new Dimension(100,100));
		map.dig(player.position);
		
	}
	
	
	public static void refresh(){
		playerPos.setLocation(player.getPosition());
		posX= Math.max(0, Math.min(map.size.width-Window.panel.size.width,playerPos.x-Window.panel.size.width/2));
		posY= Math.max(0, Math.min(map.size.height-Window.panel.size.height,playerPos.y-Window.panel.size.height/2));
		Window.panel.refresh(new Point(posX,posY), playerPos);
	}
	
	
	
	
	public static void main(String[] args){
		Dimension size = new Dimension(630, 630);
		new game();
		new Window(size);
		Window.panel.timer.start();
		game.refresh();
	}
	
	public static void playerMove(player p,int dx, int dy ){
		tile newTile = map.getTile(new Point(p.position.x+dx, p.position.y+dy));
		if(newTile!=null){
			lastPos.setLocation(playerPos);
			lastX = posX;
			lastY = posY;
			p.move(dx, dy, -1* newTile.getFuelCost(), newTile.getValue());
			playerPos.setLocation(p.getPosition());
			posX= Math.max(0, Math.min(map.size.width-Window.panel.size.width,playerPos.x-Window.panel.size.width/2));
			posY= Math.max(0, Math.min(map.size.height-Window.panel.size.height,playerPos.y-Window.panel.size.height/2));
			edge = (lastX==posX)&&(lastY==posY);
			Window.panel.setTimer(newTile.getTime());
			Window.panel.move(new Point(lastX,lastY), lastPos, dx, dy, edge);
		}
	}
	public static void moveDone(player p){
		map.dig(playerPos);
	}
}
