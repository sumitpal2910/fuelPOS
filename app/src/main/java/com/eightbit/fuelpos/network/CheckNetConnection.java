package com.eightbit.fuelpos.network;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.res.Resources;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

import com.eightbit.fuelpos.R;
import com.eightbit.fuelpos.network.callback.NetworkConfirmationCallBack;

import lombok.Getter;
import lombok.Setter;


public class CheckNetConnection {
    private Context context;

    private Activity activity;

    private AlertDialog dialog;

    @Getter
    @Setter
    private NetworkConfirmationCallBack networkConfirmationCallBack;

    public CheckNetConnection(Context context) {
        this.context = context;
        if (context instanceof Activity) {
            this.activity = (Activity) context;
        }
    }

    public boolean isNetworkConnected() {
        ConnectivityManager manager = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        if (manager != null) {
            NetworkInfo activeNetworkInfo = manager.getActiveNetworkInfo();
            if (activeNetworkInfo != null && activeNetworkInfo.isConnectedOrConnecting()) {
                return true;
            }
        }

        return false;
    }


    public void showNetworkConfirmationDialog(String title, String message, String positiveBtnTxt, String negativeBtnTxt) {
        if (activity == null) return;

        AlertDialog.Builder builder = new AlertDialog.Builder(activity);
        builder.setIcon(R.mipmap.ic_launcher);
        builder.setTitle(title);
        builder.setMessage(message);
        builder.setCancelable(false);

        builder.setPositiveButton(positiveBtnTxt, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                if (networkConfirmationCallBack != null)
                    networkConfirmationCallBack.okConfirmation();
            }
        });

        builder.setNegativeButton(negativeBtnTxt, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                if (networkConfirmationCallBack != null)
                    networkConfirmationCallBack.settingsConfirmation();
            }
        });

        if (dialog != null && dialog.isShowing()) dialog.cancel();

        dialog = builder.create();
        dialog.show();
    }

    public void showNetworkConfirmationDialog(Resources resources) {

        String title = resources.getString(R.string.app_name);
        String message = resources.getString(R.string.no_internet);
        String pvtBtnText = resources.getString(R.string.no_internet_pvt_btn);
        String nvtBtnText = resources.getString(R.string.no_internet_nvt_btn);

        showNetworkConfirmationDialog(title, message, pvtBtnText, nvtBtnText);
    }
}
