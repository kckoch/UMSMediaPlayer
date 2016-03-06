package main.gui;

import java.util.*;

public class Container {
    private int id, pid;
    private long duration;
    private String name, url;

    public Container() {
        id = 0;
        name = "";
    }

    public Container(int id, int pid, long duration, String url, String str) {
        this.id = id;
        this.pid = pid;
        this.duration = duration;
        this.name = str;
        this.url = url;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String str) {
        this.name = str;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }
    
    public String getUrl(){
    	return url;
    }
    
    public long getDuration() {
    	return duration;
    }
}
