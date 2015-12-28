package com.example.home.videoplayer;

import android.media.MediaPlayer;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.MediaController;
import android.widget.VideoView;

public class Main3Activity extends AppCompatActivity {

    MediaController mc;
    VideoView v1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
        v1=(VideoView)findViewById(R.id.videoView2);
        v1.setKeepScreenOn(true);
       String p="http://www.androidbegin.com/tutorial/AndroidCommercial.3gp";
        //String p="http://192.168.229.1:1116/audio/aa.3gp";
        Uri u=Uri.parse(p);
        v1.setVideoURI(u);
        v1.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
            @Override
            public void onPrepared(MediaPlayer mp) {
                mp.setOnVideoSizeChangedListener(new MediaPlayer.OnVideoSizeChangedListener() {
                    @Override
                    public void onVideoSizeChanged(MediaPlayer mp, int width, int height) {
                        mc=new MediaController(Main3Activity.this);
                        v1.setMediaController(mc);
                        mc.setAnchorView(v1);
                    }
                });
            }
        });

        v1.start();


    }


}
