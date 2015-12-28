package com.example.home.videoplayer;

import android.media.MediaPlayer;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.widget.MediaController;
import android.widget.VideoView;

public class Main2Activity extends AppCompatActivity {
    VideoView v;
    int c=0;
    MediaController mc;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        v=(VideoView)findViewById(R.id.videoView);
        v.setKeepScreenOn(true);
        String path = "android.resource://" + getPackageName() + "/" + R.raw.maari;
        v.setVideoURI(Uri.parse(path));


        v.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
            @Override
            public void onPrepared(MediaPlayer mp) {
                mp.setOnVideoSizeChangedListener(new MediaPlayer.OnVideoSizeChangedListener() {
                    @Override
                    public void onVideoSizeChanged(MediaPlayer mp, int width, int height) {
                        mc = new MediaController(Main2Activity.this);
                        v.setMediaController(mc);
                        mc.setAnchorView(v);
                    }
                });
            }
        });
        v.start();
        c=1;

        v.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View s, MotionEvent event) {

                //VideoView x=(VideoView)v;
                if(v.isPlaying())
                {
                    v.pause();
                }
                else
                v.start();
                return false;
            }
        });
    }

}
