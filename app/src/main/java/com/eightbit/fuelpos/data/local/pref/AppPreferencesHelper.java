package com.eightbit.fuelpos.data.local.pref;

import android.content.Context;
import android.content.SharedPreferences;

import com.eightbit.fuelpos.utils.ConstantsUtil;

public class AppPreferencesHelper implements PreferencesHelper {

    private static final String PREF_KEY_LOGIN_ID = "prefLoginId";

    private static final String PREF_KEY_AUTH_KEY = "prefAuthkey";

    private static final String PREF_KEY_IS_LOGEDIN = "prefIsLogedin";

    private static final String PREF_KEY_SELECTED_RFID_BLE_ADDRESS = "prefSelectedRFIDBLEAddress";
    private static final String PREF_KEY_SELECTED_RFID_BLE_NAME = "prefSelectedRFIDBLEName";

    private static final String PREF_KEY_SELECTED_QR_BLE_ADDRESS = "prefSelectedQRBLEAddress";
    private static final String PREF_KEY_SELECTED_QR_BLE_NAME = "prefSelectedQRBLEName";

    private static final String PREF_KEY_SELECTED_UHF_BLE_ADDRESS = "prefSelectedUHFBLEAddress";
    private static final String PREF_KEY_SELECTED_UHF_BLE_NAME = "prefSelectedUHFBLEName";

    private static final String PREF_CONNECTED_DEVICE_LIST_OBJECT = "prefConnectedDeviceListObject";

    private static final String URL_KEY = "ConfigKey";
    private static final String hasUrlKey = "HasUrl";

    private static final String PREF_KEY_ANPR_IMAGE = "prefAnprImage";
    private static final String PREF_KEY_VRN_NO = "prefVrnNo";
    private static final String PREF_KEY_DISPLAY_NAME = "prefDisplayName";
    private static final String PREF_KEY_USERNAME = "prefUsername";
    private static final String PREF_KEY_MOBILE_NO = "prefMobile";
    private static final String PREF_KEY_ISMANUAL = "prefManual";
    private static final String PREF_KEY_FASTAG = "prefFastag";
    private static final String PREF_KEY_ANPR = "prefAnpr";


    private final SharedPreferences mPrefs;


    public AppPreferencesHelper(Context context, String prefFileName) {
        mPrefs = context.getSharedPreferences(prefFileName, Context.MODE_PRIVATE);
    }


    @Override
    public void setMobileNo(String mobileNo) {
        mPrefs.edit().putString(PREF_KEY_MOBILE_NO, mobileNo).apply();
    }

    @Override
    public String getMoblieNo() {
        return mPrefs.getString(PREF_KEY_MOBILE_NO, "");
    }

    @Override
    public void removeMobileNo() {
        mPrefs.edit().remove(PREF_KEY_MOBILE_NO).commit();
    }

    @Override
    public void setIsManual(boolean isManual) {
        mPrefs.edit().putBoolean(PREF_KEY_ISMANUAL, isManual).apply();
    }

    @Override
    public boolean getIsManual() {
        return mPrefs.getBoolean(PREF_KEY_ISMANUAL, ConstantsUtil.FALSE_BOOLEAN);
    }

    @Override
    public void setAnprScanner(boolean anprScanner) {
        mPrefs.edit().putBoolean(PREF_KEY_ANPR, anprScanner);
    }

    @Override
    public boolean getAnprScanner() {
        return mPrefs.getBoolean(PREF_KEY_ANPR, ConstantsUtil.FALSE_BOOLEAN);
    }

    @Override
    public void removeAnprScanner() {
        mPrefs.edit().remove(PREF_KEY_ANPR).commit();
    }

    @Override
    public void setFastagReader(boolean fastagReader) {
        mPrefs.edit().putBoolean(PREF_KEY_FASTAG, fastagReader);
    }

    @Override
    public boolean getFastReader() {
        return mPrefs.getBoolean(PREF_KEY_FASTAG, ConstantsUtil.FALSE_BOOLEAN);
    }

