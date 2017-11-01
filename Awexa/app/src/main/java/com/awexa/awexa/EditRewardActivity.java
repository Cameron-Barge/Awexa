package com.awexa.awexa;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.mikepenz.fontawesome_typeface_library.FontAwesome;
import com.mikepenz.materialdrawer.Drawer;
import com.mikepenz.materialdrawer.DrawerBuilder;
import com.mikepenz.materialdrawer.model.PrimaryDrawerItem;
import com.mikepenz.materialdrawer.model.SecondaryDrawerItem;
import com.mikepenz.materialdrawer.model.interfaces.IDrawerItem;

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

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle(R.string.title_activity_add_reward);

        Drawer result = new DrawerBuilder()
            .withActivity(this)
            .withToolbar(toolbar)
            .withTranslucentStatusBar(false)
            .withActionBarDrawerToggle(true)
            .withSelectedItem(-1)
            .addDrawerItems(
                new PrimaryDrawerItem().withName(R.string.drawer_item_home).withIcon(FontAwesome.Icon.faw_home),
                new SecondaryDrawerItem().withName(R.string.drawer_item_settings).withIcon(FontAwesome.Icon.faw_cog),
                new SecondaryDrawerItem().withName(R.string.drawer_item_logout).withIcon(FontAwesome.Icon.faw_sign_out)
            )
            .withOnDrawerItemClickListener(new Drawer.OnDrawerItemClickListener() {
                @Override
                public boolean onItemClick(View view, int position, IDrawerItem drawerItem) {
                    if (position == 0) {
                        startActivity(new Intent(EditRewardActivity.this, MainActivity.class));
                        finish();
                    } else if (position == 1) {
                        startActivity(new Intent(EditRewardActivity.this, SettingsActivity.class));
                    } else {
                        FirebaseAuth.getInstance().signOut();
                        startActivity(new Intent(EditRewardActivity.this, LoginActivity.class));
                        finish();
                    }
                    return true;
                }
            })
            .build();
        getSupportActionBar().setDisplayHomeAsUpEnabled(false);
        result.getActionBarDrawerToggle().setDrawerIndicatorEnabled(true);

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
        nameEt.setText(r.getName());
        descriptionEt.setText(r.getDescription());
        pointsEt.setText(String.valueOf(r.getPoints()));
    }

    public void addReward(View view) {
        EditText descriptionEt = (EditText)findViewById(R.id.description);
        EditText nameEt = (EditText)findViewById(R.id.newRewardName);
        EditText pointsEt = (EditText)findViewById(R.id.cost);
        DatabaseReference rewardsDb = FirebaseDatabase.getInstance().getReference("rewards");
        Reward reward = new Reward();
        reward.setName(nameEt.getText().toString());
        reward.setDescription(descriptionEt.getText().toString());
        reward.setPoints(Integer.parseInt(pointsEt.getText().toString()));
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
