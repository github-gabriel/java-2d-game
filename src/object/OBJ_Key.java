package object;

import java.io.FileInputStream;
import java.io.IOException;

import javax.imageio.ImageIO;

import main.GamePanel;
import settings.Settings;

public class OBJ_Key extends SuperObject {

	public OBJ_Key() {
		
		name = "Key";
		try {
			
			image = ImageIO.read(new FileInputStream(Settings.KEY_FILEPATH));
			utility.scaleImage(image, Settings.TILE_SIZE, Settings.TILE_SIZE);
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
}