    @Override
    public void removeFastagReader() {
        mPrefs.edit().remove(PREF_KEY_FASTAG).commit();
    }

    @Override
    public void setUsername(String username) {
        mPrefs.edit().putString(PREF_KEY_USERNAME, username).apply();
    }

    @Override
    public String getUsername() {
        return mPrefs.getString(PREF_KEY_USERNAME, "");
    }

    @Override
    public void removeUsername() {
        mPrefs.edit().remove(PREF_KEY_USERNAME).commit();
    }

    @Override
    public void setDisplayName(String displayName) {
        mPrefs.edit().putString(PREF_KEY_DISPLAY_NAME, displayName).apply();
    }

    @Override
    public String getDisplayName() {
        return mPrefs.getString(PREF_KEY_DISPLAY_NAME, "");
    }

    @Override
    public void setVehicleImage(String url) {
        mPrefs.edit().putString(PREF_KEY_ANPR_IMAGE, url).apply();
    }

    @Override
    public String getVehicleImage() {
        return mPrefs.getString(PREF_KEY_ANPR_IMAGE, "");
    }

    @Override
    public void removeVehicalImage() {
        mPrefs.edit().remove(PREF_KEY_ANPR_IMAGE).commit();
    }

    @Override
    public void setVRN(String vrn) {
        mPrefs.edit().putString(PREF_KEY_VRN_NO, vrn).apply();
    }

    @Override
    public String getVRN() {
        return mPrefs.getString(PREF_KEY_VRN_NO, "");
    }

    @Override
    public void removeVRN() {
        mPrefs.edit().remove(PREF_KEY_VRN_NO).commit();
    }

    @Override
    public void setAppConfigWebUrl(String Url) {
        mPrefs.edit().putString(URL_KEY, Url).apply();
    }

    @Override
    public String getAppConfigWebUrl() {
        return mPrefs.getString(URL_KEY, "");
    }

    @Override
    public void setAppConfigHasWebUrl(int hasUrl) {
        mPrefs.edit().putInt(hasUrlKey, hasUrl).apply();
    }

    @Override
    public int getAppConfigHasWebUrl() {
        return mPrefs.getInt(hasUrlKey, -1);
    }

    @Override
    public void setUserbId(long login_id) {
        mPrefs.edit().putLong(PREF_KEY_LOGIN_ID, login_id).apply();
    }

    @Override
    public long getUserbId() {
        return mPrefs.getLong(PREF_KEY_LOGIN_ID, ConstantsUtil.NEGATIVE_LONG);
    }

    @Override
    public void removeUserbId() {
        mPrefs.edit().remove(PREF_KEY_LOGIN_ID).commit();
    }


    @Override
    public void setAuthkey(String authkey) {
        mPrefs.edit().putString(PREF_KEY_AUTH_KEY, authkey).apply();
    }

    @Override
    public String getAuthkey() {
        return mPrefs.getString(PREF_KEY_AUTH_KEY, null);
    }

    @Override
    public void removeAuthkey() {
        mPrefs.edit().remove(PREF_KEY_AUTH_KEY).commit();
    }


    @Override
    public void setIsLogedin(boolean isLogedin) {
        mPrefs.edit().putBoolean(PREF_KEY_IS_LOGEDIN, isLogedin).apply();
    }

    @Override
    public boolean getIsLogedin() {
        return mPrefs.getBoolean(PREF_KEY_IS_LOGEDIN, ConstantsUtil.FALSE_BOOLEAN);
    }

    @Override
    public void removeIsLogedin() {
        mPrefs.edit().remove(PREF_KEY_IS_LOGEDIN).commit();
    }


    @Override
    public void setSelectedRFIDBLEAddress(String RFIDBLEAddress) {
        mPrefs.edit().putString(PREF_KEY_SELECTED_RFID_BLE_ADDRESS, RFIDBLEAddress).apply();
    }

