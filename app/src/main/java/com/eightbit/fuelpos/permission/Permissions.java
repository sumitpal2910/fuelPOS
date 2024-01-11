package com.eightbit.fuelpos.permission;

import android.Manifest;
import android.app.Activity;
import android.content.Context;

import com.eightbit.fuelpos.permission.callback.LocationPermissionCallback;
import com.karumi.dexter.Dexter;
import com.karumi.dexter.PermissionToken;
import com.karumi.dexter.listener.PermissionDeniedResponse;
import com.karumi.dexter.listener.PermissionGrantedResponse;
import com.karumi.dexter.listener.PermissionRequest;
import com.karumi.dexter.listener.single.PermissionListener;

import lombok.Getter;
import lombok.Setter;

public class Permissions {

    @Getter
    @Setter
    LocationPermissionCallback locationPermissionCallback;

    private Activity activity;

    public Permissions(Context context) {
        if (context instanceof Activity) {
            this.activity = (Activity) context;
        }
    }


    public void getLocationPermission() {
        Dexter.withContext(activity).withPermission(Manifest.permission.ACCESS_NETWORK_STATE).withListener(new PermissionListener() {
            @Override
            public void onPermissionGranted(PermissionGrantedResponse permissionGrantedResponse) {
                locationPermissionCallback.onLocationPermissionGranted(permissionGrantedResponse);
            }

            @Override
            public void onPermissionDenied(PermissionDeniedResponse permissionDeniedResponse) {
                locationPermissionCallback.onLocationPermissionDenied(permissionDeniedResponse);
            }

            @Override
            public void onPermissionRationaleShouldBeShown(PermissionRequest permissionRequest, PermissionToken permissionToken) {
                permissionToken.continuePermissionRequest();
            }
        }).check();
    }
}
