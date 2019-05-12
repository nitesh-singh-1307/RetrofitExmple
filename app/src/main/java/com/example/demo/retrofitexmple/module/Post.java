package com.example.demo.retrofitexmple.module;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public abstract class Post {
    @Expose
    @SerializedName("id")
    private int id;
    @Expose
    @SerializedName("userId")
    private int userId;
    @Expose
    @SerializedName("body")
    private String body;
    @Expose
    @SerializedName("title")
    private String title;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
