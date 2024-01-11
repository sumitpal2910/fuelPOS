package com.eightbit.fuelpos.ui;

import android.Manifest;
import android.content.IntentSender;
import android.content.pm.PackageManager;
import android.location.Location;
import android.os.Bundle;
import android.os.Looper;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import com.eightbit.fuelpos.data.local.pref.AppPreferencesHelper;
import com.eightbit.fuelpos.data.local.pref.PreferencesHelper;
import com.eightbit.fuelpos.utils.ConstantsUtil;
import com.google.android.gms.common.api.ApiException;
import com.google.android.gms.common.api.ResolvableApiException;
import com.google.android.gms.location.FusedLocationProviderClient;
import com.google.android.gms.location.LocationCallback;
import com.google.android.gms.location.LocationRequest;
import com.google.android.gms.location.LocationResult;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.location.LocationSettingsRequest;
import com.google.android.gms.location.LocationSettingsResponse;
import com.google.android.gms.location.LocationSettingsStatusCodes;
import com.google.android.gms.location.Priority;
import com.google.android.gms.location.SettingsClient;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;

import java.text.DateFormat;
import java.util.Date;

import timber.log.Timber;

public class BaseActivity extends AppCompatActivity {


    // location updates interval - 10sec
    private static final long UPDATE_INTERVAL_IN_MILLISECONDS = 10000;

    // fastest updates interval - 5 sec
    // location updates will be received if another app is requesting the locations
    // than your app can handle
    private static final long FASTEST_UPDATE_INTERVAL_IN_MILLISECONDS = 5000;

    private static final int REQUEST_CHECK_SETTINGS = 1001;

    private PreferencesHelper appPreferencesHelper;

    private FusedLocationProviderClient mFusedLocationProviderClient;
    private SettingsClient mSettingsClient;
    private LocationRequest mLocationRequest;
    private LocationCallback mLocationCallback;
    private Location mCurrentLocation;
    private LocationSettingsRequest mLocationSettingsRequest;

    private String mLocationLastUpdateDatetime;

    private Boolean mRequestingLocationUpdates;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
//
//        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
//            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
//            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
//            return insets;
//        });

        appPreferencesHelper = new AppPreferencesHelper(getApplicationContext(), ConstantsUtil.PREF_NAME);

        init();

    }

    private void init() {
        mFusedLocationProviderClient = LocationServices.getFusedLocationProviderClient(BaseActivity.this);
        mSettingsClient = LocationServices.getSettingsClient(BaseActivity.this);


        mLocationCallback = new LocationCallback() {
            @Override
            public void onLocationResult(@NonNull LocationResult locationResult) {
                super.onLocationResult(locationResult);
                mCurrentLocation = locationResult.getLastLocation();
                mLocationLastUpdateDatetime = DateFormat.getTimeInstance().format(new Date());

                startLocationUpdates();

                Timber.i("Location >>> " + mCurrentLocation.getLatitude() + "," + mCurrentLocation.getLongitude());
            }
        };

        mRequestingLocationUpdates = false;
        mLocationRequest = new LocationRequest.Builder(Priority.PRIORITY_HIGH_ACCURACY, UPDATE_INTERVAL_IN_MILLISECONDS).build();

        LocationSettingsRequest.Builder builder = new LocationSettingsRequest.Builder();
        builder.addLocationRequest(mLocationRequest);
        mLocationSettingsRequest = builder.build();
    }

    private void startLocationUpdates() {
        Timber.i("startLocationUpdates");
        mSettingsClient.checkLocationSettings(mLocationSettingsRequest).addOnSuccessListener(BaseActivity.this, locationSettingsResponse -> {
            Timber.i("All location settings are satisfied.");

            Timber.i("Started location updates!");
            if (!checkLocationPermission()) return;

            try {
                mFusedLocationProviderClient.requestLocationUpdates(mLocationRequest, mLocationCallback, Looper.myLooper());
            } catch (SecurityException e) {
                e.printStackTrace();
            }


        }).addOnFailureListener(BaseActivity.this, e -> {

            int statusCode = ((ApiException) e).getStatusCode();

            if (statusCode == LocationSettingsStatusCodes.RESOLUTION_REQUIRED) {
                Timber.i("Location settings are not satisfied. Attempting to upgrade location settings ");

                // Show the dialog by calling startResolutionForResult(), and check the
                // result in onActivityResult().
                try {
                    ResolvableApiException rae = (ResolvableApiException) e;
                    rae.startResolutionForResult(BaseActivity.this, REQUEST_CHECK_SETTINGS);
                } catch (IntentSender.SendIntentException sie) {
                    Timber.i("PendingIntent unable to execute request.");
                }
            } else if (statusCode == LocationSettingsStatusCodes.SETTINGS_CHANGE_UNAVAILABLE) {
                String errorMessage = "Location settings are inadequate, and cannot be " + "fixed here. Fix in Settings.";
                Timber.e(errorMessage);
            }
        });
    }

    public void stopLocationUpdates() {
        // Removing location updates
        mFusedLocationProviderClient.removeLocationUpdates(mLocationCallback).addOnCompleteListener(BaseActivity.this, new OnCompleteListener<Void>() {
            @Override
            public void onComplete(@NonNull Task<Void> task) {
                Timber.i("Location updates stopped!");
                //toggleButtons();
            }
        });
    }

    protected boolean checkLocationPermission() {
        int permissionState = ActivityCompat.checkSelfPermission(BaseActivity.this, Manifest.permission.ACCESS_FINE_LOCATION);
        return permissionState == PackageManager.PERMISSION_GRANTED;
    }

    public void startLocationButtonClick() {
        //permissions.getLocationPermission();

        mRequestingLocationUpdates = true;
        startLocationUpdates();
    }

    public void stopLocationButtonClick() {
        mRequestingLocationUpdates = false;
        stopLocationUpdates();
    }


}
