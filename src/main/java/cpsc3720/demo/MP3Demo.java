package cpsc3720.demo;

import java.io.IOException;
import java.io.File;
import java.net.URL;

import javax.media.Format;
import javax.media.Manager;
import javax.media.MediaLocator;
import javax.media.Player;
import javax.media.PlugInManager;
import javax.media.format.AudioFormat;

public class MP3Demo {
	public static void main(String[] args) throws IOException {
		// Register MP3 Decoder
		Format input1 = new AudioFormat(AudioFormat.MPEGLAYER3);
		Format input2 = new AudioFormat(AudioFormat.MPEG);
		Format output = new AudioFormat(AudioFormat.LINEAR);
		PlugInManager.addPlugIn("com.sun.media.codec.audio.mp3.JavaDecoder",
				new Format[] { input1, input2 }, new Format[] { output },
				PlugInManager.CODEC);
		
		if (args.length != 1) {
			System.err.println("Please supply filename to play as a command line argument.");
			System.exit(1);
		}
		
		try {
			String filename = args[0];
			System.out.println("Playing " + filename + "...");
			Player player = Manager.createRealizedPlayer(new MediaLocator(
					new File(filename).toURI().toURL()));

			player.start();

			System.out.println("Clip length: "
					+ player.getDuration().getSeconds() + " seconds");
			System.out.print("Press enter to stop playing...");
			System.in.read();
			player.stop();

		} catch (Exception ex) {
			ex.printStackTrace();
		}

		System.out.println("Done!");
	}
}