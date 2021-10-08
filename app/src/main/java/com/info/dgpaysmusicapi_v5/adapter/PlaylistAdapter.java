package com.info.dgpaysmusicapi_v5.adapter;

import android.content.Context;
import android.media.MediaPlayer;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.info.dgpaysmusicapi_v5.R;
import com.info.dgpaysmusicapi_v5.model.Playlist;
import com.info.dgpaysmusicapi_v5.model.Tracks;

import java.util.ArrayList;

public class PlaylistAdapter extends RecyclerView.Adapter<PlaylistAdapter.ViewHolder> {

    private final Context context;
    ArrayList<Playlist> playlistArrayList;
    private Button button;
    private MediaPlayer md;
    ItemListener3 itemListener;
    public PlaylistAdapter(Context context, ArrayList<Playlist> playlistArrayList) {
        this.context = context;
        this.playlistArrayList = playlistArrayList;
    }

    @NonNull
    @Override
    public PlaylistAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.new_playlist, parent, false);

        return new PlaylistAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Playlist playlist = playlistArrayList.get(position);
        holder.tvTitle.setText(playlist.getTitle());
        holder.idText.setText(playlist.getTitle().toString());
        Glide.with(context)
                .load(playlist.getPictureBig())
                .into(holder.imgViewCover);
        holder.bindItem(playlist);
        
    }

    @Override
    public int getItemCount() {
        return playlistArrayList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        public final ImageView imgViewCover;
        private final TextView tvTitle;
        private final TextView idText;
        Playlist playlist;

        public ViewHolder(@NonNull View itemView ) {
            super(itemView);
            imgViewCover = itemView.findViewById(R.id.imgViewCover);
            tvTitle = itemView.findViewById(R.id.tvTitle);
            idText = itemView.findViewById(R.id.idText);
            itemView.setOnClickListener(this);


        }

        public void bindItem(Playlist playlist) {
            this.playlist=playlist;
            tvTitle.setText(playlist.getTitle());
        }

        @Override
        public void onClick(View view) {
            if(itemListener!=null) {
                itemListener.onItemClicked(playlist);
            }
        }
    }
    public interface ItemListener3{
        public void onItemClicked(Playlist playlist);
    }

    public void setItemListener(ItemListener3 itemListener){
        this.itemListener = itemListener;
    }
}

