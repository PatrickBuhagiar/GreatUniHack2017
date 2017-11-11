package com.example.sophie.remumber;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import static java.lang.Boolean.TRUE;

public class SetUpActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_set_up);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        //if ((new PrefManager(this).sufficientMotherDetails()) == TRUE ){

            TextView textView = (TextView) findViewById(R.id.textView8);
            textView.setText(new PrefManager(this).getName());

            TextView textViewNum = (TextView) findViewById(R.id.textView9);
            textViewNum.setText(new PrefManager(this).getNumber());

        //}

    }

    public void setPreferences(View view) {
    //save the set up preferences when 'SAVE' button on set up screen is pressed

        //get input information
        EditText editText = (EditText) findViewById(R.id.editText);
        EditText editText4 = (EditText) findViewById(R.id.editText4);

        //save input information into PrefManager to make info global
        new PrefManager(this).saveMotherDetails(editText.getText().toString(),editText4.getText().toString());

        //display saved information from global prefmanager to confirm completion
        TextView textView = (TextView) findViewById(R.id.textView8);
        textView.setText(new PrefManager(this).getName());

        TextView textViewNum = (TextView) findViewById(R.id.textView9);
        textViewNum.setText(new PrefManager(this).getNumber());

    }

    public void openMain(View view) {
    //return to the main menu

        Intent intent = new Intent(this, HomeActivity.class);
        startActivity(intent);

    }
}
