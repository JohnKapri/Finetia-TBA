package johnkapri.game.gameobjects;

import johnkapri.game.world.RegionType;
import johnkapri.game.world.World;
import johnkapri.game.world.World.Direction;

public class Player {

	private int x;
	private int y;
	private World world;
	private String name;

	public Player(World world, String name) {
		this.world = world;
		this.name = name;
		moveTo(0, 0);
	}

	public boolean moveTo(int x, int y) {
		if (x > World.WORLD_SIZE || x < -World.WORLD_SIZE
				|| y > World.WORLD_SIZE || y < -World.WORLD_SIZE) {
			return false;
		}
		if (!world.doesRegionExistAt(x, y)) {
			world.generateRandomRegionAt(x, y);
		}
		this.x = x;
		this.y = y;
		return true;
	}

	public boolean go(Direction dir) {
		int x = this.x;
		int y = this.y;
		switch (dir) {
		case North:
			y++;
			break;
		case West:
			x--;
			break;
		case South:
			y--;
			break;
		case East:
			x++;
			break;
		default:
			return false;
		}
		return moveTo(x, y);
	}

	public String lookAround() {
		return new StringBuilder()
				.append("You are in " + world.getRegionAt(x, y).getName()
						+ ". "
						+ RegionType.getDesc(world.getRegionAt(x, y).getType()) + "\r\n")
				.toString();
	}
	
	public int getX() {
		return x;
	}
	
	public int getY() {
		return y;
	}

	public String getName() {
		return name;
	}
}
