package com.awexa.awexa;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class AddRewardActivity extends AppCompatActivity {
    String childId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_reward);
        if (getIntent().getExtras() != null) {
            childId = getIntent().getExtras().getString("childId", "defaultKey");
        }
    }

    public void addReward(View view) {
        EditText descriptionEt = (EditText)findViewById(R.id.description);
        EditText nameEt = (EditText)findViewById(R.id.newRewardName);
        EditText pointsEt = (EditText)findViewById(R.id.cost);
        DatabaseReference rewardsDb = FirebaseDatabase.getInstance().getReference("rewards");
        Reward reward = new Reward();
        String rewardId = rewardsDb.push().getKey();
        reward.name = nameEt.getText().toString();
        reward.description = descriptionEt.getText().toString();
        reward.points = Integer.parseInt(pointsEt.getText().toString());
        rewardsDb.child(rewardId).setValue(reward);
        final DatabaseReference childDb = FirebaseDatabase.getInstance().getReference("children/"
            + childId + "/rewards" + rewardId);
        childDb.setValue(0);
        Toast.makeText(getApplicationContext(), reward + " was added...",
                Toast.LENGTH_SHORT).show();
        finish();
    }

    @Override
    public void onBackPressed() {
        finish();
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.home:
                onBackPressed();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
