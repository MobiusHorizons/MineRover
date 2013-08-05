import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.util.Random;


public class map {
	public static int[][] map;
	public static Dimension size;
	public static int TileSize = 30;
	static BufferedImage[] tiles = new BufferedImage[6];
	Graphics2D g;
	Random generator = new Random();
	
	
	public map(Dimension size2){
		size=size2;
		map = new int[size.width][size.height];
		for(int[] row:map){
			for (int i = 0; i < row.length; i++) {
				row[i] = generator.nextInt(tiles.length);
			}
		}
		for (int i = 0; i < tiles.length; i++) {
			tiles[i]=new BufferedImage(TileSize, TileSize, BufferedImage.TYPE_INT_RGB);
			g = tiles[i].createGraphics();
			g.setColor(new Color(TileSize*i,TileSize*i,TileSize*i));
			g.fillRect(0, 0, TileSize, TileSize);
		}
	}
	
	BufferedImage getTile(int x, int y){
		return tiles[map[x][y]];
	}
}
