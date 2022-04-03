package entity;

import java.awt.Rectangle;
import java.awt.image.BufferedImage;

public class Entity {

	public int worldX, worldY; // Weltkoordinaten
	public int speed; // Geschwindigkeit

	public BufferedImage up1, up2, down1, down2, left1, left2, right1, right2, default_player; // Bilder für eine Gehanimation
	public String direction; // Richtung in welche der Spieler sich bewegt

	public int spriteCounter = 0; // Wird für jeden Call der update-Methode erhöt, bestimmt wann Animation abgespielt werden soll
	public int spriteNum = 1; // Gibt an welches Bild für Animation angezeigt werden soll

	public Rectangle collisionRect; // Bereich der Entity, welcher mit festen Tiles kollidieren kann
	
	public int collisionRectDefaultX, collisionRectDefaultY;
	
	public boolean collisionOn = false;
	
}
