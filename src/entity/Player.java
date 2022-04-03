package entity;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

import javax.imageio.ImageIO;

import Listener.GameKeyListener;
import main.GamePanel;
import main.Utility;
import settings.Settings;

public class Player extends Entity {

	public final int SCREEN_X, SCREEN_Y;

	GamePanel gamePanel;
	GameKeyListener keyListener;

	public int number_of_keys = 0;

	int standCounter = 0;

	public Player(GamePanel gamePanel, GameKeyListener keyInput) {

		this.gamePanel = gamePanel;
		this.keyListener = keyInput;

		// Koordinaten des Spielers zentrieren

		SCREEN_X = Settings.WIDTH / 2 - (Settings.TILE_SIZE / 2);
		SCREEN_Y = Settings.HEIGHT / 2 - (Settings.TILE_SIZE / 2);

		collisionRect = new Rectangle();
		collisionRect.x = Settings.TILE_SIZE / 4;
		collisionRect.y = Settings.TILE_SIZE - Settings.TILE_SIZE / 2;
		collisionRectDefaultX = collisionRect.x;
		collisionRectDefaultY = collisionRect.y;
		collisionRect.width = Settings.TILE_SIZE / 2;
		collisionRect.height = Settings.TILE_SIZE / 2;

		setDefaultValues(); // Standartwerte setzen
		getPlayerImage(); // Einzelne Bilder initialisieren
	}

	private void setDefaultValues() {

		worldX = Settings.TILE_SIZE * 25;
		worldY = Settings.TILE_SIZE * 25;
		speed = 5;
		direction = "down";

	}

	private void getPlayerImage() {

		up1 = initImage(Settings.UP_1_FILEPATH);
		up2 = initImage(Settings.UP_2_FILEPATH);
		down1 = initImage(Settings.DOWN_1_FILEPATH);
		down2 = initImage(Settings.DOWN_2_FILEPATH);
		left1 = initImage(Settings.LEFT_1_FILEPATH);
		left2 = initImage(Settings.LEFT_2_FILEPATH);
		right1 = initImage(Settings.RIGHT_1_FILEPATH);
		right2 = initImage(Settings.RIGHT_2_FILEPATH);

	}

	private BufferedImage initImage(String imagePath) {

		Utility utility = new Utility();
		BufferedImage image = null;

		try {

			image = ImageIO.read(new FileInputStream(imagePath));
			image = utility.scaleImage(image, Settings.TILE_SIZE, Settings.TILE_SIZE);

		} catch (IOException e) {
			e.printStackTrace();
		}

		return image;

	}

	public void update() { // Wird 60 mal pro Sekunde aufgerufen

		if (keyListener.key_w || keyListener.key_s || keyListener.key_a || keyListener.key_d) { // Animation wird erst abgespielt wenn ein Key gedrückt wurde
			if (keyListener.key_w) {
				direction = "up";
			}
			if (keyListener.key_a) {
				direction = "left";
			}
			if (keyListener.key_s) {
				direction = "down";
			}
			if (keyListener.key_d) {
				direction = "right";
			}

			collisionOn = false;
			gamePanel.collisionListener.checkTile(this);

			int objIndex = gamePanel.collisionListener.checkObject(this, true);
			pickUpObject(objIndex);

			if (collisionOn == false) {

				switch (direction) {
				case "up":
					worldY -= speed;
					break;
				case "down":
					worldY += speed;
					break;
				case "left":
					worldX -= speed;
					break;
				case "right":
					worldX += speed;
					break;
				}

			}

			spriteCounter++;
			if (spriteCounter > 15) { // Jede 15 Bilder ändert sich die Sprite (-> Animation)
				if (spriteNum == 1) {
					spriteNum = 2; // Bild 2 soll genutzt werden
				} else if (spriteNum == 2) {
					spriteNum = 1; // Bild 1 soll genutzt werden
				}
				spriteCounter = 0;
			}
		}

	}

	private void pickUpObject(int index) {

		if (index != 999) { // Anderer "Rückmeldecode" als 999

			String objectName = gamePanel.obj[index].name;

			switch (objectName) {
			case "Key":
				gamePanel.playSe(0);
				number_of_keys++;
				gamePanel.obj[index] = null; // Löscht das Objekt (Schlüssel)
				gamePanel.ui.showMessage("You picked up a key!");
				break;
			case "Door":
				if (number_of_keys > 0) {
					gamePanel.playSe(1);
					gamePanel.obj[index] = null; // Löscht das Objekt (Tür)
					number_of_keys--;
					gamePanel.ui.showMessage("You opened a door!");
				} else {
					gamePanel.ui.showMessage("You need a key to unlock the door!");
				}
				break;
			case "Boots":
				gamePanel.playSe(2);
				speed += 3;
				gamePanel.obj[index] = null;
				gamePanel.ui.showMessage("You picked up boots!");
				break;
			case "Chest":
				gamePanel.ui.setGameFinished(true);
				gamePanel.stopMusic();
				break;
			}

		}

	}

	public void draw(Graphics2D g2D) {

		BufferedImage image = null;

		// Zeigt passendes Bild zu der Bewegung des Spielers

		switch (direction) {
		case "up":
			if (spriteNum == 1) {
				image = up1;
			} else if (spriteNum == 2) {
				image = up2;
			}
			break;
		case "down":
			if (spriteNum == 1) {
				image = down1;
			} else if (spriteNum == 2) {
				image = down2;
			}
			break;
		case "left":
			if (spriteNum == 1) {
				image = left1;
			} else if (spriteNum == 2) {
				image = left2;
			}
			break;
		case "right":
			if (spriteNum == 1) {
				image = right1;
			} else if (spriteNum == 2) {
				image = right2;
			}
			break;
		default:
			break;
		}

		// Ausgewähltes Bild malen

		g2D.drawImage(image, SCREEN_X, SCREEN_Y, null);

		if (Settings.DEBUG_MODE) {
			g2D.setColor(Color.RED);
			g2D.fillRect(SCREEN_X + collisionRect.x, SCREEN_Y + collisionRect.y, collisionRect.width,
					collisionRect.height);
		}

	}

}
