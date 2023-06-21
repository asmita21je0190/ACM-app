package com.acmiitism.acm;

public class Achievements {
    private String title,imageURL,description;

    public Achievements(){}

    public Achievements(String title, String imageURL, String description){
        this.title = title;
        this.imageURL = imageURL;
        this.description = description;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getImageURL() {
        return imageURL;
    }

    public void setImageURL(String imageURL) {
        this.imageURL = imageURL;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
