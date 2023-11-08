package com.biie.tenantfeedback;
public class FeedModel {

    private String feed_name;
    private int feed_rating;
    private int feed_image;

    // Constructor
    public FeedModel(String feed_name, int feed_rating, int feed_image) {
        this.feed_name = feed_name;
        this.feed_rating = feed_rating;
        this.feed_image = feed_image;
    }

    // Getter and Setter
    public String getFeed_name() {
        return feed_name;
    }

    public void setFeed_name(String feed_name) {
        this.feed_name = feed_name;
    }

    public int getFeed_rating() {
        return feed_rating;
    }

    public void setFeed_rating(int feed_rating) {
        this.feed_rating = feed_rating;
    }

    public int getFeed_image() {
        return feed_image;
    }

    public void setFeed_image(int feed_image) {
        this.feed_image = feed_image;
    }
}
