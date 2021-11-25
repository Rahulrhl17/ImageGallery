package com.example.imagegallery.Models;

import com.google.gson.annotations.SerializedName;

public class results {

    @SerializedName("urls")
    urls urls;

    public results(com.example.imagegallery.Models.urls urls) {
        this.urls = urls;
    }

    public com.example.imagegallery.Models.urls getUrls() {
        return urls;
    }
}

