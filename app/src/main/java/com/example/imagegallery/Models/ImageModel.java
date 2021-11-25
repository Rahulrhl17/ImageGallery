package com.example.imagegallery.Models;


import com.google.gson.annotations.SerializedName;

import java.util.List;

public class ImageModel {

    @SerializedName("results")
    List<results> results;

    public ImageModel(List<com.example.imagegallery.Models.results> results) {
        this.results = results;
    }

    public List<com.example.imagegallery.Models.results> getResults() {
        return results;
    }
}
