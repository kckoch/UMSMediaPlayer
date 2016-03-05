package main.gui;


import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import javax.media.CannotRealizeException;
import javax.media.Format;
import javax.media.Manager;
import javax.media.NoPlayerException;
import javax.media.Player;
import javax.media.PlugInManager;
import javax.media.format.AudioFormat;
import javax.swing.JSlider;


public class PlayTrackController {
	
	Track track;
	Player trackPlayer;
	playerStatus playerStat;
	JSlider slider;
	
	//PlayTrackController constructor
	public PlayTrackController(JSlider newSlider){
		trackPlayer = null;
		playerStat = playerStatus.STOPPED;
		slider = newSlider;
	}
	
	//starts the track that is in the track object for the controller
	public void startTrack()throws NoPlayerException, CannotRealizeException, MalformedURLException, IOException{
		File trackFile = new File(track.mediaURL);
		// Register MP3 Decoder
		Format input1 = new AudioFormat(AudioFormat.MPEGLAYER3);
		Format input2 = new AudioFormat(AudioFormat.MPEG);
		Format output = new AudioFormat(AudioFormat.LINEAR);
		PlugInManager.addPlugIn("com.sun.media.codec.audio.mp3.JavaDecoder", new Format[] { input1, input2 }, new Format[] { output }, PlugInManager.CODEC);
		trackPlayer = Manager.createRealizedPlayer(trackFile.toURI().toURL());
		playTrack();
	}
	
	//plays the track
	public void playTrack() {
		
		switch (playerStat){
			case STOPPED:
				trackPlayer.start();
				playerStat = playerStatus.PLAYING;
				break;
			case PAUSED:
				trackPlayer.start();
				playerStat = playerStatus.PLAYING;
				break;
			case PLAYING:
				break;
		}
	}
		
	//pauses the track
	public void pauseTrack(){
	
		switch (playerStat){
			case PLAYING:
				trackPlayer.stop();
				playerStat = playerStatus.PAUSED;
				break;
			case STOPPED:
				break;
			case PAUSED:
				break;
		}
				
	}
	
	//stops the track
	public void stopTrack(){
		switch(playerStat){
			case PLAYING:
				trackPlayer.stop();
				playerStat = playerStatus.STOPPED;
				break;
			case PAUSED:
				playerStat = playerStatus.STOPPED;
				break;
			case STOPPED:
				break;
		}
		
	}
	
}
