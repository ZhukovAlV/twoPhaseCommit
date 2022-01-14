package com.company.entity;

import java.net.URL;

public class Picture {
    private int number;
    private URL url;

    public Picture(int number, URL url) {
        this.number = number;
        this.url = url;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public URL getUrl() {
        return url;
    }

    public void setUrl(URL url) {
        this.url = url;
    }
}
