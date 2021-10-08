package com.info.dgpaysmusicapi_v5.retrofit;


import com.info.dgpaysmusicapi_v5.response.AlbumResponse;
import com.info.dgpaysmusicapi_v5.response.ArticleResponse;
import com.info.dgpaysmusicapi_v5.response.PlaylistResponse;
import com.info.dgpaysmusicapi_v5.response.TrackResponse;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface ApiRequest {

    @GET("search/artist/?")
    Call<ArticleResponse> getTopHeadlines(@Query("q") String querry);

    @GET("search/track/?")
    Call<TrackResponse> getTrackResponse(@Query("q") String querry);

    @GET("search/playlist/?")
    Call<PlaylistResponse> getPlaylistResponse(@Query("q") String querry);

    @GET("search/album/?")
    Call<AlbumResponse> getAlbumResponse(@Query("q") String querry);

}
