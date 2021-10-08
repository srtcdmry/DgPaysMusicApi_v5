package com.info.dgpaysmusicapi_v5.view;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.info.dgpaysmusicapi_v5.R;
import com.info.dgpaysmusicapi_v5.adapter.ArticleAdapter;
import com.info.dgpaysmusicapi_v5.databinding.ActivityArticleBinding;
import com.info.dgpaysmusicapi_v5.databinding.ActivityTrackBinding;
import com.info.dgpaysmusicapi_v5.model.Article;
import com.info.dgpaysmusicapi_v5.view_model.ArticleViewModel;

import java.util.ArrayList;
import java.util.List;

public class ArticleActivity extends AppCompatActivity implements ArticleAdapter.ItemListener2 {

    private static final String TAG = ArticleActivity.class.getSimpleName();
    private LinearLayoutManager layoutManager;
    private ArrayList<Article> articleArrayList = new ArrayList<>();
    ArticleViewModel articleViewModel;
    private ArticleAdapter adapter;
    public ActivityArticleBinding articleBinding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        articleBinding = ActivityArticleBinding.inflate(getLayoutInflater());
        View view = articleBinding.getRoot();
        setContentView(view);
        init();
    }

    private void init() {

        articleBinding.recyclerView.setHasFixedSize(true);
        GridLayoutManager mLayoutManager = new GridLayoutManager(this,2);
        articleBinding.recyclerView.setLayoutManager(mLayoutManager);
        adapter = new ArticleAdapter(ArticleActivity.this,articleArrayList);
        adapter.setItemListener(this);
        articleBinding.recyclerView.setAdapter(adapter);
        articleViewModel = ViewModelProviders.of(this).get(ArticleViewModel.class);
        DividerItemDecoration id = new DividerItemDecoration(this,mLayoutManager.getOrientation());
        articleBinding.recyclerView.addItemDecoration(id);

        articleViewModel.getBashboardNewsResponseLiveData().observe(this,articleResponse ->{
            if(articleResponse != null && articleResponse.getArticles()!=null && !articleResponse.getArticles().isEmpty()) {
                articleBinding.progressBar.setVisibility(View.GONE);
                List<Article> articleList = articleResponse.getArticles();
                articleArrayList.addAll(articleList);
                adapter.notifyDataSetChanged();
            }
        } );
    }

    @Override
    public void onItemClicked(Article article) {
        Intent intent = new Intent(ArticleActivity.this,PlayListArtistActivity.class);
        String key = article.getName();
        //Toast.makeText(this, key, Toast.LENGTH_LONG).show();
        intent.putExtra("name",key);
        String picture = article.getPicture_medium();
        intent.putExtra("picture",picture);
        startActivity(intent);
    }
}