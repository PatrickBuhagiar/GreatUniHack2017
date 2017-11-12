package com.example.sophie.remumber;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.telephony.SmsManager;

public class NotifActivity extends Activity {
    public static final String SMS_INTENT_ID_KEY = "com.example.remumber.KEY_SMS";
    public static String NOTIF_TYPE = "com.example.remumber.NOTIF_ID";
    public static String NAME_KEY =  "com.example.remumber.NAME_SMS";
    public static String LOCATION_KEY = "com.example.remumber.LOCATION_SMS";
    public static String PHONE_KEY = "com.example.remumber.NUMBER_SMS";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // Send sms
        Intent launchIntent = getIntent();
        SmsManager sms = SmsManager.getDefault();
        int notifType = launchIntent.getIntExtra(NOTIF_TYPE, 1);
        if(notifType == HomeActivity.locationNotifId) {String message = "Hi " + launchIntent.getStringExtra(NAME_KEY) +
                 launchIntent.getStringExtra(LOCATION_KEY) ;
        sms.sendTextMessage(launchIntent.getStringExtra(PHONE_KEY), null,
                message, null, null);} else if(notifType == HomeActivity.weatherNotifId) {
            System.out.println("TODO: send weather message");
        }
        Intent intent = new Intent(this.getApplicationContext(), HomeActivity.class);
        startActivity(intent);
    }
}
