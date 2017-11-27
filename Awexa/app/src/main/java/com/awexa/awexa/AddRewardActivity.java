package com.awexa.awexa;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.ValueEventListener;
import com.mikepenz.fontawesome_typeface_library.FontAwesome;
import com.mikepenz.materialdrawer.Drawer;
import com.mikepenz.materialdrawer.DrawerBuilder;
import com.mikepenz.materialdrawer.model.PrimaryDrawerItem;
import com.mikepenz.materialdrawer.model.SecondaryDrawerItem;
import com.mikepenz.materialdrawer.model.interfaces.IDrawerItem;

public class AddRewardActivity extends AppCompatActivity {
    private static final String TAG = "AddRewardActivity";
    String childId;
    String familyId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_reward);
        if (getIntent().getExtras() != null) {
            childId = getIntent().getExtras().getString("childId", "defaultKey");
        }

        Toolbar toolbar = findViewById(R.id.toolbar);
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
                            startActivity(new Intent(AddRewardActivity.this, MainActivity.class));
                            finish();
                        } else if (position == 1) {
                            startActivity(new Intent(AddRewardActivity.this, SettingsActivity.class));
                        } else {
                            FirebaseAuth.getInstance().signOut();
                            startActivity(new Intent(AddRewardActivity.this, LoginActivity.class));
                            finish();
                        }
                        return true;
                    }
                })
                .build();
        getSupportActionBar().setDisplayHomeAsUpEnabled(false);
        result.getActionBarDrawerToggle().setDrawerIndicatorEnabled(true);
    }

    public void addReward(View view) {
        EditText descriptionEt = (EditText)findViewById(R.id.description);
        EditText nameEt = (EditText)findViewById(R.id.newRewardName);
        EditText pointsEt = (EditText)findViewById(R.id.cost);
        DatabaseReference rewardsDb = FirebaseDatabase.getInstance().getReference("rewards");
        Reward reward = new Reward();
        final String rewardId = rewardsDb.push().getKey();
        reward.name = nameEt.getText().toString();
        reward.description = descriptionEt.getText().toString();
        reward.points = Integer.parseInt(pointsEt.getText().toString());
        rewardsDb.child(rewardId).setValue(reward);
        final DatabaseReference childDb = FirebaseDatabase.getInstance().getReference("children/"
            + childId + "/rewards/" + rewardId);
        childDb.setValue(0);
        final DatabaseReference childFamilyId = FirebaseDatabase.getInstance().getReference("children/"
                + childId + "/familyId");
        childFamilyId.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot snapshot) {
                familyId = (String) snapshot.getValue();
                final DatabaseReference familyDb = FirebaseDatabase.getInstance().getReference("families/"
                        + familyId + "/rewards/" + rewardId);
                familyDb.setValue(true);
            }
            @Override
            public void onCancelled(DatabaseError databaseError) {}
        });
        Toast.makeText(getApplicationContext(), reward + " was added...",
                Toast.LENGTH_SHORT).show();
        Intent intent = new Intent(this, RewardListActivity.class);
        intent.putExtra("childId", childId);
        startActivity(intent);
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

    private void toastMessage(String message){
        Toast.makeText(this,message,Toast.LENGTH_SHORT).show();
    }
}
