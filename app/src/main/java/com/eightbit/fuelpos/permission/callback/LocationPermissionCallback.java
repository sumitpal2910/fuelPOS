package com.eightbit.fuelpos.permission.callback;

import com.karumi.dexter.listener.PermissionDeniedResponse;
import com.karumi.dexter.listener.PermissionGrantedResponse;

public interface LocationPermissionCallback {
    void onLocationPermissionGranted(PermissionGrantedResponse response);

    void onLocationPermissionDenied(PermissionDeniedResponse response);
}
