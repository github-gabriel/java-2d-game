package Listener;

import entity.Entity;
import main.GamePanel;
import settings.Settings;

public class CollisionListener {

	GamePanel gamePanel;

	public CollisionListener(GamePanel gamePanel) {

		this.gamePanel = gamePanel;

	}

	public void checkTile(Entity entity) {

		int entityLeftWorldX = entity.worldX + entity.collisionRect.x;
		int entityRightWorldX = entity.worldX + entity.collisionRect.x + entity.collisionRect.width;
		int entityTopWorldY = entity.worldY + entity.collisionRect.y;
		int entityBottomWorldY = entity.worldY + entity.collisionRect.y + entity.collisionRect.height;

		int entityLeftCol = entityLeftWorldX / Settings.TILE_SIZE;
		int entityRightCol = entityRightWorldX / Settings.TILE_SIZE;
		int entityTopRow = entityTopWorldY / Settings.TILE_SIZE;
		int entityBottomRow = entityBottomWorldY / Settings.TILE_SIZE;

		int tileNum1, tileNum2;

		switch (entity.direction) {
		case "up":
			entityTopRow = (entityTopWorldY - entity.speed) / Settings.TILE_SIZE;
			tileNum1 = gamePanel.tileManager.mapTileNum[entityLeftCol][entityTopRow];
			tileNum2 = gamePanel.tileManager.mapTileNum[entityRightCol][entityTopRow];
			if (gamePanel.tileManager.tile[tileNum1].collision || gamePanel.tileManager.tile[tileNum2].collision) {

				entity.collisionOn = true;

			}
			break;
		case "down":
			entityBottomRow = (entityBottomWorldY - entity.speed) / Settings.TILE_SIZE;
			tileNum1 = gamePanel.tileManager.mapTileNum[entityLeftCol][entityBottomRow];
			tileNum2 = gamePanel.tileManager.mapTileNum[entityRightCol][entityBottomRow];
			if (gamePanel.tileManager.tile[tileNum1].collision || gamePanel.tileManager.tile[tileNum2].collision) {

				entity.collisionOn = true;

			}
			break;
		case "left":
			entityLeftCol = (entityLeftWorldX - entity.speed) / Settings.TILE_SIZE;
			tileNum1 = gamePanel.tileManager.mapTileNum[entityLeftCol][entityTopRow];
			tileNum2 = gamePanel.tileManager.mapTileNum[entityLeftCol][entityBottomRow];
			if (gamePanel.tileManager.tile[tileNum1].collision || gamePanel.tileManager.tile[tileNum2].collision) {

				entity.collisionOn = true;

			}
			break;
		case "right":
			entityRightCol = (entityRightWorldX + entity.speed) / Settings.TILE_SIZE;
			tileNum1 = gamePanel.tileManager.mapTileNum[entityRightCol][entityTopRow];
			tileNum2 = gamePanel.tileManager.mapTileNum[entityRightCol][entityBottomRow];
			if (gamePanel.tileManager.tile[tileNum1].collision || gamePanel.tileManager.tile[tileNum2].collision) {

				entity.collisionOn = true;

			}
			break;
		}

	}

	public int checkObject(Entity entity, boolean player) {

		int index = 999; // "Rückmeldecode" wenn der Spieler das Objekt nicht berührt / Darf nicht gleich einer Zahl des 'obj'-Array Indexes sein

		for (int i = 0; i < gamePanel.obj.length; i++) {

			if (gamePanel.obj[i] != null) {

				entity.collisionRect.x = entity.worldX + entity.collisionRect.x;
				entity.collisionRect.y = entity.worldY + entity.collisionRect.y;

				gamePanel.obj[i].collisionRect.x = gamePanel.obj[i].worldX + gamePanel.obj[i].collisionRect.x;
				gamePanel.obj[i].collisionRect.y = gamePanel.obj[i].worldY + gamePanel.obj[i].collisionRect.y;

				switch (entity.direction) {
				case "up":
					entity.collisionRect.y -= entity.speed;
					if (entity.collisionRect.intersects(gamePanel.obj[i].collisionRect)) { // Kollidieren diese Rechtecke?
						if (gamePanel.obj[i].collision == true) {
							entity.collisionOn = true;
						}
						if (player) { // Kollidiert der Spieler mit einem Objekt ist der Index = < Settings.OBJECT_INDEX
							index = i;
						}
					}
					break;
				case "down":
					entity.collisionRect.y += entity.speed;
					if (entity.collisionRect.intersects(gamePanel.obj[i].collisionRect)) { // Kollidieren diese Rechtecke?
						if (gamePanel.obj[i].collision == true) {
							entity.collisionOn = true;
						}
						if (player) { // Kollidiert der Spieler mit einem Objekt ist der Index = < Settings.OBJECT_INDEX
							index = i;
						}
					}
					break;
				case "left":
					entity.collisionRect.x -= entity.speed;
					if (entity.collisionRect.intersects(gamePanel.obj[i].collisionRect)) { // Kollidieren diese Rechtecke?
						if (gamePanel.obj[i].collision == true) {
							entity.collisionOn = true;
						}
						if (player) { // Kollidiert der Spieler mit einem Objekt ist der Index = < Settings.OBJECT_INDEX
							index = i;
						}
					}
					break;
				case "right":
					entity.collisionRect.x += entity.speed;
					if (entity.collisionRect.intersects(gamePanel.obj[i].collisionRect)) { // Kollidieren diese Rechtecke?
						if (gamePanel.obj[i].collision == true) {
							entity.collisionOn = true;
						}
						if (player) { // Kollidiert der Spieler mit einem Objekt ist der Index = < Settings.OBJECT_INDEX
							index = i;
						}
					}
					break;
				}

				// Werte zurücksetzen da sie sonst immer weiter erhöt werden würden (+ entity.worldX/Y)

				entity.collisionRect.x = entity.collisionRectDefaultX;
				entity.collisionRect.y = entity.collisionRectDefaultY;

				gamePanel.obj[i].collisionRect.x = gamePanel.obj[i].collisionRectDefaultX;
				gamePanel.obj[i].collisionRect.y = gamePanel.obj[i].collisionRectDefaultY;

			}

		}

		return index;

	}

}
