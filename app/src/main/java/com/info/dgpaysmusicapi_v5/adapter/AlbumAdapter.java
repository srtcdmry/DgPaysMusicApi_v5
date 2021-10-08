package com.info.dgpaysmusicapi_v5.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.info.dgpaysmusicapi_v5.R;
import com.info.dgpaysmusicapi_v5.model.Album;

import java.util.ArrayList;


public class AlbumAdapter extends RecyclerView.Adapter<AlbumAdapter.ViewHolder>{

private final Context context;
        ArrayList<Album> albumArrayList;
        ItemListener4 itemListener;


public AlbumAdapter(Context context,ArrayList<Album> albumArrayList){
        this.context=context;
        this.albumArrayList=albumArrayList;
        }

@NonNull
@Override
public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType){
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.new_album,parent,false);

        return new AlbumAdapter.ViewHolder(view);
        }

@Override
public void onBindViewHolder(@NonNull ViewHolder holder,int position){
        Album album=albumArrayList.get(position);
        holder.tvTitle.setText(album.getTitle());
        Glide.with(context)
        .load(album.getCoverBig())
        .into(holder.imgViewCover);
        holder.bindItem(album);

        }

@Override
public int getItemCount(){
        return albumArrayList.size();
        }

public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

    public final ImageView imgViewCover;
    private final TextView tvTitle;
    Album album;

    public ViewHolder(@NonNull View itemView) {
        super(itemView);
        imgViewCover = itemView.findViewById(R.id.imgViewCover);
        tvTitle = itemView.findViewById(R.id.tvTitle);
        itemView.setOnClickListener(this);
    }

    public void bindItem(Album album) {
        this.album = album;
        tvTitle.setText(album.getTitle());
    }

    @Override
    public void onClick(View view) {
        if (itemListener != null) {
            itemListener.onItemClicked(album);
        }
    }
}

public interface ItemListener4 {
    void onItemClicked(Album album);

}

    public void setItemListener(ItemListener4 itemListener) {
        this.itemListener = itemListener;
    }
}

