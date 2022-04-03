package main;

import java.awt.Frame;

import javax.swing.JFrame;

import settings.Settings;

public class Window extends JFrame {

	JFrame frame;

	GamePanel gamePanel;

	public Window() {

		initGui();

	}

	private void initGui() {

		frame = new JFrame();
		gamePanel = new GamePanel();
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setResizable(Settings.RESIZABLE);
		frame.setTitle(Settings.WINDOW_TITLE);
		frame.add(gamePanel);
		frame.pack();
		frame.setLocationRelativeTo(null);
		frame.setVisible(Settings.VISIBLE);
		
		gamePanel.init();
		gamePanel.startGameThread();

	}

}
