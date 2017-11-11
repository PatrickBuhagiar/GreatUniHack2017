package com.example.sophie.remumber;

import android.content.Context;
import android.content.SharedPreferences;

/**
 * Created by tjtma on 11/11/2017.
 */

public class PrefManager {

    Context context;

    PrefManager(Context context) {
        this.context = context;
    }

    public void saveMotherDetails(String name, String phoneNumber) {
        SharedPreferences sharedPreferences = context.getSharedPreferences("MothersDetails", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString("Name", name);
        editor.putString("Number", phoneNumber);
        editor.commit();
    }

    //method to access set number globally through new PrefManager(this).getName
    public String getName() {
        SharedPreferences sharedPreferences = context.getSharedPreferences("MothersDetails", Context.MODE_PRIVATE);
        return sharedPreferences.getString("Name", "");
    }

    //like getName
    public String getNumber() {
        SharedPreferences sharedPreferences = context.getSharedPreferences("MothersDetails", Context.MODE_PRIVATE);
        return sharedPreferences.getString("Number", "");
    }

    public boolean sufficientMotherDetails() {
        SharedPreferences sharedPreferences = context.getSharedPreferences("MothersDetails", Context.MODE_PRIVATE);
        boolean isNameEmpty = sharedPreferences.getString("Name", "").isEmpty();
        boolean isNumberEmpty = sharedPreferences.getString("Number", "").isEmpty();
        return isNameEmpty || isNumberEmpty;
    }

}
