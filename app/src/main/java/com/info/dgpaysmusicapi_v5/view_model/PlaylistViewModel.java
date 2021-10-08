package com.info.dgpaysmusicapi_v5.view_model;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.info.dgpaysmusicapi_v5.repository.PlaylistRepository;
import com.info.dgpaysmusicapi_v5.repository.TrackRepository;
import com.info.dgpaysmusicapi_v5.response.PlaylistResponse;
import com.info.dgpaysmusicapi_v5.response.TrackResponse;

public class PlaylistViewModel extends AndroidViewModel {

    private PlaylistRepository playlistRepository;
    private LiveData<PlaylistResponse> playlistResponseLiveData;

    public PlaylistViewModel(@NonNull Application application) {

        super(application);
        playlistRepository = new PlaylistRepository();
        this.playlistResponseLiveData = playlistRepository.PlaylistResponse();
    }

    public LiveData<PlaylistResponse> getPlaylistResponseLiveData(){
        return playlistResponseLiveData;
    }

}