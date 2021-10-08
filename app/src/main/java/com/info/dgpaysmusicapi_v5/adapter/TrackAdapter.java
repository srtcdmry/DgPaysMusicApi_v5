package com.info.dgpaysmusicapi_v5.adapter;

import android.content.Context;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.provider.MediaStore;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.info.dgpaysmusicapi_v5.R;
import com.info.dgpaysmusicapi_v5.model.Article;
import com.info.dgpaysmusicapi_v5.model.Artist;
import com.info.dgpaysmusicapi_v5.model.Tracks;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import retrofit2.http.Tag;

public class TrackAdapter extends RecyclerView.Adapter<TrackAdapter.ViewHolder> {


    private final Context context;
    ArrayList<Tracks> trackArrayList;
    private String mduration;
    private String sduration;
    private Button button;
    private MediaPlayer md;
    ItemListener itemListener;
    public TrackAdapter(Context context, ArrayList<Tracks> tracksArrayList) {
        this.context = context;
        this.trackArrayList = tracksArrayList;
    }

    @NonNull
    @Override
    public TrackAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.new_tracks, parent, false);

        return new TrackAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull TrackAdapter.ViewHolder holder, int position) {
        Tracks tracks = trackArrayList.get(position);

        holder.title.setText(tracks.getTitle());
        holder.id.setText(tracks.artist.getName());
        String s = tracks.getDuration().toString();
        //holder.duration.setText(tracks.getPreview());
        holder.bindItem(tracks);



        if (s.length() == 3) {
            mduration = s.substring(0, 1);
            sduration = s.substring(1, 3);
        } else if (s.length() == 4) {
            mduration = s.substring(0, 2);
            sduration = s.substring(2, 4);
        } else {
            mduration = "0";
            sduration = s;
        }
        holder.duration.setText(mduration + ":" + sduration);

    }

    @Override
    public int getItemCount() {
        return trackArrayList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        public final TextView id;
        private final TextView title;
        private final TextView duration;
        private final TextView preview;
        Tracks tracks;

        public ViewHolder(@NonNull View itemView ) {
            super(itemView);
            id = itemView.findViewById(R.id.track_artist);
            title = itemView.findViewById(R.id.track_title);
            duration = itemView.findViewById(R.id.durationView);
            preview = itemView.findViewById(R.id.textPreview);
            itemView.setOnClickListener(this);


        }

        public void bindItem(Tracks tracks) {
            this.tracks=tracks;
            duration.setText(tracks.getPreview());
        }

        @Override
        public void onClick(View view) {
            if(itemListener!=null) {
                itemListener.onItemClicked(tracks);
            }
        }
    }
    public interface ItemListener{
        public void onItemClicked(Tracks tracks);
    }

    public void setItemListener(ItemListener itemListener){
        this.itemListener = itemListener;
    }
}




