package main;

import java.awt.Color;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JPanel;

import Listener.CollisionListener;
import Listener.GameKeyListener;
import entity.Player;
import object.SuperObject;
import settings.Settings;
import tile.TileManager;
import ui.UI;

public class GamePanel extends JPanel implements Runnable {

	// Instanzen

	Thread gameThread;

	GameKeyListener keyInput = new GameKeyListener();

	public TileManager tileManager = new TileManager(this);

	public Sound music = new Sound();

	public Sound soundeffect = new Sound();

	public CollisionListener collisionListener = new CollisionListener(this);

	public Player player = new Player(this, keyInput);

	public SuperObject obj[] = new SuperObject[Settings.OBJECT_INDEX];

	public AssetPlacer assetPlacer = new AssetPlacer(this);

	public UI ui = new UI(this);

	public GamePanel() {

		this.setPreferredSize(new Dimension(Settings.WIDTH, Settings.HEIGHT));
		this.setBackground(Settings.BACKGROUND_COLOR);
		this.setDoubleBuffered(true);
		this.addKeyListener(keyInput);
		this.setFocusable(true);

	}

	public void init() {

		assetPlacer.setObject();

		playMusic(3);

	}

	public void startGameThread() {

		gameThread = new Thread(this); // Game Loop läuft in einem weiteren Thread (gameThread)
		gameThread.start();

	}

	// Automatisch "generierte" Methode vom Interface Runnable. Jeder Thread, dem dieses Runnable übergeben wird, ruft diese Methode auf

	@Override
	public void run() {

		double drawInterval = 1000000000 / Settings.FPS;
		double delta = 0;
		long lastTime = System.nanoTime();
		long currentTime;
		long timer = 0;
		int drawCount = 0;

		while (gameThread != null) { // Game Loop

			currentTime = System.nanoTime();

			delta += (currentTime - lastTime) / drawInterval;

			timer += (currentTime - lastTime);

			lastTime = currentTime;

			if (delta >= 1) {

				update();

				repaint();

				delta--;

				drawCount++;

			}

			if (timer >= 1000000000) {
//				System.out.println("[FPS] " + drawCount);
				drawCount = 0;
				timer = 0;
			}

		}

	}

	// Update-Methode

	public void update() {

		player.update();

	}

	// Überschreibt die "paintComponent"-Methode von JPanel um die Landschaft und den Spieler auf dem JPanel zu malen

	public void paintComponent(Graphics g) {

		super.paintComponent(g);

		long drawStart = 0;

		if (Settings.DEBUG_MODE) {
			drawStart = System.nanoTime();
		}

		Graphics2D g2D = (Graphics2D) g;

		tileManager.draw(g2D); // Layer 0

		for (int i = 0; i < obj.length; i++) {
			if (obj[i] != null) {
				obj[i].draw(g2D, this);
			}
		}

		player.draw(g2D); // Layer 2

		ui.draw(g2D);

		if (Settings.DEBUG_MODE) {
			long drawEnd = System.nanoTime();
			long passed = drawEnd - drawStart;

			g2D.setColor(Color.WHITE);
			String text = "Draw Time: " + passed;
			g2D.drawString(text, Settings.TILE_SIZE * (Settings.MAX_SCREEN_COL - Settings.DRAW_TIME_OFFSET_X)
					- (int) g2D.getFontMetrics().getStringBounds(text, g2D).getWidth(), Settings.TILE_SIZE * 2);

		}

		g2D.dispose();

	}

	public void playMusic(int i) {

		music.setFile(i);
		music.play(Settings.MUSIC_VOLUME);
		music.loop(Settings.MUSIC_VOLUME);

	}

	public void stopMusic() {

		music.stop();

	}

	public void playSe(int i) {

		soundeffect.setFile(i);
		soundeffect.play(Settings.SOUND_VOLUME);

	}

}
