package johnkapri.game.world;

import java.util.Random;

public class World {

	public static final int WORLD_SIZE = 1024;
	
	private Random rand = new Random();
	private Region[][][] regions = new Region[4][WORLD_SIZE][WORLD_SIZE];

	public World() {
		
	}

	public void generateRandomRegionAt(int x, int y) {
		if (doesRegionExistAt(x, y)) {
			return;
		}
		RegionType type = RegionType.values()[rand.nextInt(RegionType.values().length)];
		int sec = getSectorOf(x, y);
		x = Math.abs(x);
		y = Math.abs(y);
		regions[sec][x][y] = new Region(this, type);
	}

	public boolean doesRegionExistAt(int x, int y) {
		if (getRegionAt(x, y) != null) {
			return true;
		}
		return false;
	}

	public Region getRegionAt(int x, int y) {
		int sec = getSectorOf(x, y);
		x = Math.abs(x);
		y = Math.abs(y);
		return regions[sec][x][y];
	}

	public int getSectorOf(int x, int y) {
		int s = 0;
		if (x < 0) {
			s = s + 2;
		}
		if (y < 0) {
			s = s + 1;
		}
		return s;
	}
	
	public enum Direction {
		North,
		NorthWest,
		West,
		SouthWest,
		South,
		SouthEast,
		East,
		Notheast;
	}
}
