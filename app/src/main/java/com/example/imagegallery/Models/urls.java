package com.example.imagegallery.Models;

import com.google.gson.annotations.SerializedName;

public class urls{

    @SerializedName("regular")
    String regular;

    @SerializedName("thumb")
    String thumb;

    public urls(String regular, String thumb) {
        this.regular = regular;
        this.thumb = thumb;
    }

    public String getRegular() {
        return regular;
    }

    public String getThumb() {
        return thumb;
    }
}
