package com.biie.tenantfeedback.model;
public class FeedModel {

    private String feed_name;
    private String feed_time;
    private String feed_image;


    // Constructor
    public FeedModel(String feed_name, String feed_time, String feed_image) {
        this.feed_name = feed_name;
        this.feed_time = feed_time;
        this.feed_image = feed_image;
    }

    // Getter and Setter
    public String getFeed_name() {
        return feed_name;
    }

    public void setFeed_name(String feed_name) {
        this.feed_name = feed_name;
    }

    public String getFeed_time() {
        return feed_time;
    }
    public void setFeed_time(String feed_time) {
        this.feed_time = feed_time;
    }

    public String getFeed_image() {
        return feed_image;
    }

    public void setFeed_image(String feed_image) {
        this.feed_image = feed_image;
    }

}
