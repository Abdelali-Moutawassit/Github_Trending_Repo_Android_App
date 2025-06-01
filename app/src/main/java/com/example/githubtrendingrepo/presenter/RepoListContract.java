package com.example.githubtrendingrepo.presenter;
import java.util.List;
import com.example.githubtrendingrepo.model.GitHubRepo;

public interface RepoListContract {
    interface View {
        void showLoading();
        void hideLoading();
        void showRepositories(List<GitHubRepo> repoList);
        void showError(String message);
    }

    interface Presenter {
        void attachView(View view);
        void detachView();
        void fetchTrendingRepositories();
    }
}
