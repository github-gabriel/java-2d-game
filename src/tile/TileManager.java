package tile;

import java.awt.Graphics2D;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import javax.imageio.ImageIO;

import main.GamePanel;
import main.Utility;
import settings.Settings;

public class TileManager {

	GamePanel gamePanel;
	public Tile[] tile; // Array von Tiles für verschiedene Arten von Tiles
	public int mapTileNum[][]; // 2-Dimensionaler Array um eine Zahl irgendwo aus der Map zu lesen ( Spalte = X, Zeile = Y )

	public TileManager(GamePanel gamePanel) {

		this.gamePanel = gamePanel;

		tile = new Tile[Settings.TILE_INDEX];
		mapTileNum = new int[Settings.MAX_WORLD_COL][Settings.MAX_WORLD_ROW];

		getTileImage(); // Array initialisieren
		loadMap(Settings.MAP_FILEPATH); // Map laden

	}

	private void getTileImage() {

		initImage(0, Settings.GRASS_FILEPATH, false);

		initImage(1, Settings.GRASS01_FILEPATH, false);

		initImage(2, Settings.BRICKS_FILEPATH, false);

		initImage(3, Settings.COBBLESTONE_FILEPATH, false);

		initImage(4, Settings.DIRT_FILEPATH, false);

		initImage(5, Settings.WALL_FILEPATH, false);

		initImage(6, Settings.ROAD00_FILEPATH, false);
		
		initImage(7, Settings.ROAD01_FILEPATH, false);

		initImage(8, Settings.ROAD02_FILEPATH, false);

		initImage(9, Settings.ROAD03_FILEPATH, false);

		initImage(10, Settings.ROAD04_FILEPATH, false);

		initImage(11, Settings.ROAD05_FILEPATH, false);

		initImage(12, Settings.ROAD06_FILEPATH, false);

		initImage(13, Settings.ROAD07_FILEPATH, false);

		initImage(14, Settings.ROAD08_FILEPATH, false);
		
		initImage(15, Settings.ROAD09_FILEPATH, false);

		initImage(16, Settings.ROAD10_FILEPATH, false);
		
		initImage(17, Settings.ROAD11_FILEPATH, false);
		
		initImage(18, Settings.ROAD12_FILEPATH, false);
		
		initImage(19, Settings.WATER00_FILEPATH, true);
		
		initImage(20, Settings.WATER01_FILEPATH, true);

		initImage(21, Settings.WATER02_FILEPATH, true);

		initImage(22, Settings.WATER03_FILEPATH, true);

		initImage(23, Settings.WATER04_FILEPATH, true);

		initImage(24, Settings.WATER05_FILEPATH, true);

		initImage(25, Settings.WATER06_FILEPATH, true);

		initImage(26, Settings.WATER07_FILEPATH, true);

		initImage(27, Settings.WATER08_FILEPATH, true);
		
		initImage(28, Settings.WATER09_FILEPATH, true);

		initImage(29, Settings.WATER10_FILEPATH, true);
		
		initImage(30, Settings.WATER11_FILEPATH, true);
		
		initImage(31, Settings.WATER12_FILEPATH, true);
		
		initImage(32, Settings.WATER13_FILEPATH, true);

	}

	private void initImage(int index, String imagePath, boolean collision) {

		Utility utility = new Utility();

		try {

			tile[index] = new Tile();
			tile[index].image = ImageIO.read(new FileInputStream(imagePath));
			tile[index].image = utility.scaleImage(tile[index].image, Settings.TILE_SIZE, Settings.TILE_SIZE);
			tile[index].collision = collision;

		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	private void loadMap(String file) {

		try {

			InputStream inputStream = new FileInputStream(file);

			BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));

			int col = 0;
			int row = 0;

			while (col < Settings.MAX_WORLD_COL && row < Settings.MAX_WORLD_ROW) {

				String line = bufferedReader.readLine();

				while (col < Settings.MAX_WORLD_COL) { // Solange es noch Spalten und Zeilen gibt, tue:

					String numbers[] = line.split(" "); // 0 1 -> Trennt Zahlen und packt sie in einen Array

					int num = Integer.parseInt(numbers[col]); // Geht durch alle Zahlen der Linie durch und "speichert" sie in einer Variable

					mapTileNum[col][row] = num; // Nummer wird in der richtigen Zeile und Spalte im Array abgelegt
					col++; // Nächste Spalte

				}
				if (col == Settings.MAX_WORLD_COL) {
					col = 0;
					row++; // Nächset Zeile
				}
			}

			bufferedReader.close();

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public void draw(Graphics2D g2D) {

		int world_col = 0;
		int world_row = 0;

		while (world_col < Settings.MAX_WORLD_COL && world_row < Settings.MAX_WORLD_ROW) { // Solange es noch Spalten und Zeilen gibt, tue:

			int tileNum = mapTileNum[world_col][world_row]; // Variable wird mit Tile Nummer aus dem Array mit allen Nummern der Map initialisiert

			int worldX = world_col * Settings.TILE_SIZE;
			int worldY = world_row * Settings.TILE_SIZE;
			int screenX = worldX - gamePanel.player.worldX + gamePanel.player.SCREEN_X;
			int screenY = worldY - gamePanel.player.worldY + gamePanel.player.SCREEN_Y;

			if (worldX + Settings.TILE_SIZE > gamePanel.player.worldX - gamePanel.player.SCREEN_X
					&& worldX - Settings.TILE_SIZE < gamePanel.player.worldX + gamePanel.player.SCREEN_X
					&& worldY + Settings.TILE_SIZE > gamePanel.player.worldY - gamePanel.player.SCREEN_Y
					&& worldY - Settings.TILE_SIZE < gamePanel.player.worldY + gamePanel.player.SCREEN_Y) {

				// Nur Tiles in der Nähe des Spielers malen

				g2D.drawImage(tile[tileNum].image, screenX, screenY, null);

			}

			world_col++; // Nächste Spalte

			if (world_col == Settings.MAX_WORLD_COL) { // Wenn maximale Spaltenanzahl erreicht ist, tue:
				world_col = 0; // Spalten auf 0 zurücksetzen
				world_row++; // Nächste Zeile
			}

		}

	}

}
