package com.eightbit.fuelpos.data.local.pref;

import java.util.List;

public interface PreferencesHelper {


    void setMobileNo(String mobileNo);

    String getMoblieNo();

    void removeMobileNo();

    void setIsManual(boolean isManual);

    boolean getIsManual();

    void setAnprScanner(boolean anprScanner);

    boolean getAnprScanner();

    void removeAnprScanner();

    void setFastagReader(boolean fastagReader);

    boolean getFastReader();

    void removeFastagReader();

    void setUsername(String username);

    String getUsername();

    void removeUsername();

    void setDisplayName(String displayName);

    String getDisplayName();

    void setVehicleImage(String url);

    String getVehicleImage();

    void removeVehicalImage();

    void setVRN(String vrn);

    String getVRN();

    void removeVRN();

    void setAppConfigWebUrl(String Url);

    String getAppConfigWebUrl();

    void setAppConfigHasWebUrl(int hasUrl);

    int getAppConfigHasWebUrl();

    void setUserbId(long login_id);

    long getUserbId();

    void removeUserbId();


    void setAuthkey(String authkey);

    String getAuthkey();

    void removeAuthkey();


    void setIsLogedin(boolean isLogedin);

    boolean getIsLogedin();

    void removeIsLogedin();


    void setSelectedRFIDBLEAddress(String RFIDBLEAddress);

    String getSelectedRFIDBLEAddress();

    void removeSelectedRFIDBLEAddress();


    void setSelectedRFIDBLEName(String RFIDBLEName);

    String getSelectedRFIDBLEName();

    void removeSelectedRFIDBLEName();


    void setSelectedQRBLEAddress(String QRBLEAddress);

    String getSelectedQRBLEAddress();

    void removeSelectedQRBLEAddress();


    void setSelectedQRBLEName(String QRBLEName);

    String getSelectedQRBLEName();

    void removeSelectedQRBLEName();


    void setSelectedUHFBLEAddress(String UHFBLEAddress);

    String getSelectedUHFBLEAddress();

    void removeSelectedUHFBLEAddress();


    void setSelectedUHFBLEName(String UHFBLEName);

    String getSelectedUHFBLEName();

    void removeSelectedUHFBLEName();


    void removeConnectedBtDevicesList();


    void deleteAtLogout();
}
