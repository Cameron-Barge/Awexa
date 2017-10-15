package com.awexa.awexa;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class AddChoreActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_chore);
    }

    public void addChore(View view) {
        EditText text = (EditText)findViewById(R.id.newChoreName);
        String chore = text.getText().toString();
        //TODO: implementation for adding chore to db/list/whatever
        Toast.makeText(getApplicationContext(), chore + " was added...",
                Toast.LENGTH_SHORT).show();
    }
}
