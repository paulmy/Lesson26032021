package ru.samsung.lesson12032021;


import java.io.Serializable;

public class User implements Serializable {
    private long id;
    private String name;
    private int year;

    public User(long id, String name, int year) {
        this.id = id;
        this.name = name;
        this.year = year;
    }
    public User(String name, int year) {
        this.name = name;
        this.year = year;
    }


    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }


    @Override
    public String toString() {
        return this.name + " : " + this.year;
    }


}
