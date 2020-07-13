package de.felixeckert.terraingen;

import java.util.HashMap;

public class TerrainTypes {
	public HashMap<Integer, String> terrainTypes = new HashMap<>();
	
	public TerrainTypes() {
		terrainTypes.put(0, "#");
		terrainTypes.put(1, "~");
		terrainTypes.put(2, "F");
		terrainTypes.put(3, "D");
		terrainTypes.put(4, "M");
	}
}
