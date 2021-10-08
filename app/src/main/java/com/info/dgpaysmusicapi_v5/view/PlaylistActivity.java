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
import com.info.dgpaysmusicapi_v5.adapter.PlaylistAdapter;
import com.info.dgpaysmusicapi_v5.constants.AppConstants;
import com.info.dgpaysmusicapi_v5.databinding.ActivityAlbumBinding;
import com.info.dgpaysmusicapi_v5.databinding.ActivityPlaylistBinding;
import com.info.dgpaysmusicapi_v5.model.Article;
import com.info.dgpaysmusicapi_v5.model.Playlist;
import com.info.dgpaysmusicapi_v5.view_model.ArticleViewModel;
import com.info.dgpaysmusicapi_v5.view_model.PlaylistViewModel;

import java.util.ArrayList;
import java.util.List;

public class PlaylistActivity extends AppCompatActivity implements PlaylistAdapter.ItemListener3 {

    private static final String TAG = PlaylistActivity.class.getSimpleName();
    private final ArrayList<Playlist> playlistArrayList = new ArrayList<>();
    PlaylistViewModel playlistViewModel;
    private PlaylistAdapter adapter;
    public ActivityPlaylistBinding playlistBinding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        playlistBinding = ActivityPlaylistBinding.inflate(getLayoutInflater());
        View view = playlistBinding.getRoot();
        setContentView(view);
        init();
    }

    private void init() {
        playlistBinding.recyclerView.setHasFixedSize(true);
        GridLayoutManager mLayoutManager = new GridLayoutManager(this, 2);
        playlistBinding.recyclerView.setLayoutManager(mLayoutManager);
        adapter = new PlaylistAdapter(PlaylistActivity.this, playlistArrayList);
        adapter.setItemListener(this);
        playlistBinding.recyclerView.setAdapter(adapter);
        playlistViewModel = ViewModelProviders.of(this).get(PlaylistViewModel.class);
        DividerItemDecoration id = new DividerItemDecoration(this, mLayoutManager.getOrientation());
        playlistBinding.recyclerView.addItemDecoration(id);

        playlistViewModel.getPlaylistResponseLiveData().observe(this, playlistResponse -> {
            if (playlistResponse != null && playlistResponse.getData() != null && !playlistResponse.getData().isEmpty()) {

                playlistBinding.progressBar.setVisibility(View.GONE);
                List<Playlist> playlistList = playlistResponse.getData();
                playlistArrayList.addAll(playlistList);
                adapter.notifyDataSetChanged();
            }
        });
    }

    @Override
    public void onItemClicked(Playlist playlist) {
        Intent intent = new Intent(PlaylistActivity.this, PlayListArtistActivity.class);
        String key = playlist.getTitle();
       // Toast.makeText(this, playlist.getTitle(), Toast.LENGTH_LONG).show();
        intent.putExtra("name", key);
        String picture = playlist.getPictureBig();
        intent.putExtra("picture", picture);
        AppConstants.search = key;
        startActivity(intent);

    }
}