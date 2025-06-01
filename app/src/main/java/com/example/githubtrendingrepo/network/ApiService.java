package com.example.githubtrendingrepo.network;

import com.example.githubtrendingrepo.model.GitHubResponse;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface ApiService {

    @GET("search/repositories")
    Call<GitHubResponse> getTrendingRepositories(
            @Query("q") String createdQuery,
            @Query("sort") String sortBy,
            @Query("order") String order,
            @Query("per_page") int perPage
    );
}
