package settings;

import java.awt.Color;
import java.awt.Font;

public final class Settings {

	public static final String WINDOW_TITLE = "2D Game";

	public static final int ORIGINAL_TILE_SIZE = 16, SCALE = 4;

	public static final int TILE_SIZE = ORIGINAL_TILE_SIZE * SCALE;

	public static final int MAX_SCREEN_COL = 16, MAX_SCREEN_ROW = 12;

	public static final int WIDTH = TILE_SIZE * MAX_SCREEN_COL, HEIGHT = TILE_SIZE * MAX_SCREEN_ROW;

	public static final int FPS = 60;
	
	public static final boolean RESIZABLE = false;
	
	public static final boolean VISIBLE = true;

	public static final int MAX_WORLD_COL = 52, MAX_WORLD_ROW = 50;

	public static final int WORLD_WIDTH = TILE_SIZE * MAX_WORLD_COL, WORLD_HEIGHT = TILE_SIZE * MAX_WORLD_ROW;

	public static final int TILE_INDEX = 50;

	public static final int OBJECT_INDEX = 10;

	public static final Font FONT = new Font("Bahnschrift", Font.BOLD, 40);
	
	public static final float FONT_SIZE_BIG = 80;
	
	public static final float FONT_SIZE_MIDDLE = 50;
	
	public static final float FONT_SIZE_SMALL = 35;
	
	public static final int HEADING_OFFSET_Y = 3;
	
	public static final int FINAL_TIME_OFFSET_Y = 1;
	
	public static final int TIMER_OFFSET_X = 2;
	
	public static final float DRAW_TIME_OFFSET_X = 0.82f;
	
	public static final int MESSAGE_STAY_TIME = 1;
	
	public static final Color FONT_COLOR = Color.WHITE;
	
	public static final Color BACKGROUND_COLOR = Color.BLACK;

	public static boolean DEBUG_MODE = false;

	public static final String STANDING_FILEPATH = "./src/res/player/player.png";
	
	public static final String UP_1_FILEPATH = "./src/res/player/player_up_1.png";
	public static final String UP_2_FILEPATH = "./src/res/player/player_up_2.png";

	public static final String DOWN_1_FILEPATH = "./src/res/player/player_down_1.png";
	public static final String DOWN_2_FILEPATH = "./src/res/player/player_down_2.png";

	public static final String LEFT_1_FILEPATH = "./src/res/player/player_left_1.png";
	public static final String LEFT_2_FILEPATH = "./src/res/player/player_left_2.png";

	public static final String RIGHT_1_FILEPATH = "./src/res/player/player_right_1.png";
	public static final String RIGHT_2_FILEPATH = "./src/res/player/player_right_2.png";

	public static final String MAP_FILEPATH = "./src/res/maps/world_map";

	public static final float MUSIC_VOLUME = -10;
	public static final float SOUND_VOLUME = 0.75f;

	public static final String BRICKS_FILEPATH = "./src/res/tiles/bricks.png";
	public static final String COBBLESTONE_FILEPATH = "./src/res/tiles/cobblestone.png";
	public static final String DIRT_FILEPATH = "./src/res/tiles/dirt.png";
	public static final String GRASS_FILEPATH = "./src/res/tiles/grass.png";
	public static final String GRASS01_FILEPATH = "./src/res/tiles/grass01.png";
	public static final String WALL_FILEPATH = "./src/res/tiles/wall.png";
	
	public static final String ROAD00_FILEPATH = "./src/res/tiles/road00.png";
	public static final String ROAD01_FILEPATH = "./src/res/tiles/road01.png";
	public static final String ROAD02_FILEPATH = "./src/res/tiles/road02.png";
	public static final String ROAD03_FILEPATH = "./src/res/tiles/road03.png";
	public static final String ROAD04_FILEPATH = "./src/res/tiles/road04.png";
	public static final String ROAD05_FILEPATH = "./src/res/tiles/road05.png";
	public static final String ROAD06_FILEPATH = "./src/res/tiles/road06.png";
	public static final String ROAD07_FILEPATH = "./src/res/tiles/road07.png";
	public static final String ROAD08_FILEPATH = "./src/res/tiles/road08.png";
	public static final String ROAD09_FILEPATH = "./src/res/tiles/road09.png";
	public static final String ROAD10_FILEPATH = "./src/res/tiles/road10.png";
	public static final String ROAD11_FILEPATH = "./src/res/tiles/road11.png";
	public static final String ROAD12_FILEPATH = "./src/res/tiles/road12.png";
	public static final String WATER00_FILEPATH = "./src/res/tiles/water00.png";
	public static final String WATER01_FILEPATH = "./src/res/tiles/water01.png";
	public static final String WATER02_FILEPATH = "./src/res/tiles/water02.png";
	public static final String WATER03_FILEPATH = "./src/res/tiles/water03.png";
	public static final String WATER04_FILEPATH = "./src/res/tiles/water04.png";
	public static final String WATER05_FILEPATH = "./src/res/tiles/water05.png";
	public static final String WATER06_FILEPATH = "./src/res/tiles/water06.png";
	public static final String WATER07_FILEPATH = "./src/res/tiles/water07.png";
	public static final String WATER08_FILEPATH = "./src/res/tiles/water08.png";
	public static final String WATER09_FILEPATH = "./src/res/tiles/water09.png";
	public static final String WATER10_FILEPATH = "./src/res/tiles/water10.png";
	public static final String WATER11_FILEPATH = "./src/res/tiles/water11.png";
	public static final String WATER12_FILEPATH = "./src/res/tiles/water12.png";
	public static final String WATER13_FILEPATH = "./src/res/tiles/water13.png";

	public static final String DOOR_FILEPATH = "./src/res/objects/door.png";
	public static final String KEY_FILEPATH = "./src/res/objects/key.png";
	public static final String CHEST_FILEPATH = "./src/res/objects/chest.png";
	public static final String BOOTS_FILEPATH = "./src/res/objects/boots.png";

	public static final String COIN_SOUND_FILEPATH = "./src/res/sound/coin.wav";
	public static final String DOOR_SOUND_FILEPATH = "./src/res/sound/door_open.wav";
	public static final String BOOTS_SOUND_FILEPATH = "./src/res/sound/boots.wav";
	public static final String BACKGROUND_MUSIC_FILEPATH = "./src/res/sound/background_music.wav";

}
