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
	static BufferedImage[] tiles = new BufferedImage[7];
	private Hashtable<Integer, String> tile_files = new Hashtable<>();
	private Graphics2D g;
	private Random generator = new Random();
	private int[] probabilities = new int[5];
	private int sum, select;
	private float rand;
	public map(Dimension size2){
		size=size2;
		map = new int[size.width][size.height];
		for(int[] row:map){
			for (int i = 0; i < row.length; i++) {
				probabilities[0] = 10;
				probabilities[1] = 10;
				probabilities[2] = 10;
				probabilities[3] = 10;
				probabilities[4] = 10;
				sum=0;
				for (int part:probabilities)sum+=part;
				rand = generator.nextFloat();
				if(rand > 0.2)select = 0;
				else {
					rand*=5;
					for(int j=0;j<probabilities.length;j++){
						if(rand<(float)probabilities[j]/sum){
							select = j+1;
							break;
						}
						else rand -= (float)probabilities[j]/sum;
					}
				}
				row[i] = 1+select;
				
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
		}
	}
	
	BufferedImage getTile(int x, int y){
		if(x>=0 && x< size.width && y>=0 && y<size.height){
			return tiles[map[x][y]];
		}else return tiles[0];
	}
}
