package com.info.dgpaysmusicapi_v5;

import android.content.Context;
import android.media.AudioManager;
import android.media.MediaPlayer;

import androidx.appcompat.app.AppCompatActivity;

import java.io.IOException;

public class MyMediaPlayer extends AppCompatActivity {
    MediaPlayer mediaPlayer = new MediaPlayer();

    private static MyMediaPlayer Instance;
    //String music = (String) getIntent().getSerializableExtra("key");


    public static MyMediaPlayer getMediaPlayerInstance() {
        MediaPlayer mediaPlayer = new MediaPlayer();


        if (Instance == null) {
            return Instance = new MyMediaPlayer();
        }
        return Instance;
    }

    public void playAudioFile(Context context, String music) {
        mediaPlayer.stop();
        mediaPlayer.reset();


        try {
            mediaPlayer.setAudioStreamType(AudioManager.STREAM_MUSIC);
            mediaPlayer.setDataSource(music);
            mediaPlayer.prepare();
            mediaPlayer.start();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void stopAudioFile() {
        mediaPlayer.stop();
        mediaPlayer.reset();
    }

    void pauseAudioFile(){
        mediaPlayer.pause();
    }
    //mediaPlayer.setAudioStreamType(AudioManager.STREAM_MUSIC);


}