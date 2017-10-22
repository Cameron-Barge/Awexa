package com.awexa.awexa;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.text.SimpleDateFormat;
import java.util.HashMap;

public class EditRewardActivity extends AppCompatActivity {
    String childId;
    String rewardId;
    EditText nameEt;
    EditText pointsEt;
    EditText descriptionEt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_reward);
        if (getIntent().getExtras() != null) {
            childId = getIntent().getExtras().getString("childId", "defaultKey");
            rewardId = getIntent().getExtras().getString("rewardId", "defaultKey");
        }
        nameEt = (EditText) findViewById(R.id.newRewardName);
        pointsEt = (EditText) findViewById(R.id.cost);
        descriptionEt = (EditText) findViewById(R.id.description);

        FirebaseDatabase.getInstance().getReference("rewards").child(rewardId)
            .addListenerForSingleValueEvent(new ValueEventListener() {
                @Override
                public void onDataChange(DataSnapshot snapshot) {
                    Reward reward = snapshot.getValue(Reward.class);

                    initializeView(reward);
                }

                @Override
                public void onCancelled(DatabaseError databaseError) {
                }
            });
    }


    public void initializeView(Reward r) {
        nameEt.setText(r.name);
        descriptionEt.setText(r.description);
        pointsEt.setText(String.valueOf(r.points));
    }

    public void addReward(View view) {
        EditText descriptionEt = (EditText)findViewById(R.id.description);
        EditText nameEt = (EditText)findViewById(R.id.newRewardName);
        EditText pointsEt = (EditText)findViewById(R.id.cost);
        DatabaseReference rewardsDb = FirebaseDatabase.getInstance().getReference("rewards");
        Reward reward = new Reward();
        reward.name = nameEt.getText().toString();
        reward.description = descriptionEt.getText().toString();
        reward.points = Integer.parseInt(pointsEt.getText().toString());
        rewardsDb.child(rewardId).setValue(reward);
        final DatabaseReference childDb = FirebaseDatabase.getInstance().getReference("children/"
            + childId + "/rewards" + rewardId);
        childDb.setValue(0);
        Toast.makeText(getApplicationContext(), reward + " was updated...",
            Toast.LENGTH_SHORT).show();
        finish();
    }

    @Override
    public void onBackPressed() {
        finish();
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        finish();
        return true;
    }
}
