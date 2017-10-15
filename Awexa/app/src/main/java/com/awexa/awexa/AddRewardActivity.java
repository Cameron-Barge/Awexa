package com.awexa.awexa;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class AddRewardActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_reward);
    }

    public void addReward(View view) {
        EditText text = (EditText)findViewById(R.id.newRewardName);
        String reward = text.getText().toString();
        //TODO: implementation for adding reward to db/list/whatever
        Toast.makeText(getApplicationContext(), reward + " was added...",
                Toast.LENGTH_SHORT).show();
    }
}
