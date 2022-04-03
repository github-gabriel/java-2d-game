package object;

import java.io.FileInputStream;
import java.io.IOException;

import javax.imageio.ImageIO;

import settings.Settings;

public class OBJ_Door extends SuperObject {

	public OBJ_Door() {

		name = "Door";
		try {

			image = ImageIO.read(new FileInputStream(Settings.DOOR_FILEPATH));
			utility.scaleImage(image, Settings.TILE_SIZE, Settings.TILE_SIZE);
				
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		collision = true;

	}

}
