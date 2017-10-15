package com.awexa.awexa;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class AddChildActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_child);
    }

    /** Called when the user taps the Submit button */
    public void addChild(View view) {
        EditText text = (EditText)findViewById(R.id.childName);
        String child = text.getText().toString();
        //TODO: implementation for adding child to db/list/whatever
        Toast.makeText(getApplicationContext(), child + " was added...",
                Toast.LENGTH_SHORT).show();
    }
}