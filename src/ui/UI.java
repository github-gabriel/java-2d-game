package ui;

import java.awt.Color;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.text.DecimalFormat;

import main.GamePanel;
import object.OBJ_Key;
import settings.Settings;

public class UI {

	GamePanel gamePanel;

	BufferedImage keyImage;

	Font font_40;

	int counter = 0;

	public boolean messageOn = false;
	public String message = "";
	private boolean gameFinished = false;

	double playTime;
	DecimalFormat decimalFormat = new DecimalFormat("#0.00");

	public UI(GamePanel gamePanel) {
		this.gamePanel = gamePanel;

		font_40 = Settings.FONT;

		OBJ_Key key = new OBJ_Key();
		keyImage = key.image;
	}

	public void showMessage(String message) {

		this.message = message;
		messageOn = true;

	}

	public void draw(Graphics2D g2D) {

		if (gameFinished) {

			g2D.setColor(new Color(8, 8, 8, 100));

			g2D.fillRect(0, 0, Settings.WIDTH, Settings.HEIGHT);

			g2D.setColor(Settings.FONT_COLOR);

			g2D.setFont(g2D.getFont().deriveFont(Settings.FONT_SIZE_BIG));

			String text = "You found the chest!";
			int textLength = (int) g2D.getFontMetrics().getStringBounds(text, g2D).getWidth();
			int x;
			int y;

			x = Settings.WIDTH / 2 - textLength / 2;
			y = Settings.HEIGHT / 2 - (Settings.TILE_SIZE * Settings.HEADING_OFFSET_Y);

			g2D.drawString(text, x, y);

			g2D.setFont(g2D.getFont().deriveFont(Settings.FONT_SIZE_MIDDLE));

			text = "Your time is: " + decimalFormat.format(playTime) + " sec";
			textLength = (int) g2D.getFontMetrics().getStringBounds(text, g2D).getWidth();

			x = Settings.WIDTH / 2 - textLength / 2;
			y = Settings.HEIGHT / 2 - (Settings.TILE_SIZE * Settings.FINAL_TIME_OFFSET_Y);

			g2D.drawString(text, x, y);

		} else {
			g2D.setFont(font_40);
			g2D.setColor(Settings.FONT_COLOR);
			g2D.drawImage(keyImage, Settings.TILE_SIZE / 2, Settings.TILE_SIZE / 2, Settings.TILE_SIZE,
					Settings.TILE_SIZE, null);
			g2D.drawString("x " + gamePanel.player.number_of_keys, Settings.TILE_SIZE * 1.5f, 80);

			playTime += (double) 1 / Settings.FPS;
			g2D.drawString(decimalFormat.format(playTime),
					Settings.TILE_SIZE * (Settings.MAX_SCREEN_COL - Settings.TIMER_OFFSET_X), Settings.TILE_SIZE);

			if (messageOn) {

				FontMetrics metrics = g2D.getFontMetrics(font_40);

				g2D.setFont(g2D.getFont().deriveFont(Settings.FONT_SIZE_SMALL));
				g2D.drawString(message, Settings.TILE_SIZE / 2, Settings.HEIGHT - metrics.getHeight());

				counter++;

				if (counter > Settings.MESSAGE_STAY_TIME * Settings.FPS) {
					counter = 0;
					messageOn = false;
				}

			}
		}

	}

	public boolean isGameFinished() {
		return gameFinished;
	}

	public void setGameFinished(boolean gameFinished) {
		this.gameFinished = gameFinished;
	}

}
