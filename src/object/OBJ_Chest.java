package object;

import java.io.FileInputStream;
import java.io.IOException;

import javax.imageio.ImageIO;

import settings.Settings;

public class OBJ_Chest extends SuperObject{

	public OBJ_Chest() {

		name = "Chest";
		try {

			image = ImageIO.read(new FileInputStream(Settings.CHEST_FILEPATH));
			utility.scaleImage(image, Settings.TILE_SIZE, Settings.TILE_SIZE);
			
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
	
}
