package com.awexa.awexa;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class AddRewardActivity extends AppCompatActivity {
    String childName = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_reward);
        if (getIntent().getExtras() != null) {
            childName = getIntent().getExtras().getString("name", "Child");
        }
    }

    public void addReward(View view) {
        //pull variables from layout
        EditText nameField = (EditText)findViewById(R.id.newRewardName);
        String rewardName = nameField.getText().toString();
        EditText costField = (EditText)findViewById(R.id.cost);
        String rewardCost = costField.getText().toString();
        // int rewardCost = Integer.parseInt(costField.getText().toString());
        EditText descriptionField = (EditText)findViewById(R.id.description);
        String rewardDescription = descriptionField.getText().toString();

        Toast.makeText(getApplicationContext(), rewardName + " was added...",
                Toast.LENGTH_SHORT).show();

        // pass variables to child progress activity
        Intent intent = new Intent(this, ChildProgressActivity.class);
        Bundle extras = new Bundle();
        extras.putString("name", childName);
        String[] reward = {rewardName, rewardDescription};
        extras.putStringArray("reward", reward);
        intent.putExtras(extras);
        startActivity(intent);



    }
}
