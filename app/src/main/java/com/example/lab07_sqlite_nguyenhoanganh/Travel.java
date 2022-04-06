package com.example.lab07_sqlite_nguyenhoanganh;

public class Travel {
    private int id;
    private String name;

    public Travel(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public Travel(String name) {
        this.name = name;
    }

    public Travel() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
