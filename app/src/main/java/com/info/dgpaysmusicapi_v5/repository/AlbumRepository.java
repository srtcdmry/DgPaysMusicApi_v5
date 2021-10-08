package com.info.dgpaysmusicapi_v5.repository;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.info.dgpaysmusicapi_v5.MainActivity;
import com.info.dgpaysmusicapi_v5.constants.AppConstants;
import com.info.dgpaysmusicapi_v5.response.AlbumResponse;
import com.info.dgpaysmusicapi_v5.response.PlaylistResponse;
import com.info.dgpaysmusicapi_v5.retrofit.ApiRequest;
import com.info.dgpaysmusicapi_v5.retrofit.RetrofitRequest;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class AlbumRepository {

    private static final String TAG = AlbumRepository.class.getSimpleName();
    private final ApiRequest apiRequest;


    public AlbumRepository(){
        apiRequest = RetrofitRequest.getRetrofitInstance().create(ApiRequest.class);
    }

    public LiveData<AlbumResponse> AlbumResponse() {
        final MutableLiveData<AlbumResponse> data = new MutableLiveData<>();
        apiRequest.getAlbumResponse(AppConstants.search)
                .enqueue(new Callback<AlbumResponse>() {
                    @Override
                    public void onResponse(Call<AlbumResponse> call, Response<AlbumResponse> response) {
                        if(response.body()!=null) {
                            data.setValue(response.body());
                        }
                    }

                    @Override
                    public void onFailure(Call<AlbumResponse> call, Throwable t) {
                        data.setValue(null);
                    }
                });

        return data;
    }
}
