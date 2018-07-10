package com.example.a17045679.quiz;

import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    EditText Name;
    EditText Age;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Name = findViewById(R.id.editTextName);
        Age = findViewById(R.id.editTextAge);
    }

    @Override
    protected void onPause() {
        super.onPause();

        // Step 1a: Get the user input from the EditText and store it in a variable
        String strName = Name.getText().toString();
        int age = Integer.parseInt(Age.getText().toString());

        // Step 1b: Obtain an instance of the SharedPreferences
        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(this);

        // Step 1c: Obtain an instance of the SharedPreferences Editor for update later
        SharedPreferences.Editor prefEdit = prefs.edit();

        // Step 1d: Add the key-value pair
        prefEdit.putString("Name", strName);
        prefEdit.putInt("Age", age);

        // Step 1e: Call commit() method to save the changes into SharedPreferences
        prefEdit.commit();
    }

    //onResume
    @Override
    protected void onResume() {
        super.onResume();


        // Step 2a: Obtain an instance of the SharedPreferences
        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(this);

        // Step 2b: Retrieve the saved data from the SharedPreferences object
        String msg = prefs.getString("Name", "");
        Integer msg2 = prefs.getInt("Age", 0);


        // Step 2c: Update the UI element with the value
        Name.setText(msg);
        Age.setText(msg2.toString());


    }
}

