package com.quisy.models;


/**
 * Created by Mariusz on 2016-05-28.
 */
public class StoryAddViewModel {
    private String title;
    private String text;
    private long userId;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
