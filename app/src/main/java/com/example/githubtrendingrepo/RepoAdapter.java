package com.example.githubtrendingrepo;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.example.githubtrendingrepo.R;
import com.example.githubtrendingrepo.model.GitHubRepo;

import java.util.ArrayList;
import java.util.List;

public class RepoAdapter extends RecyclerView.Adapter<RepoAdapter.RepoViewHolder> {

    private List<GitHubRepo> repoList = new ArrayList<>();

    public void setRepoList(List<GitHubRepo> repos) {
        this.repoList = repos;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public RepoViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_repo, parent, false);
        return new RepoViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RepoViewHolder holder, int position) {
        GitHubRepo repo = repoList.get(position);
        holder.textViewRepoName.setText(repo.getRepoName());
        holder.textViewRepoDescription.setText(repo.getRepoDescription());
        holder.textViewOwnerName.setText(repo.getRepoOwnerName());
        holder.textViewStars.setText("★ " + repo.getNumberOfStars());
    }

    @Override
    public int getItemCount() {
        return repoList.size();
    }

    static class RepoViewHolder extends RecyclerView.ViewHolder {
        TextView textViewRepoName;
        TextView textViewRepoDescription;
        TextView textViewOwnerName;
        TextView textViewStars;

        public RepoViewHolder(@NonNull View itemView) {
            super(itemView);
            textViewRepoName = itemView.findViewById(R.id.textViewRepoName);
            textViewRepoDescription = itemView.findViewById(R.id.textViewRepoDescription);
            textViewOwnerName = itemView.findViewById(R.id.textViewOwnerName);
            textViewStars = itemView.findViewById(R.id.textViewStars);
        }
    }
}
