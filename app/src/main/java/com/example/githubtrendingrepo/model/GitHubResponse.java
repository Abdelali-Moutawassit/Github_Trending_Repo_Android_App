package com.example.githubtrendingrepo.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class GitHubResponse {
    @SerializedName("items")
    private List<GitHubRepo> items;

    public List<GitHubRepo> getItems() {
        return items;
    }
}
