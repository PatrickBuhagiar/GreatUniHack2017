package com.example.sophie.remumber;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.telephony.SmsManager;

public class NotifActivity extends Activity {
    public static final String SMS_INTENT_ID_KEY = "com.example.remumber.KEY_SMS";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // Send sms
        SmsManager sms = SmsManager.getDefault();
        sms.sendTextMessage("07988084064", null, "Notif message", null, null);
        Intent intent = new Intent(this.getApplicationContext(), HomeActivity.class);
        startActivity(intent);
    }
}
