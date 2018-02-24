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
import com.facebook.react.common.MapBuilder;
import com.facebook.react.uimanager.SimpleViewManager;
import com.facebook.react.uimanager.ThemedReactContext;
import com.facebook.react.uimanager.annotations.ReactProp;
import com.shuyu.gsyvideoplayer.video.StandardGSYVideoPlayer;
import com.phoobobo.react_native_phoo_video_player.PhooVideoPlayerView.Events;

import java.util.Map;

import javax.annotation.Nullable;


public class PhooVideoPlayerManager extends SimpleViewManager<PhooVideoPlayerView> {

    private AppCompatActivity mActivity;
    private static final String TAG = "PhooVideoPlayerManager";

    @Override
    public String getName() {
        return "PhooVideoPlayer";
    }

    @Override
    protected PhooVideoPlayerView createViewInstance(ThemedReactContext reactContext) {
        mActivity = (AppCompatActivity) reactContext.getCurrentActivity();
        PhooVideoPlayerView player = new PhooVideoPlayerView(reactContext);
        return player;
    }

    @Override
    @Nullable
    public Map getExportedCustomDirectEventTypeConstants() {
        MapBuilder.Builder builder = MapBuilder.builder();
        for (Events event : Events.values()) {
            builder.put(event.toString(), MapBuilder.of("registrationName", event.toString()));
        }
        return builder.build();
    }

    @ReactProp(name="src")
    public void setSrc(PhooVideoPlayerView video, String src) {
        video.setUp(src, false, "hahaha");
    }

    @ReactProp(name="coverImgUrl")
    public void setCoverImage(PhooVideoPlayerView video, String coverImgUrl) {
        video.loadCoverImage(coverImgUrl, R.drawable.video_error_normal);
    }

    @ReactProp(name="fullscreen")
    public void setFullScreen(PhooVideoPlayerView video, boolean fullscreen) {
        if (fullscreen) {
            video.startWindowFullscreen(mActivity, true, true);
        }
    }

    @Override
    public void updateExtraData(PhooVideoPlayerView root, Object extraData) {
        super.updateExtraData(root, extraData);
    }
}
