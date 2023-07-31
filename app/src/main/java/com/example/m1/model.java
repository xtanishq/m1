package com.example.m1;

public class model {

    String id,title;


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public model(String title, String id) {

        this.title = title;
        this.id = id;
    }
}





