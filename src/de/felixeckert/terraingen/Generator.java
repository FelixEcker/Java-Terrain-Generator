package de.felixeckert.terraingen;

import java.awt.List;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

/**
 * This class contains functions for all
 * types of Terrain Generation by me, which
 * are written in Java.
 * 
 * I also documented this in German and i'm
 * to lazy to translate, so sorry...
 * 
 * @author Felix Eckert
 * */
public class Generator {
	
	/**
	 * Generates the most basic 2D terrain by me.
	 * Uses the tiles from the TerrainTypes class.
	 * 
	 * The 1 and second tiles from that class are
	 * land and water tiles respectively. In this
	 * generator Land tiles are can be replaced
	 * by every other tile with the id of 3 or
	 * higher.
	 * 
	 * @param width Width of the terrain to be generated
	 * @param height Height of the terrain to be generated
	 * @param print Sets if wether the generated terrain should be printed to console or not
	 * @return List A list containing every generated terrain tile.
	 * 
	 * @author Felix Eckert
	 * */
	public List generateTypeA(int width, int height, boolean print) {
		// LST = Landschaftsteil
		
		List tileMap = new List(); // Karte
		TerrainTypes terrainTypes = new TerrainTypes();
		
		// Läuft 256 mal durch
		for (int i = 0; i <= (width * height); i++) {
			int tile = new Random().nextInt(2); // Zufällige Landschaftsart auswählen
			int specialTileNum = new Random().nextInt(100); // Zufällig auswählen, ob es ein "specialTile" werden
															// soll oder nicht
					
			tileMap.add(terrainTypes.terrainTypes.get(tile)); // Landschaft hinzufügen
					
			// Überprüfen ob die Landschaft vom Typ Land ist.
			if (tile == 0) {
				// Überprüfen ob es eine Speziallandschaft werden soll.
				if (specialTileNum > 90) {
					tileMap.remove(tileMap.getItemCount()-1); // Letzte Landschaft entfernen
					tileMap.add(terrainTypes.terrainTypes.get(ThreadLocalRandom.current().nextInt(2, terrainTypes.terrainTypes.size()-1))); // Durch Speziallandschaft ersetzen
				}
			}
		}
				
		///////////////////////////////////////////////////////////////////////////
		// Anzeigen der Landschaft 
		///////////////////////////////////////////////////////////////////////////
				
		int columnCounter = 0; // Zählt Spalten hoch
		int i = 0; // Zählt Landschaftsteile Hoch.
		while (print) {
			if (i == (width * height)) { // Wenn der LST zähler die anzahl der LSTs-1 überschritten hat aufhören
				break;
			}
					
			columnCounter++; // Spaltenzähler Inkrementieren
			System.out.print(tileMap.getItem(i)); // Aktuelles LST anzeigen
			if (columnCounter == width) { // Wenn der Spaltenzähler 16 ist
				System.out.print("\n"); // Einen Zeihlenumbruch ausgeben
				columnCounter = 0; // Und den Spaltenzähler zurücksetzen
			}
			i++; // LST Zähler inkrementieren
		}
		
		return tileMap;
	}
}
