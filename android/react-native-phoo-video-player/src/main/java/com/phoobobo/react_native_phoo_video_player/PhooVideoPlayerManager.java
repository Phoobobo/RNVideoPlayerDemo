package com.phoobobo.react_native_phoo_video_player;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.res.Configuration;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;

import com.facebook.react.bridge.LifecycleEventListener;
import com.facebook.react.uimanager.SimpleViewManager;
import com.facebook.react.uimanager.ThemedReactContext;
import com.facebook.react.uimanager.annotations.ReactProp;
import com.shuyu.gsyvideoplayer.video.StandardGSYVideoPlayer;


public class PhooVideoPlayerManager extends SimpleViewManager<PhooVideoPlayerView> implements LifecycleEventListener{

    private AppCompatActivity mActivity;
    private BroadcastReceiver mReceiver;
    private static final String TAG = "PhooVideoPlayerManager";

    @Override
    public String getName() {
        return "PhooVideoPlayer";
    }

    @Override
    protected PhooVideoPlayerView createViewInstance(final ThemedReactContext reactContext) {
        mReceiver = new BroadcastReceiver() {
            @Override
            public void onReceive(Context context, Intent intent) {
                Configuration newConfig = intent.getParcelableExtra("newConfig");
                Log.d(TAG, "newConfig: " + newConfig.orientation);
                String orientationValue = newConfig.orientation == 1 ? "PORTRAIT" : "LANDSCAPE";
            }
        };
        reactContext.addLifecycleEventListener(this);
        mActivity = (AppCompatActivity) reactContext.getCurrentActivity();
        final PhooVideoPlayerView player = new PhooVideoPlayerView(reactContext);
        player.setRotateViewAuto(false);
        player.getFullscreenButton().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                player.startWindowFullscreen(mActivity, true, true);
            }
        });
        return player;
    }

    @ReactProp(name="src")
    public void setSrc(PhooVideoPlayerView video, String src) {
        video.setUp(src, false, "hahaha");
    }

    @ReactProp(name="fullscreen")
    public void setFullScreen(PhooVideoPlayerView video, boolean fullscreen) {
        if (fullscreen) {
            video.startWindowFullscreen(mActivity, true, true);
        }
    }

    @Override
    public void onHostResume() {
        mActivity.registerReceiver(mReceiver, new IntentFilter("onConfigurationChanged"));
    }

    @Override
    public void onHostPause() {
        if (mActivity == null) return;
        try {
            mActivity.unregisterReceiver(mReceiver);
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void onHostDestroy() {
        if (mActivity == null) return;
        try {
            mActivity.unregisterReceiver(mReceiver);
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
        }
    }
}