    @Override
    public String getSelectedRFIDBLEAddress() {
        return mPrefs.getString(PREF_KEY_SELECTED_RFID_BLE_ADDRESS, null);
    }

    @Override
    public void removeSelectedRFIDBLEAddress() {
        mPrefs.edit().remove(PREF_KEY_SELECTED_RFID_BLE_ADDRESS).commit();
    }


    @Override
    public void setSelectedRFIDBLEName(String RFIDBLEName) {
        mPrefs.edit().putString(PREF_KEY_SELECTED_RFID_BLE_NAME, RFIDBLEName).apply();
    }

    @Override
    public String getSelectedRFIDBLEName() {
        return mPrefs.getString(PREF_KEY_SELECTED_RFID_BLE_NAME, null);
    }

    @Override
    public void removeSelectedRFIDBLEName() {
        mPrefs.edit().remove(PREF_KEY_SELECTED_RFID_BLE_NAME).commit();
    }


    @Override
    public void setSelectedQRBLEAddress(String QRBLEAddress) {
        mPrefs.edit().putString(PREF_KEY_SELECTED_QR_BLE_ADDRESS, QRBLEAddress).apply();
    }

    @Override
    public String getSelectedQRBLEAddress() {
        return mPrefs.getString(PREF_KEY_SELECTED_QR_BLE_ADDRESS, null);
    }

    @Override
    public void removeSelectedQRBLEAddress() {
        mPrefs.edit().remove(PREF_KEY_SELECTED_QR_BLE_ADDRESS).commit();
    }


    @Override
    public void setSelectedQRBLEName(String QRBLEName) {
        mPrefs.edit().putString(PREF_KEY_SELECTED_QR_BLE_NAME, QRBLEName).apply();
    }

    @Override
    public String getSelectedQRBLEName() {
        return mPrefs.getString(PREF_KEY_SELECTED_QR_BLE_NAME, null);
    }

    @Override
    public void removeSelectedQRBLEName() {
        mPrefs.edit().remove(PREF_KEY_SELECTED_QR_BLE_NAME).commit();
    }


    @Override
    public void setSelectedUHFBLEAddress(String UHFBLEAddress) {
        mPrefs.edit().putString(PREF_KEY_SELECTED_UHF_BLE_ADDRESS, UHFBLEAddress).apply();
    }

    @Override
    public String getSelectedUHFBLEAddress() {
        return mPrefs.getString(PREF_KEY_SELECTED_UHF_BLE_ADDRESS, null);
    }

    @Override
    public void removeSelectedUHFBLEAddress() {
        mPrefs.edit().remove(PREF_KEY_SELECTED_UHF_BLE_ADDRESS).commit();
    }


    @Override
    public void setSelectedUHFBLEName(String UHFBLEName) {
        mPrefs.edit().putString(PREF_KEY_SELECTED_UHF_BLE_NAME, UHFBLEName).apply();
    }

    @Override
    public String getSelectedUHFBLEName() {
        return mPrefs.getString(PREF_KEY_SELECTED_UHF_BLE_NAME, null);
    }

    @Override
    public void removeSelectedUHFBLEName() {
        mPrefs.edit().remove(PREF_KEY_SELECTED_UHF_BLE_NAME).commit();
    }


    @Override
    public void removeConnectedBtDevicesList() {
        mPrefs.edit().remove(PREF_CONNECTED_DEVICE_LIST_OBJECT).commit();
    }


    @Override
    public void deleteAtLogout() {
        removeUserbId();
        removeAuthkey();
        removeIsLogedin();
        removeAnprScanner();
        removeFastagReader();
        removeUsername();
        removeVehicalImage();
        removeVRN();
        removeMobileNo();

        removeSelectedRFIDBLEAddress();
        removeSelectedRFIDBLEName();
        removeSelectedQRBLEAddress();
        removeSelectedQRBLEName();
        removeSelectedUHFBLEAddress();
        removeSelectedUHFBLEName();
        removeConnectedBtDevicesList();
    }

}
