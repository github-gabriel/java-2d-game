package main;

import java.io.File;
import java.net.URL;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.FloatControl;

import settings.Settings;

public class Sound {

	Clip clip;
	File soundFile[] = new File[30];

	public Sound() {

		soundFile[0] = new File(Settings.COIN_SOUND_FILEPATH);
		soundFile[1] = new File(Settings.DOOR_SOUND_FILEPATH);
		soundFile[2] = new File(Settings.BOOTS_SOUND_FILEPATH);
		soundFile[3] = new File(Settings.BACKGROUND_MUSIC_FILEPATH);

	}

	public void setFile(int i) {

		try {
			
			AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(soundFile[i]);
			clip = AudioSystem.getClip();
			clip.open(audioInputStream);

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public void play(float value) {

		FloatControl volume = (FloatControl) clip.getControl(FloatControl.Type.MASTER_GAIN);
        volume.setValue(value);
		
		clip.start();

	}

	public void loop(float value) {

		FloatControl volume = (FloatControl) clip.getControl(FloatControl.Type.MASTER_GAIN);
        volume.setValue(value);
		
		clip.loop(Clip.LOOP_CONTINUOUSLY);

	}

	public void stop() {

		clip.stop();

	}

}
