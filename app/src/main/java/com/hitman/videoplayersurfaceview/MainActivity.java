package com.hitman.videoplayersurfaceview;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements SurfaceHolder.Callback{

    // Declare the surface view and media player variable
    private SurfaceView surfaceView;
    private MediaPlayer mediaPlayer;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // create the media player and set the raw video
        mediaPlayer=MediaPlayer.create(this,R.raw.withoutaudio);

        // initialize the surface view
        surfaceView=findViewById(R.id.surfaceView);
        surfaceView.setKeepScreenOn(true); // to keep the screen on while the video is playing

        // create a surface holder
        SurfaceHolder surfaceHolder=surfaceView.getHolder();

        // add a callback and set this because we implement the SurfaceViewHolder.Callback
        surfaceHolder.addCallback(this);
        surfaceHolder.setFixedSize(640,360);

        // setting up all the buttons
        Button playButton=findViewById(R.id.playBtn);
        playButton.setOnClickListener(v -> {
            mediaPlayer.start();
        });
        Button pauseButton=findViewById(R.id.pauseBtn);
        pauseButton.setOnClickListener(v->{
            mediaPlayer.pause();
        });
        findViewById(R.id.skipBtn).setOnClickListener(v->{
            mediaPlayer.seekTo(mediaPlayer.getDuration()/2);
        });
    }

    @Override
    public void surfaceCreated(@NonNull SurfaceHolder holder) {
        // Displaying the video in the surface view and the holder is basically the surface view
        mediaPlayer.setDisplay(holder);
    }

    @Override
    public void surfaceChanged(@NonNull SurfaceHolder holder, int format, int width, int height) {

    }

    @Override
    public void surfaceDestroyed(@NonNull SurfaceHolder holder) {

    }
}