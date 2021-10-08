package com.info.dgpaysmusicapi_v5.repository;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.info.dgpaysmusicapi_v5.MainActivity;
import com.info.dgpaysmusicapi_v5.constants.AppConstants;
import com.info.dgpaysmusicapi_v5.response.ArticleResponse;
import com.info.dgpaysmusicapi_v5.response.TrackResponse;
import com.info.dgpaysmusicapi_v5.retrofit.ApiRequest;
import com.info.dgpaysmusicapi_v5.retrofit.RetrofitRequest;
import com.info.dgpaysmusicapi_v5.view.PlayListArtistActivity;
import com.info.dgpaysmusicapi_v5.view.TrackActivity;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class TrackRepository {

    private static final String TAG = TrackRepository.class.getSimpleName();
    private final ApiRequest apiRequest;


    public TrackRepository(){
        apiRequest = RetrofitRequest.getRetrofitInstance().create(ApiRequest.class);
    }

    public LiveData<TrackResponse> TrackResponse() {
        final MutableLiveData<TrackResponse> data = new MutableLiveData<>();
        apiRequest.getTrackResponse(AppConstants.search)
                .enqueue(new Callback<TrackResponse>() {
                    @Override
                    public void onResponse(Call<TrackResponse> call, Response<TrackResponse> response) {
                        if(response.body()!=null) {
                            data.setValue(response.body());
                        }
                    }

                    @Override
                    public void onFailure(Call<TrackResponse> call, Throwable t) {
                        data.setValue(null);
                    }
                });

        return data;
    }
}
