
public class Settings {

	int PIN, profilePicID, configureN;
	String serverURL;
	
	Settings(int _PIN, int _profilePicID, int _configureN, String _serverURL )
	{
		this.PIN = _PIN;
		this.profilePicID = _profilePicID;
		this.configureN = _configureN;
		this.serverURL = _serverURL;
	}

	public int getPIN() {
		return PIN;
	}

	public void setPIN(int PIN) {
		this.PIN = PIN;
	}

	public int getprofilePicID() {
		return profilePicID;
	}

	public void setprofilePicID(int profilePicID) {
		this.profilePicID = profilePicID;
	}

	public int getconfigureN() {
		return configureN;
	}

	public void setconfigureN(int configureN) {
		this.configureN = configureN;
	}

	public String getserverURL() {
		return serverURL;
	}

	public void setserverURL(String serverURL) {
		this.serverURL = serverURL;
	}
	

}
