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

    private SurfaceView surfaceView;
    private MediaPlayer mediaPlayer;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mediaPlayer=MediaPlayer.create(this,R.raw.withoutaudio);

        surfaceView=findViewById(R.id.surfaceView);
        surfaceView.setKeepScreenOn(true);
        SurfaceHolder surfaceHolder=surfaceView.getHolder();
        surfaceHolder.addCallback(this);
        surfaceHolder.setFixedSize(640,360);
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
        mediaPlayer.setDisplay(holder);
    }

    @Override
    public void surfaceChanged(@NonNull SurfaceHolder holder, int format, int width, int height) {

    }

    @Override
    public void surfaceDestroyed(@NonNull SurfaceHolder holder) {

    }
}