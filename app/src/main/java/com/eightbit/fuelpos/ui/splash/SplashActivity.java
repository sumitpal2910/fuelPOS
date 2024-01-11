package com.eightbit.fuelpos.ui.splash;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import androidx.appcompat.app.AppCompatActivity;

import com.eightbit.fuelpos.R;
import com.eightbit.fuelpos.ui.BaseActivity;
import com.eightbit.fuelpos.ui.login.OtpLoginActivity;
import com.eightbit.fuelpos.utils.ConstantsUtil;

import timber.log.Timber;

public class SplashActivity extends BaseActivity {

    private final String CLASS_NAME = SplashActivity.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                goToLoginActivity();
            }
        }, 3000);
    }

    private void goToLoginActivity() {
        Timber.i("Going to Login Activity....");

        Intent i = new Intent(SplashActivity.this, OtpLoginActivity.class);
        i.putExtra(ConstantsUtil.CLASS_NAME, CLASS_NAME);

        startActivity(i);
        finish();
    }
}