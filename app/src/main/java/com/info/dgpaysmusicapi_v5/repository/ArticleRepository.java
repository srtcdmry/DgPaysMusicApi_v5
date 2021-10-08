package com.info.dgpaysmusicapi_v5.repository;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.info.dgpaysmusicapi_v5.constants.AppConstants;
import com.info.dgpaysmusicapi_v5.response.ArticleResponse;
import com.info.dgpaysmusicapi_v5.retrofit.ApiRequest;
import com.info.dgpaysmusicapi_v5.retrofit.RetrofitRequest;
import com.info.dgpaysmusicapi_v5.MainActivity;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ArticleRepository {

    private static final String TAG = ArticleRepository.class.getSimpleName();
    private final ApiRequest apiRequest;


    public ArticleRepository(){
        apiRequest = RetrofitRequest.getRetrofitInstance().create(ApiRequest.class);
    }

    public LiveData<ArticleResponse> getDashBoardNews() {
        final MutableLiveData<ArticleResponse> data = new MutableLiveData<>();
        apiRequest.getTopHeadlines(AppConstants.search)
                .enqueue(new Callback<ArticleResponse>() {
                    @Override
                    public void onResponse(Call<ArticleResponse> call, Response<ArticleResponse> response) {
                        if(response.body()!=null) {
                            data.setValue(response.body());
                        }
                    }

                    @Override
                    public void onFailure(Call<ArticleResponse> call, Throwable t) {
                        data.setValue(null);
                    }
                });

        return data;
    }
}
