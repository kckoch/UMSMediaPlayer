package cpsc3720;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;

import javax.media.CannotRealizeException;
import javax.media.Manager;
import javax.media.MediaLocator;
import javax.media.NoPlayerException;
import javax.media.Player;

public class playerDetail {

	Player player;
	
	public playerDetail(String filename) throws NoPlayerException, CannotRealizeException, MalformedURLException, IOException{
		player = Manager.createRealizedPlayer(new MediaLocator( new File(filename).toURI().toURL()));
	}
	
}
