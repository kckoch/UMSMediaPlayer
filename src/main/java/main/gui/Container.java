package main.gui;

import java.util.*;

public class Container {
    private int id;
    private String name;

    public Container() {
        id = 0;
<<<<<<< HEAD
        str = "";
=======
        name = "";
>>>>>>> 2213bc2503a923861de387851533a882c3ccb7c0
    }

    public Container(int id, String str) {
        this.id = id;
<<<<<<< HEAD
        this.name = name;
=======
        this.name = str;
>>>>>>> 2213bc2503a923861de387851533a882c3ccb7c0
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
