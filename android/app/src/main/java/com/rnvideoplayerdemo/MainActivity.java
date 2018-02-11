package com.rnvideoplayerdemo;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.LinearLayout;

import com.phoobobo.react_native_phoo_video_player.PhooVideoPlayerView;
import com.reactnativenavigation.controllers.SplashActivity;

public class MainActivity extends SplashActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        PhooVideoPlayerView playerView = findViewById(R.id.welcome_video);
        String url = "http://video.pearvideo.com/mp4/short/20180205/cont-1273507-11540028-hd.mp4";
        playerView.setUp(url, false, "");
        playerView.startPlayLogic();
    }

    @Override
    public View createSplashLayout() {
        return View.inflate(this, R.layout.splash_layout, null);
    }
}
