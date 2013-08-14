import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.image.BufferedImage;
import java.util.Random;

public class map {
	public static int[][] map;
	public static Dimension size = new Dimension();
	public static int TileSize = 30;
	static tile[] tiles = new tile[7];
	static BufferedImage blank = new BufferedImage(TileSize, TileSize, BufferedImage.TYPE_INT_RGB);
	private Graphics2D g;
	private Random generator = new Random();
	private int[] probabilities = new int[5];
	private int sum, select;
	private float rand;
	public map(Dimension size2){
		size.setSize(size2);
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
		
		blank = new BufferedImage(TileSize, TileSize, BufferedImage.TYPE_INT_RGB);
		g=blank.createGraphics();
		g.setColor(Color.black);
		g.fillRect(0, 0, TileSize, TileSize);
		for (int i = 0; i < tiles.length; i++) {
			tiles[i] = new tile(new Dimension(TileSize, TileSize), i);
		}
	}
	
	static BufferedImage getTile(int x, int y){
		if(isInMap(x,y)){
			return tiles[map[x][y]].getSprite();
		}else return blank;
	}
	
	static tile dig(Point pos){
		if(isInMap(pos)){
			tile type = tiles[map[pos.x][pos.y]];
			map[pos.x][pos.y] = 0;
			return type;
		}
		return null;
	}
	static tile getTile(Point pos){
		if(isInMap(pos)){
			tile type = tiles[map[pos.x][pos.y]];
			return type;
		}
		return null;
	}
	
	static boolean isInMap(int x, int y){
		return x>=0 && x< size.width && y>=0 && y<size.height;
	}
	static boolean isInMap(Point pos){
		return isInMap(pos.x, pos.y);
	}
	
	
}
