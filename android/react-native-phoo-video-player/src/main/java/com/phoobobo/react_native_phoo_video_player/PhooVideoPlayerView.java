package com.phoobobo.react_native_phoo_video_player;

import android.content.Context;
import android.content.pm.ActivityInfo;
import android.graphics.drawable.Drawable;
import android.hardware.SensorManager;
import android.support.v7.app.AppCompatActivity;
import android.util.AttributeSet;
import android.util.Log;
import android.view.OrientationEventListener;
import android.view.View;

import com.facebook.react.bridge.ReactContext;
import com.facebook.react.uimanager.ThemedReactContext;
import com.shuyu.gsyvideoplayer.video.StandardGSYVideoPlayer;


public class PhooVideoPlayerView extends VideoWithCover {

    private static final String TAG = "PhooVideoPlayerView";
    public PhooVideoPlayerView(Context context, Boolean fullFlag) {
        super(context, fullFlag);
    }

    public PhooVideoPlayerView(final Context context) {
        super(context);
        ThemedReactContext themedReactContext = (ThemedReactContext) context;
        final AppCompatActivity currentActivity = (AppCompatActivity) themedReactContext.getCurrentActivity();

        setRotateViewAuto(false);

        getFullscreenButton().setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                startWindowFullscreen(currentActivity, true, true);
            }
        });

        new OrientationEventListener(context, SensorManager.SENSOR_DELAY_NORMAL) {
            @Override
            public void onOrientationChanged(int orientation) {
                Log.d(TAG, "orientation=" + orientation);
                if (orientation != 0 && !isIfCurrentIsFullscreen()) {
                    startWindowFullscreen(currentActivity, true, true);
                } else if (orientation == 0 && isIfCurrentIsFullscreen()) {
                    backFromFull(currentActivity);
                }
            }
        }.enable();
    }

    public PhooVideoPlayerView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    public void setBottomProgressBarDrawable(Drawable drawable) {
        super.setBottomProgressBarDrawable(drawable);
    }

    @Override
    public void startPlayLogic() {
        super.startPlayLogic();
    }

    @Override
    protected void addTextureView() {
        super.addTextureView();
    }
}
