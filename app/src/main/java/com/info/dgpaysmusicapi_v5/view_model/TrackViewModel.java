package com.info.dgpaysmusicapi_v5.view_model;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.info.dgpaysmusicapi_v5.repository.ArticleRepository;
import com.info.dgpaysmusicapi_v5.repository.TrackRepository;
import com.info.dgpaysmusicapi_v5.response.ArticleResponse;
import com.info.dgpaysmusicapi_v5.response.TrackResponse;

public class TrackViewModel extends AndroidViewModel {

    private TrackRepository trackRepository;
    private LiveData<TrackResponse> trackResponseLiveData;

    public TrackViewModel(@NonNull Application application) {

        super(application);
        trackRepository = new TrackRepository();
        this.trackResponseLiveData = trackRepository.TrackResponse();
    }

    public LiveData<TrackResponse> getTrackResponseLiveData(){
        return trackResponseLiveData;
    }

}
