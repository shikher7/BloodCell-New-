package com.example.shikher.bloodcell.Utils;



public class JsonList {
    String name, imageUrl;

    public JsonList(String name, String imageUrl) {
        this.name = name;
        this.imageUrl = imageUrl;
    }

    public String getName() {
        return name;
    }

    public String getImageUrl() {
        return imageUrl;
    }
}
