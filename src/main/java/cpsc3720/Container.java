package cpsc3720;

public class Container {
	int id, pid, childcnt;
	String title, url;
	
	public Container(int id, int pid, int childcnt, String title, String url) {
		this.id = id;
		this.pid =  pid;
		this.childcnt = childcnt;
		this.title = title;
		this.url = url;
	}
	
	public String getTitle() {
		return title;
	}

	public int getID() {
		return id;
	}

	public int getPid() {
		return pid;
	}

	public int getChildCount() {
		return childcnt;
	}

	public String getUrl() {
		return url;
	}
}
