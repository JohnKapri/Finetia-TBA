package johnkapri.game.world;

import java.io.IOException;
import java.util.Properties;

public enum RegionType {

	Forest("Forest"),
	Desert("Desert"),
	OpenSwamp("Swamp"),
	SwampyForest("Swampy forest"),
	Plains("Open plains"),
	Tundra("Cold wasteland"),
	Taiga("Snowy Forest"),
	Saltlake("Saltlake"),
	Sulphur("Sulphur plains"),
	Town("Town"),
	City("City"),
	Castle("Caslte"),
	House("House"),
	Dungeon("Dungeon"),
	Crypt("Crypt"),
	Stronghold("Stronghold");
		
	private String name;
	
	RegionType(String name) {
		this.name = name;
	}
	
	public String getName() {
		return name;
	}
	
	public static String getDesc(RegionType reg) {
		Properties descList = new Properties();
		try {
			/*for(RegionType regs : RegionType.values()) {
				descList.put(regs.name().toLowerCase(), "desc");
			}
			File dir = new File("C:\\\\users\\Matthias");
			File file = new File(dir, "\\regdesc.dat");
			//dir.mkdir();
			file.createNewFile();
			descList.storeToXML(new FileOutputStream(file), "The standart descriptions of all regions.");*/
			descList.loadFromXML(RegionType.class.getResourceAsStream("/txt/regdesc.dat"));
		} catch (IOException e) {e.printStackTrace();}
		return descList.getProperty(reg.name().toLowerCase());
	}
}
