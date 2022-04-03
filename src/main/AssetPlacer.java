package main;

import object.OBJ_Boots;
import object.OBJ_Chest;
import object.OBJ_Door;
import object.OBJ_Key;
import settings.Settings;

public class AssetPlacer {

	GamePanel gamePanel;

	public AssetPlacer(GamePanel gamePanel) {

		this.gamePanel = gamePanel;

	}

	public void setObject() {

		gamePanel.obj[0] = new OBJ_Key();
		gamePanel.obj[0].worldX = 25 * Settings.TILE_SIZE;
		gamePanel.obj[0].worldY = 18 * Settings.TILE_SIZE;
		
		gamePanel.obj[1] = new OBJ_Door();
		gamePanel.obj[1].worldX = 26 * Settings.TILE_SIZE;
		gamePanel.obj[1].worldY = 18 * Settings.TILE_SIZE;
		
		gamePanel.obj[2] = new OBJ_Chest();
		gamePanel.obj[2].worldX = 27 * Settings.TILE_SIZE;
		gamePanel.obj[2].worldY = 18 * Settings.TILE_SIZE;
		
		gamePanel.obj[3] = new OBJ_Boots();
		gamePanel.obj[3].worldX = 28 * Settings.TILE_SIZE;
		gamePanel.obj[3].worldY = 18 * Settings.TILE_SIZE;
		
	}

}
