package com.info.dgpaysmusicapi_v5;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.provider.SyncStateContract;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ProgressBar;

import com.info.dgpaysmusicapi_v5.adapter.ArticleAdapter;
import com.info.dgpaysmusicapi_v5.adapter.TrackAdapter;
import com.info.dgpaysmusicapi_v5.constants.AppConstants;
import com.info.dgpaysmusicapi_v5.databinding.ActivityMainBinding;
import com.info.dgpaysmusicapi_v5.model.Article;
import com.info.dgpaysmusicapi_v5.model.Tracks;
import com.info.dgpaysmusicapi_v5.view.AlbumActivity;
import com.info.dgpaysmusicapi_v5.view.ArticleActivity;
import com.info.dgpaysmusicapi_v5.view.PlaylistActivity;
import com.info.dgpaysmusicapi_v5.view.TrackActivity;
import com.info.dgpaysmusicapi_v5.view_model.ArticleViewModel;
import com.info.dgpaysmusicapi_v5.view_model.TrackViewModel;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

private ActivityMainBinding mainBind ;
    private static final String TAG = MainActivity.class.getSimpleName();
    private LinearLayoutManager layoutManager;
    private final ArrayList<Article> articleArrayList = new ArrayList<>();
    ArticleViewModel articleViewModel;
    private ArticleAdapter adapter;
    //public static String search;
    private ArrayList<Tracks> tracksArrayList = new ArrayList<>();
    TrackViewModel trackViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mainBind = DataBindingUtil.setContentView(this, R.layout.activity_main); // data binding yoluyla bağlandı

        mainBind.tracksButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, TrackActivity.class);
                AppConstants.search = mainBind.editText.getText().toString();
                startActivity(intent);
            }
        });

        mainBind.artistButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (mainBind.editText.getText().toString().length() > 0) {
                    Intent intent = new Intent(MainActivity.this, ArticleActivity.class);
                    AppConstants.search = mainBind.editText.getText().toString();
                    startActivity(intent);
                }
            }
        });

        mainBind.playlistButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (mainBind.editText.getText().toString().length() > 0) {

                    Intent intent = new Intent(MainActivity.this, PlaylistActivity.class);
                    AppConstants.search = mainBind.editText.getText().toString();
                    startActivity(intent);
                }
            }
        });

        mainBind.albumButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (mainBind.editText.getText().toString().length() > 0) {
                    Intent intent = new Intent(MainActivity.this, AlbumActivity.class);
                   AppConstants.search = mainBind.editText.getText().toString();
                    startActivity(intent);
                }
            }
        });

    }

}
        //  init();
        //getArticles();

//
//    private void getArticles() {
//
//        articleViewModel.getBashboardNewsResponseLiveData().observe(this, articleResponse -> {
//            if (articleResponse != null && articleResponse.getArticles() != null && !articleResponse.getArticles().isEmpty()) {
//
//                mainBind.progress_bar.setVisibility(View.GONE);
//                List<Article> articleList = articleResponse.getArticles();
//                articleArrayList.addAll(articleList);
//                adapter.notifyDataSetChanged();
//
//            }
//
//        });
//    }
//
//    private void init() {
//        progress_bar = findViewById(R.id.progress_bar);
//        recycler_View = findViewById(R.id.recycler_view);
//        layoutManager = new LinearLayoutManager(MainActivity.this);
//
//        recycler_View.setLayoutManager(layoutManager);
//        recycler_View.setHasFixedSize(true);
//        adapter = new ArticleAdapter(MainActivity.this, articleArrayList);
//        recycler_View.setAdapter(adapter);
//        articleViewModel = ViewModelProviders.of(this).get(ArticleViewModel.class);

//        articleViewModel.getBashboardNewsResponseLiveData().observe(this,articleResponse ->{
//            if(articleResponse != null && articleResponse.getArticles()!=null && !articleResponse.getArticles().isEmpty()) {
//
//                progress_bar.setVisibility(View.GONE);
//                List<Article> articleList = articleResponse.getArticles();
//                articleArrayList.addAll(articleList);
//                adapter.notifyDataSetChanged();
//
//            }
//
//        } );



