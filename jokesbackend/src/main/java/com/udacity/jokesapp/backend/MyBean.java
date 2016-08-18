package com.udacity.jokesapp.backend;

/** The object model for the data we are sending through endpoints */
public class MyBean {

    private String joke;

    public String getJoke() {
        return joke;
    }

    public void setJoke(String data) {
        joke = data;
    }
}