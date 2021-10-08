package com.info.dgpaysmusicapi_v5.response;

import android.provider.MediaStore;

import com.google.gson.annotations.SerializedName;
import com.info.dgpaysmusicapi_v5.model.Article;
import com.info.dgpaysmusicapi_v5.model.Tracks;

import java.util.List;

public class TrackResponse {

    @SerializedName("data")
    private List<Tracks> data;

    public List<Tracks> getData() {
        return data;
    }

    public void setData(List<Tracks> data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "TrackResponse{" +
                "data=" + data +
                '}';
    }
}
