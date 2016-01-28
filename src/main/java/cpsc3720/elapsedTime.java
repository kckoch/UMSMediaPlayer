package cpsc3720;

public class elapsedTime {
	private static int seconds;
	static String elapsedString;

	public elapsedTime(){
		setSeconds(0);
		elapsedString = "" + getSeconds();
	}

	public static int getSeconds() {
		return seconds;
	}

	public static void setSeconds(int sec) {
		elapsedTime.seconds = sec;
	}
	
}
