package com.eightbit.fuelpos;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import timber.log.Timber;

public class AppLifeCycleTrack implements Application.ActivityLifecycleCallbacks {
    Context context;

    public AppLifeCycleTrack(Context context) {
        this.context = context;
    }

    @Override
    public void onActivityCreated(@NonNull Activity activity, @Nullable Bundle bundle) {
        Timber.i("onActivityCreated");
        System.out.println("onActivityCreated");
        /*AppConfigApi appConfigApi=new AppConfigApi(context);
        appConfigApi.appConfigApi();*/
    }

    @Override
    public void onActivityStarted(@NonNull Activity activity) {
        Timber.i("onActivityStarted");
    }

    @Override
    public void onActivityResumed(@NonNull Activity activity) {
        Timber.i("onActivityResumed");
    }

    @Override
    public void onActivityPaused(@NonNull Activity activity) {
        Timber.i("onActivityPaused");
    }

    @Override
    public void onActivityStopped(@NonNull Activity activity) {
        Timber.i("onActivityStopped");
    }

    @Override
    public void onActivitySaveInstanceState(@NonNull Activity activity, @NonNull Bundle bundle) {

    }

    @Override
    public void onActivityDestroyed(@NonNull Activity activity) {
        Timber.i("onActivityDestroyed");
    }
}
