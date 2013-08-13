import java.awt.Point;



public class player {
	Point position;
	
	int hp = 10, fuel = 100, money = 0;
	int fuel_drill=2;
	int fuel_move=1;
	public player(int x, int y){
		position = new Point(x, y);
	}
	
	public void move(int dx, int dy, int delta_fuel, int delta_money){
		fuel += delta_fuel;
		money += delta_money;
		position.translate(dx, dy);
		System.out.println(fuel+":"+money);

	}

	public Point getPosition() {
		return position;
	}

	public void setPosition(Point position) {
		this.position = position;
	}

	public int getHp() {
		return hp;
	}

	public int getFuel() {
		return fuel;
	}

	public int getMoney() {
		return money;
	}
	
	
}
