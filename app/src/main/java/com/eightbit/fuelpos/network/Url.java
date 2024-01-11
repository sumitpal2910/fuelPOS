package com.eightbit.fuelpos.network;

import com.eightbit.fuelpos.BuildConfig;

public class Url {

    public static final String BASE_URL = BuildConfig.BASE_URL;

   /* public static final String OTP_LOGIN_URL = "login/mobile";
    public static final String OTP_RESEND_URL = "login/otp/resend";
    public static final String OTP_VERIFY_URL = "login/otp/verify";
    public static final String LOGOUT_URL = "logout";*/

    public static final String READ_RFID_DATA_URL = "data/read/rfid";

    public static final String READ_QR_DATA_URL = "data/read/qr";

    public static final String READ_UHF_DATA_URL = "data/read/uhf";

    public static final String App_Config_url = "config/get";

    public static final String ANPR_URL = "/getvaluebyanpr";

    public static final String SEND_OTP_URL = "send-otp";

    public static final String VERIFY_OTP_URL = "verify-otp";

    public static final String RESEND_OTP_URL = "resend-otp";

    public static final String LOGOUT_URL = "logout";
}
