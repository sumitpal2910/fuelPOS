package com.eightbit.fuelpos;

import android.app.Application;

import androidx.activity.EdgeToEdge;

import timber.log.Timber;

public class FuelPosApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
//        EdgeToEdge.enable(getApplicationContext());

        if (BuildConfig.DEBUG) {
            Timber.plant(new Timber.DebugTree());
        }
        registerActivityLifecycleCallbacks(new AppLifeCycleTrack(getApplicationContext()));
    }
}
