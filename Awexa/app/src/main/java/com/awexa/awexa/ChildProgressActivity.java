package com.awexa.awexa;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;

public class ChildProgressActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_child_progress);
    }

    /** Called when the user taps the Add New Reward button */
    public void openNewRewardActivity(View view) {
        startActivity(new Intent(this, AddRewardActivity.class));
    }

    /** Called when the user taps the Add New Chore button */
    public void openNewChoreActivity(View view) {
        startActivity(new Intent(this, AddChoreActivity.class));
    }
}
