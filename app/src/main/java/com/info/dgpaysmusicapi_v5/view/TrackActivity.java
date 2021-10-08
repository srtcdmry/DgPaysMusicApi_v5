package com.info.dgpaysmusicapi_v5.view;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.info.dgpaysmusicapi_v5.MainActivity;
import com.info.dgpaysmusicapi_v5.MyMediaPlayer;
import com.info.dgpaysmusicapi_v5.R;
import com.info.dgpaysmusicapi_v5.adapter.TrackAdapter;
import com.info.dgpaysmusicapi_v5.databinding.ActivityPlaylistBinding;
import com.info.dgpaysmusicapi_v5.databinding.ActivityTrackBinding;
import com.info.dgpaysmusicapi_v5.model.Tracks;
import com.info.dgpaysmusicapi_v5.view_model.TrackViewModel;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class TrackActivity extends AppCompatActivity implements TrackAdapter.ItemListener  {

    private static final String TAG = TrackActivity.class.getSimpleName();

    private LinearLayoutManager layoutManager;
    private ArrayList<Tracks> tracksArrayList = new ArrayList<>();
    TrackViewModel trackViewModel;
    private TrackAdapter adapter;
   private MediaPlayer mediaPlayer = new MediaPlayer();
    private Button button;
    public ActivityTrackBinding trackBinding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        trackBinding = ActivityTrackBinding.inflate(getLayoutInflater());
        View view = trackBinding.getRoot();
        setContentView(view);
        init();
    }

    private void init() {

        layoutManager = new LinearLayoutManager(TrackActivity.this);
        trackBinding.recyclerView.setLayoutManager(layoutManager);
        trackBinding.recyclerView.setHasFixedSize(true);
        adapter = new TrackAdapter(TrackActivity.this, tracksArrayList);
        adapter.setItemListener(this);
        trackBinding.recyclerView.setAdapter(adapter);
        trackViewModel = ViewModelProviders.of(this).get(TrackViewModel.class);

        trackViewModel.getTrackResponseLiveData().observe(this, trackResponse -> {
            if (trackResponse != null && trackResponse.getData() != null && !trackResponse.getData().isEmpty()) {

                trackBinding.progressBar.setVisibility(View.GONE);
                List<Tracks> tracksList = trackResponse.getData();
                tracksArrayList.addAll(tracksList);
                adapter.notifyDataSetChanged();
            }
        });
    }

    String music = null;

    @Override
    public void onItemClicked(Tracks tracks) {
        //Toast.makeText(this, tracks.getPreview()+"asdas", Toast.LENGTH_SHORT).show();
        if(music == null)  {
            music = tracks.getPreview();
            MyMediaPlayer.getMediaPlayerInstance().playAudioFile(this,music);

        }else if (music == tracks.getPreview()) {
            MyMediaPlayer.getMediaPlayerInstance().stopAudioFile();
            music = null;
        }
        else {
            music =tracks.getPreview();
            MyMediaPlayer.getMediaPlayerInstance().playAudioFile(this,music);
        }
    }
}


