package johnkapri.game.world;

public class Region {

	public static final int MAP_SECTOR_X_NEG = 0x10;
	public static final int MAP_SECTOR_Y_NEG = 0x01;
	
	private String name;
	private RegionType type;
	private World world;
	private String description;
	
	public Region(World world, RegionType type) {
		this.world = world;
		this.type = type;
	}
	
	private void setName(String name) {
		this.name = name;
	}
	
	public String getName() {
		if(name != null) {
			return name;
		}
		return type.getName();
	}
	
	public RegionType getType() {
		return type;
	}
	
	public String getDescription() {
		if(description != null) {
			return description;
		}
		return RegionType.getDesc(type);
	}
}
