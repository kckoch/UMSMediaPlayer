package cpsc3720;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

import javax.media.Format;
import javax.media.Manager;
import javax.media.MediaLocator;
import javax.media.Player;
import javax.media.PlugInManager;
import javax.media.format.AudioFormat;
import javax.swing.*;



public class playPanel {
	
	public playPanel(String mediaUrl, String trackTitle) throws IOException{
		
		
		
		//download media file to local file
		
			URL mediaURL = null;
			try {
				mediaURL = new java.net.URL(mediaUrl);
			} catch (MalformedURLException e1) {
				e1.printStackTrace();
			}
			File local = new File("./"+mediaUrl+".mp3");
				
			if(local.exists() == false){
				try {
					local.createNewFile();
				} catch (IOException e1) {
					e1.printStackTrace();
				}
			}
				
			URLConnection trackPull = null;
			try {
				trackPull = mediaURL.openConnection();
			} catch (IOException e1) {
				e1.printStackTrace();
			}
			byte[] buffer = new byte[8 * 1024];
				
			InputStream in = null;
			try {
				in = trackPull.getInputStream();
			} catch (IOException e1) {
				e1.printStackTrace();
			}
			OutputStream out = null;
			try {
				out = new FileOutputStream (local.getName());
			} catch (FileNotFoundException e1) {
				e1.printStackTrace();
			}
			int size;
				
			try {
				while ((size = in.read(buffer)) >= 0){
					out.write(buffer, 0, size);
				}
			} catch (IOException e1) {
				e1.printStackTrace();
			}
				
			try {
				out.close();
			} catch (IOException e1) {
				e1.printStackTrace();
			}
			try {
				in.close();
			} catch (IOException e1) {
				e1.printStackTrace();
			}
				
			// Register MP3 Decoder
			Format input1 = new AudioFormat(AudioFormat.MPEGLAYER3);
			Format input2 = new AudioFormat(AudioFormat.MPEG);
			Format output = new AudioFormat(AudioFormat.LINEAR);
			PlugInManager.addPlugIn("com.sun.media.codec.audio.mp3.JavaDecoder",
			new Format[] { input1, input2 }, new Format[] { output }, PlugInManager.CODEC);
				
			//startup player media
			try {
				String filename = local.getName();
				final Player player = Manager.createRealizedPlayer(new MediaLocator( new File(filename).toURI().toURL()));
				String elapsedTime = "0" ;
				
				JPanel pPanel = new JPanel();
				
				JTextArea urlText = new JTextArea(mediaUrl);
				pPanel.add(urlText);
				
				JButton playButt = new JButton("Play");
				pPanel.add(playButt);
				
				
				JButton pauseButt = new JButton("Pause");
				pPanel.add(pauseButt);
				
				JButton stopButt = new JButton("Stop");
				pPanel.add(stopButt);
				
				JSlider navSlider = new JSlider();
				pPanel.add(navSlider);
				
				JTextArea trackText = new JTextArea(trackTitle);
				pPanel.add(trackText);
				
				JTextField elapsedText = new JTextField();
				elapsedText.setText(elapsedTime);
				pPanel.add(elapsedText);
				
				
				String totalTime = "" + player.getDuration().getSeconds();
				JTextField totalText = new JTextField(totalTime);
				totalText.setText(totalTime);
				pPanel.add(totalText);
				
				
				totalText.setText(totalTime);
				
				playButt.addActionListener(new ActionListener(){
					public void actionPerformed(ActionEvent e){
						playAction(player);
						//player.getStopTime().getSeconds()
						//player.start();
					}
				});
				
				
				
				
				pauseButt.addActionListener(new ActionListener(){
					public void actionPerformed(ActionEvent e){
						pauseAction(player);
						//player.stop();
						//player.getStopTime().getSeconds();
					}
				});
				

			} catch (Exception ex) {
				ex.printStackTrace();
			}

		}
	public void playAction(Player player){
		player.start();
	}
	
	public void pauseAction(Player player){
		player.stop();
	}
		
}