import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Hashtable;
import java.util.Random;

import javax.imageio.ImageIO;


public class map {
	public static int[][] map;
	public static Dimension size;
	public static int TileSize = 30;
	static BufferedImage[] tiles = new BufferedImage[6];
	Hashtable<Integer, String> tile_files = new Hashtable<>();
	Graphics2D g;
	Random generator = new Random();
	public map(Dimension size2){
		size=size2;
		map = new int[size.width][size.height];
		for(int[] row:map){
			for (int i = 0; i < row.length; i++) {
				row[i] = 1+generator.nextInt(tiles.length-1);
			}
			
		}
		tile_files.put(1, "dirt.png");
		tile_files.put(2,"iron.png");
		tile_files.put(3,"gold.png");
		tile_files.put(4,"silver.png");
		tile_files.put(5,"diamond.png");
		tile_files.put(6,"emerald.png");
		
		tiles[0] = new BufferedImage(TileSize, TileSize, BufferedImage.TYPE_INT_RGB);
		g=tiles[0].createGraphics();
		g.setColor(Color.black);
		g.fillRect(0, 0, TileSize, TileSize);
		for (int i = 1; i < tiles.length; i++) {
			try {
				tiles[i] = ImageIO.read(new File("tiles/"+tile_files.get(i)));
			} catch(IOException e){
				
			}
			//tiles[i]=new BufferedImage(TileSize, TileSize, BufferedImage.TYPE_INT_RGB);
			//g = tiles[i].createGraphics();
			//g.setColor(new Color(TileSize*i,TileSize*i,TileSize*i));
			//g.fillRect(0, 0, TileSize, TileSize);
		}
	}
	
	BufferedImage getTile(int x, int y){
		if(x>=0 && x< size.width && y>=0 && y<size.height){
			return tiles[map[x][y]];
		}else return tiles[0];
	}
}
