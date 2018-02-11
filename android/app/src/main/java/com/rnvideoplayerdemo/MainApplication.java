package com.rnvideoplayerdemo;

import android.app.Activity;
import android.app.Application;
import android.os.Bundle;
import android.support.annotation.Nullable;

import com.facebook.react.ReactApplication;
import com.reactnativenavigation.NavigationApplication;
import com.facebook.react.ReactNativeHost;
import com.facebook.react.ReactPackage;
import com.facebook.react.shell.MainReactPackage;
import com.facebook.soloader.SoLoader;
import com.phoobobo.react_native_phoo_video_player.PhooPlayerPackage;
import com.reactnativenavigation.controllers.ActivityCallbacks;

import java.util.Arrays;
import java.util.List;

public class MainApplication extends NavigationApplication {

    @Override
    public void onCreate() {
        super.onCreate();
        setActivityCallbacks(new ActivityCallbacks() {
            @Override
            public void onActivityCreated(Activity activity, Bundle savedInstanceState) {
                super.onActivityCreated(activity, savedInstanceState);
            }

            @Override
            public void onActivityStarted(Activity activity) {
                super.onActivityStarted(activity);
            }

            @Override
            public void onActivityResumed(Activity activity) {
                super.onActivityResumed(activity);
            }

            @Override
            public void onActivityPaused(Activity activity) {
                super.onActivityPaused(activity);
            }
        });
    }

    @Nullable
    @Override
    public String getJSMainModuleName() {
        return "index";
    }

    @Override
    public boolean isDebug() {
        return BuildConfig.DEBUG;
    }

    @Nullable
    @Override
    public List<ReactPackage> createAdditionalReactPackages() {
        return Arrays.<ReactPackage>asList(new PhooPlayerPackage());
    }
}
