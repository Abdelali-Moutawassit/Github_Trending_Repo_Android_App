package com.example.githubtrendingrepo.model;

import com.google.gson.annotations.SerializedName;

public class GitHubRepo {

    @SerializedName("name")
    private String repoName;

    @SerializedName("description")
    private String repoDescription;

    @SerializedName("stargazers_count")
    private int numberOfStars;

    @SerializedName("owner")
    private Owner owner;

    public String getRepoName() {
        return repoName;
    }

    public String getRepoDescription() {
        return repoDescription;
    }

    public int getNumberOfStars() {
        return numberOfStars;
    }

    public String getRepoOwnerName() {
        return owner != null ? owner.login : "Unknown";
    }

    // inner class to map the "owner" object
    public static class Owner {
        @SerializedName("login")
        public String login;
    }
}
