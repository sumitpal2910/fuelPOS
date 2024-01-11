package com.eightbit.fuelpos.ui.login;

import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.provider.Settings;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

import com.eightbit.fuelpos.R;
import com.eightbit.fuelpos.data.local.pref.AppPreferencesHelper;
import com.eightbit.fuelpos.data.local.pref.PreferencesHelper;
import com.eightbit.fuelpos.network.CheckNetConnection;
import com.eightbit.fuelpos.network.Url;
import com.eightbit.fuelpos.network.callback.NetworkConfirmationCallBack;
import com.eightbit.fuelpos.permission.Permissions;
import com.eightbit.fuelpos.permission.callback.LocationPermissionCallback;
import com.eightbit.fuelpos.ui.BaseActivity;
import com.eightbit.fuelpos.utils.ConstantsUtil;
import com.hbb20.CountryCodePicker;
import com.karumi.dexter.listener.PermissionDeniedResponse;
import com.karumi.dexter.listener.PermissionGrantedResponse;

import timber.log.Timber;

public class OtpLoginActivity extends BaseActivity implements NetworkConfirmationCallBack, View.OnClickListener, LocationPermissionCallback {

    CountryCodePicker countryCodePicker;
    EditText mobileEdt;

    Button otp_button;

    private PreferencesHelper appPreferencesHelper;

    private CheckNetConnection checkNetConnection;
    private Permissions permissions = null;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_otp_login);

        initView();
        appPreferencesHelper = new AppPreferencesHelper(this, ConstantsUtil.PREF_NAME);

        initNetworkCheck();
        initPermission();
    }

    @Override
    protected void onResume() {
        super.onResume();
        checkNetworkConnection();

        startLocationButtonClick();

    }

    /**
     * Set View to property
     */
    private void initView() {
        countryCodePicker = findViewById(R.id.ccp);
        mobileEdt = findViewById(R.id.edt_mobile_no);
        otp_button = findViewById(R.id.btn_get_otp);
        otp_button.setOnClickListener(this);
    }


    /**
     * Initiate Network Check
     */
    private void initNetworkCheck() {
        checkNetConnection = new CheckNetConnection(OtpLoginActivity.this);
        checkNetConnection.setNetworkConfirmationCallBack(this);
    }

    private void initPermission() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            permissions = new Permissions(OtpLoginActivity.this);
            permissions.setLocationPermissionCallback(OtpLoginActivity.this);
            permissions.getLocationPermission();
        }
    }

    /**
     * Check if connected to a network
     *
     * @return boolean
     */
    private boolean checkNetworkConnection() {
        boolean networkConnected = checkNetConnection.isNetworkConnected();
        Timber.i("network connection >>> %s", networkConnected);

        if (!networkConnected) checkNetConnection.showNetworkConfirmationDialog(getResources());

        return networkConnected;
    }


    @Override
    public void okConfirmation() {

    }

    @Override
    public void settingsConfirmation() {
        goToSettingsView();
    }

    private void goToSettingsView() {
        Intent intent = new Intent(Settings.ACTION_SETTINGS);
        startActivity(intent);
    }

    @Override
    public void onClick(View view) {

        if (R.id.btn_get_otp == view.getId()) {
            Timber.i("Button Clicked");
        }
    }

    @Override
    public void onLocationPermissionGranted(PermissionGrantedResponse response) {

    }

    @Override
    public void onLocationPermissionDenied(PermissionDeniedResponse response) {
        goToPermissionSettings();
    }


    private void goToPermissionSettings() {
        Intent i = new Intent(Settings.ACTION_APPLICATION_DETAILS_SETTINGS);
        Uri uri = Uri.fromParts("package", getPackageName(), null);
        i.setData(uri);
        startActivity(i);
    }
}