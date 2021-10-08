package com.info.dgpaysmusicapi_v5.response;

import com.google.gson.annotations.SerializedName;
import com.info.dgpaysmusicapi_v5.model.Playlist;
import com.info.dgpaysmusicapi_v5.model.Tracks;

import java.util.List;

public class PlaylistResponse {
    @SerializedName("data")
    private List<Playlist> data;

    public List<Playlist> getData() {
        return data;
    }

    public void setData(List<Playlist> data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "PlaylistResponse{" +
                "data=" + data +
                '}';
    }
}
