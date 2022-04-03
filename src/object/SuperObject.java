package object;

import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;

import main.GamePanel;
import main.Utility;
import settings.Settings;

public class SuperObject {

	public BufferedImage image;
	public String name;
	public boolean collision = false;
	public int worldX, worldY;
	public Rectangle collisionRect = new Rectangle(0, 0, Settings.TILE_SIZE, Settings.TILE_SIZE);
	public int collisionRectDefaultX = 0;
	public int collisionRectDefaultY = 0;
	Utility utility = new Utility();
	
	public void draw(Graphics2D g2D, GamePanel gamePanel) {

		int screenX = worldX - gamePanel.player.worldX + gamePanel.player.SCREEN_X;
		int screenY = worldY - gamePanel.player.worldY + gamePanel.player.SCREEN_Y;

		if (worldX + Settings.TILE_SIZE > gamePanel.player.worldX - gamePanel.player.SCREEN_X
				&& worldX - Settings.TILE_SIZE < gamePanel.player.worldX + gamePanel.player.SCREEN_X
				&& worldY + Settings.TILE_SIZE > gamePanel.player.worldY - gamePanel.player.SCREEN_Y
				&& worldY - Settings.TILE_SIZE < gamePanel.player.worldY + gamePanel.player.SCREEN_Y) {

			g2D.drawImage(image, screenX, screenY, Settings.TILE_SIZE, Settings.TILE_SIZE, null);

		}

	}

}
