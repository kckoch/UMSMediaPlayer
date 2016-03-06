/*
 * This class holds all of the info from a SOAP request
 * This information will be used to create songs and albums
 * Only contains getters and setters
 */
package main.model;

import java.util.*;

public class Container {
    private int id, pid;
    private long duration;
    private String name, url;

    public Container() {
        id = 0;
        pid = 0;
        duration = 0;
        name = "";
        url = "";
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
