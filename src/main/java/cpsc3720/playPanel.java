package cpsc3720;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

import javax.media.Clock;
import javax.media.Format;
import javax.media.Manager;
import javax.media.MediaLocator;
import javax.media.Player;
import javax.media.PlugInManager;
import javax.media.Time;
import javax.media.format.AudioFormat;
import javax.swing.*;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;



public class playPanel extends JPanel{
	
	private elapsedTime elapse;

	public playPanel(String mediaUrl, String trackTitle) throws IOException{
		
		
		
		//download media file to local file
		
			URL mediaURL = null;
			try {
				mediaURL = new java.net.URL(mediaUrl);
			} catch (MalformedURLException e1) {
				e1.printStackTrace();
			}
			File local = new File("./"+mediaUrl+".mp3");
				
			//local.createNewFile();
				
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
				final playerDetail players = new playerDetail(filename);
				players.player = Manager.createRealizedPlayer(new MediaLocator( new File(filename).toURI().toURL()));
				setElapse(new elapsedTime());
				
				JPanel pPanel = new JPanel();
				
				JTextArea urlText = new JTextArea(mediaUrl);
				
				
				JTextArea trackText = new JTextArea(trackTitle);
				
				JButton playButt = new JButton("Play");
				
				
				JButton pauseButt = new JButton("Pause");
				
				JButton stopButt = new JButton("Stop");
				
				JSlider navSlider = new JSlider();
				
				
				
				elapsedTime.elapsedString = "" + players.player.getMediaTime().getSeconds();
				JTextField elapsedText = new JTextField();
				elapsedText.setText(elapsedTime.elapsedString);
				
				ActionListener elapsedListener = new ActionListener(){

					@Override
					public void actionPerformed(ActionEvent e) {
						elapsedTime.setSeconds(elapsedTime.getSeconds() + 1);
						elapsedTime.elapsedString = "" + elapsedTime.getSeconds(); 
						
					}
					
				};
							
				
				String totalTime = "" + players.player.getDuration().getSeconds();
				JTextField totalText = new JTextField(totalTime);
				totalText.setText(totalTime);
				GroupLayout gl_pPanel = new GroupLayout(pPanel);
				gl_pPanel.setHorizontalGroup(
					gl_pPanel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_pPanel.createSequentialGroup()
							.addGroup(gl_pPanel.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_pPanel.createParallelGroup(Alignment.LEADING, false)
									.addGroup(gl_pPanel.createSequentialGroup()
										.addContainerGap()
										.addComponent(navSlider, 0, 0, Short.MAX_VALUE))
									.addGroup(gl_pPanel.createSequentialGroup()
										.addComponent(playButt)
										.addGap(18)
										.addComponent(pauseButt)
										.addGap(18)
										.addComponent(stopButt))
									.addComponent(urlText)
									.addComponent(trackText))
								.addGroup(gl_pPanel.createParallelGroup(Alignment.TRAILING, false)
									.addComponent(totalText)
									.addComponent(elapsedText, GroupLayout.DEFAULT_SIZE, 59, Short.MAX_VALUE)))
							.addContainerGap(338, Short.MAX_VALUE))
				);
				gl_pPanel.setVerticalGroup(
					gl_pPanel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_pPanel.createSequentialGroup()
							.addComponent(urlText, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(trackText, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addGroup(gl_pPanel.createParallelGroup(Alignment.BASELINE)
								.addComponent(playButt)
								.addComponent(pauseButt)
								.addComponent(stopButt))
							.addGap(18)
							.addComponent(navSlider, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(elapsedText, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(totalText, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addContainerGap(44, Short.MAX_VALUE))
				);
				pPanel.setLayout(gl_pPanel);
				
				final Timer time = new Timer(1000, elapsedListener);
				time.setDelay(1000);
				
				//ActionEvent e = new ActionEvent(e, size, totalTime);
				
				ActionListener playListener = new ActionListener(){
					public void actionPerformed(ActionEvent e){
						playAction(players.player, time);
					}
				};
				
				playButt.addActionListener(playListener);
				
				
				ActionListener pauseListener = new ActionListener(){
					public void actionPerformed(ActionEvent e){
						pauseAction(players.player, time);
					}
				};
				
				pauseButt.addActionListener(pauseListener);
				
				ActionListener stopListener = new ActionListener(){
					public void actionPerformed(ActionEvent e){
						stopAction(players.player, time);
					}
				};
				
				stopButt.addActionListener(stopListener);
				
				
				
				

			} catch (Exception ex) {
				ex.printStackTrace();
			}

		}
	public void playAction(Player player, Timer time){
		if(player.getState() != Player.Started){	
			player.syncStart(player.getTimeBase().getTime());
			player.start();
			player.setStopTime(new Time((long)(player.getDuration().getSeconds() - player.getMediaTime().getSeconds())));
			time.start();
		}
	}
	
	public void pauseAction(Player player, Timer time){
		player.stop();
		time.stop();
	}
	
	public void stopAction(Player player, Timer time){
		player.stop();
		player.setStopTime(Clock.RESET);
		time.stop();
		time.restart();
		
	}
	public elapsedTime getElapse() {
		return elapse;
	}
	public void setElapse(elapsedTime elapse) {
		this.elapse = elapse;
	}
		
}