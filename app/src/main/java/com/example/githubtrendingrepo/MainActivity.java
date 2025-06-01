package com.example.githubtrendingrepo;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.githubtrendingrepo.model.GitHubRepo;
import com.example.githubtrendingrepo.presenter.RepoListContract;
import com.example.githubtrendingrepo.presenter.RepoListPresenter;

import java.util.List;

public class MainActivity extends AppCompatActivity implements RepoListContract.View{


    private RecyclerView recyclerView;
    private RepoAdapter adapter;
    private RepoListPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
//        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
//            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
//            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
//            return insets;
//        });
        recyclerView = findViewById(R.id.recyclerViewRepos);
//        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        adapter = new RepoAdapter();
        recyclerView.setAdapter(adapter);

        presenter = new RepoListPresenter(this);
        presenter.fetchTrendingRepositories();
    }

    @Override
    public void showLoading() {

    }

    @Override
    public void hideLoading() {

    }

    @Override
    public void showRepositories(List<GitHubRepo> repoList) {
        adapter.setRepoList(repoList);
    }

    @Override
    public void showError(String message) {
        android.widget.Toast.makeText(this, message, android.widget.Toast.LENGTH_SHORT).show();
    }
}