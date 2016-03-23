package main.gui;

public class Container {
    private int id;
    private String name;

    public Container() {
        id = 0;
        name = "";
    }

    public Container(int id, String str) {
        this.id = id;
        this.name = str;
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
}
