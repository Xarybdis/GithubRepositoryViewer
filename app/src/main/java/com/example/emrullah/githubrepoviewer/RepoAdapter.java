package com.example.emrullah.githubrepoviewer;

import android.media.Image;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

public class RepoAdapter extends RecyclerView.Adapter<RepoAdapter.RepoViewHolder> {

    private ArrayList<RepoItem> mRepoList;
    private OnItemClickListener mListener;

    public  interface OnItemClickListener{
        void onItemClick(int position);
    }

    public void setOnClickItemListener(OnItemClickListener listener){
        mListener=listener;
    }

    public static class RepoViewHolder extends RecyclerView.ViewHolder{

        @BindView(R.id.iv_owner)
        ImageView imageview;
        @BindView(R.id.tv_language)
        TextView repoLanguage;
        @BindView(R.id.tv_repo_name)
        TextView repoName;

        public RepoViewHolder(@NonNull View itemView, final OnItemClickListener listener) {
            super(itemView);
            ButterKnife.bind(this,itemView);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (listener!=null){
                        int position =getAdapterPosition();
                        if (position!=RecyclerView.NO_POSITION){
                            listener.onItemClick(position);
                        }
                    }
                }
            });

        }
    }

    public RepoAdapter(ArrayList<RepoItem> repoList){
        mRepoList=repoList;
    }

    @NonNull
    @Override
    public RepoViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.repo_item,viewGroup,false);
        RepoViewHolder viewHolder = new RepoViewHolder(view,mListener);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull RepoViewHolder repoViewHolder, int position) {
        RepoItem repoItem= mRepoList.get(position);

        repoViewHolder.repoName.setText(repoItem.get_RepoText());
        repoViewHolder.repoLanguage.setText(repoItem.get_LanguageText());
        Picasso.get().load(repoItem.get_ImageResource()).into(repoViewHolder.imageview);
        //repoViewHolder.imageview.setImageResource(repoItem.get_ImageResource());
    }

    @Override
    public int getItemCount() {
        return mRepoList.size();
    }



}
