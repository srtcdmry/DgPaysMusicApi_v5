package com.info.dgpaysmusicapi_v5.adapter;


import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.info.dgpaysmusicapi_v5.R;
import com.info.dgpaysmusicapi_v5.model.Article;

import java.util.ArrayList;

public class ArticleAdapter extends RecyclerView.Adapter<ArticleAdapter.ViewHolder> {

    private final Context context;
    ArrayList<Article> articleArrayList;
    ItemListener2 itemListener;


    public ArticleAdapter(Context context, ArrayList<Article> articleArrayList) {
        this.context = context;
        this.articleArrayList = articleArrayList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.new_item,parent,false);

        return new ArticleAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Article article = articleArrayList.get(position);
        holder.tvTitle.setText(article.getName());
        Glide.with(context)
                .load(article.getPicture_medium())
                .into(holder.imgViewCover);
        holder.bindItem(article);

    }

    @Override
    public int getItemCount() {
        return articleArrayList.size();
    }

    public class ViewHolder extends  RecyclerView.ViewHolder implements View.OnClickListener{

        public final ImageView imgViewCover;
        private final TextView tvTitle;
        Article article;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            imgViewCover = itemView.findViewById(R.id.imgViewCover);
            tvTitle = itemView.findViewById(R.id.tvTitle);
            itemView.setOnClickListener(this);
        }

        public void bindItem(Article article) {
            this.article=article;
            tvTitle.setText(article.getName());
        }
        @Override
        public void onClick(View view) {
            if(itemListener!=null) {
                itemListener.onItemClicked(article);
            }
        }
    }
    public interface ItemListener2{
        public void onItemClicked(Article article);
    }

    public void setItemListener(ItemListener2 itemListener) {
        this.itemListener=itemListener;
    }
}
