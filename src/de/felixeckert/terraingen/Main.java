package de.felixeckert.terraingen;

public class Main {
	public static void main(String args[]) {
		Generator gen = new Generator();
		int width = 256; // Width of the Terrain to be generated
		int height = 256; // Height of the Terrain to be generated
		gen.generateTypeA(width, height, true); // Generate terrain and automatically
												// print the map to console.
	}
}
