package com.example.githubtrendingrepo.presenter;

import com.example.githubtrendingrepo.model.GitHubRepo;
import com.example.githubtrendingrepo.model.GitHubResponse;
import com.example.githubtrendingrepo.network.ApiClient;
import com.example.githubtrendingrepo.network.ApiService;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class RepoListPresenter implements RepoListContract.Presenter {

    private RepoListContract.View view;

    @Override
    public void attachView(RepoListContract.View view) {
        this.view = view;
    }

    @Override
    public void detachView() {
        this.view = null;
    }

    @Override
    public void fetchTrendingRepositories() {
        if (view != null) {
            view.showLoading();
        }

        ApiService apiService = ApiClient.getApiService();
        String dateQuery = "created:>2024-05-01";
        Call<GitHubResponse> call = apiService.getTrendingRepositories(dateQuery, "stars", "desc", 30);

        call.enqueue(new Callback<GitHubResponse>() {
            @Override
            public void onResponse(Call<GitHubResponse> call, Response<GitHubResponse> response) {
                if (view != null) {
                    view.hideLoading();
                    if (response.isSuccessful() && response.body() != null) {
                        List<GitHubRepo> items = response.body().getItems();
                        view.showRepositories(items);
                    } else {
                        view.showError("Erreur lors du chargement des données.");
                    }
                }
            }

            @Override
            public void onFailure(Call<GitHubResponse> call, Throwable t) {
                if (view != null) {
                    view.hideLoading();
                    view.showError(t.getMessage());
                }
            }
        });
    }
}
