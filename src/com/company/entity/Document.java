package com.company.entity;

public class Document {
    private int number;
    private String title;
    private Picture picture;

    public Document(int number, String title, Picture picture) {
        this.number = number;
        this.title = title;
        this.picture = picture;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Picture getPicture() {
        return picture;
    }

    public void setPicture(Picture picture) {
        this.picture = picture;
    }
}
