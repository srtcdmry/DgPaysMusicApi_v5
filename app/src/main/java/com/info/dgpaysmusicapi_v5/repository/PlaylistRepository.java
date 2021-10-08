package com.info.dgpaysmusicapi_v5.repository;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.info.dgpaysmusicapi_v5.MainActivity;
import com.info.dgpaysmusicapi_v5.constants.AppConstants;
import com.info.dgpaysmusicapi_v5.response.PlaylistResponse;
import com.info.dgpaysmusicapi_v5.response.TrackResponse;
import com.info.dgpaysmusicapi_v5.retrofit.ApiRequest;
import com.info.dgpaysmusicapi_v5.retrofit.RetrofitRequest;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class PlaylistRepository {

    private static final String TAG = PlaylistRepository.class.getSimpleName();
    private final ApiRequest apiRequest;


    public PlaylistRepository(){
        apiRequest = RetrofitRequest.getRetrofitInstance().create(ApiRequest.class);
    }

    public LiveData<PlaylistResponse> PlaylistResponse() {
        final MutableLiveData<PlaylistResponse> data = new MutableLiveData<>();
        apiRequest.getPlaylistResponse(AppConstants.search)
                .enqueue(new Callback<PlaylistResponse>() {
                    @Override
                    public void onResponse(Call<PlaylistResponse> call, Response<PlaylistResponse> response) {
                        if(response.body()!=null) {
                            data.setValue(response.body());
                        }
                    }

                    @Override
                    public void onFailure(Call<PlaylistResponse> call, Throwable t) {
                        data.setValue(null);
                    }
                });

        return data;
    }
}
