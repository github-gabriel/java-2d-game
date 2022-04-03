package object;

import java.io.FileInputStream;
import java.io.IOException;

import javax.imageio.ImageIO;

import settings.Settings;

public class OBJ_Boots extends SuperObject {

	public OBJ_Boots() {

		name = "Boots";
		try {

			image = ImageIO.read(new FileInputStream(Settings.BOOTS_FILEPATH));
			utility.scaleImage(image, Settings.TILE_SIZE, Settings.TILE_SIZE);
			
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
	
}
