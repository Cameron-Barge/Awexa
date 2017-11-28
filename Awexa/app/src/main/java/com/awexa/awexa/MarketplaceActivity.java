package com.awexa.awexa;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.ListView;

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

import java.util.ArrayList;
import java.util.List;

public class MarketplaceActivity extends AppCompatActivity {
    private String childId;
    private String familyId;
    DatabaseReference db;
    List<String> familyRewardIds = new ArrayList<>();
    List<String> marketPlaceRewardIds = new ArrayList<>();
    List<Reward> marketplaceRewards = new ArrayList<>();
    List<Boolean> statuses = new ArrayList<>();
    private RewardStatusListAdapter rewardAdapter;
    ListView rewardsList;
    Activity thisAct;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_marketplace);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle(R.string.title_activity_marketplace);

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
                            startActivity(new Intent(MarketplaceActivity.this, MainActivity.class));
                            finish();
                        } else if (position == 1) {
                            startActivity(new Intent(MarketplaceActivity.this, SettingsActivity.class));
                        } else {
                            FirebaseAuth.getInstance().signOut();
                            startActivity(new Intent(MarketplaceActivity.this, LoginActivity.class));
                            finish();
                        }
                        return true;
                    }
                })
                .build();
        getSupportActionBar().setDisplayHomeAsUpEnabled(false);
        result.getActionBarDrawerToggle().setDrawerIndicatorEnabled(true);

        thisAct = this;
        rewardsList = (ListView) findViewById(R.id.marketplace_list);
        db = FirebaseDatabase.getInstance().getReference();
        if (getIntent().getExtras() != null) {
            childId = getIntent().getExtras().getString("childId", "defaultKey");
        }
        familyId = FirebaseAuth.getInstance().getCurrentUser().getUid();
        updateRewardList();
    }

    private void updateRewardList() {
        //get all rewards from family list of rewards
        DatabaseReference childRef = db.child("families/" + familyId + "/rewards");
        childRef.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                for(DataSnapshot singleSnapshot : dataSnapshot.getChildren()){
                    String rewardId = (String) singleSnapshot.getKey();
                    if (!familyRewardIds.contains(rewardId)) {
                        familyRewardIds.add(rewardId);
                    }
                }
                //get all rewards from child
                DatabaseReference childRef = db.child("marketplace");
                childRef.addListenerForSingleValueEvent(new ValueEventListener() {
                    @Override
                    public void onDataChange(DataSnapshot dataSnapshot) {
                        for (DataSnapshot singleSnapshot : dataSnapshot.getChildren()) {
                            String rewardId = (String) singleSnapshot.getKey();
                            marketPlaceRewardIds.add(rewardId);
                        }
                        //get reward info
                        for (final String rewardId: marketPlaceRewardIds) {
                            db.child("rewards").child(rewardId)
                                .addListenerForSingleValueEvent(new ValueEventListener() {
                                    @Override
                                    public void onDataChange(DataSnapshot snapshot) {
                                        Reward reward = snapshot.getValue(Reward.class);
                                        reward.setRewardId(rewardId);
                                        statuses.add(familyRewardIds.contains(rewardId));
                                        marketplaceRewards.add(reward);
                                        rewardAdapter = new RewardStatusListAdapter(thisAct,
                                            R.layout.activity_reward_status_listview, childId,
                                            marketplaceRewards, statuses,
                                            new OnCheckInterface<Reward, Boolean>() {
                                                @Override
                                                public void accept(Reward someReward, Boolean b) {
                                                    DatabaseReference rewardRefParent = db.child("families/" + familyId + "/rewards/" + someReward.rewardId);
                                                    DatabaseReference rewardRefChild = db.child("children/" + childId + "/rewards/" + someReward.rewardId);
                                                    if (b) {
                                                        rewardRefParent.setValue(true);
                                                        rewardRefChild.setValue(0);
                                                    } else {
                                                        rewardRefParent.removeValue();
                                                        rewardRefChild.removeValue();
                                                    }
                                                }
                                            });
                                        rewardsList.setAdapter(rewardAdapter);
                                        rewardAdapter.notifyDataSetChanged();
                                    }

                                    @Override
                                    public void onCancelled(DatabaseError databaseError) {
                                    }
                                });
                        }
                    }

                    @Override
                    public void onCancelled(DatabaseError databaseError) {
                        Log.e("rewardlistactivity", "onCancelled", databaseError.toException());
                    }
                });
            }
            @Override
            public void onCancelled(DatabaseError databaseError) {
                Log.e("rewardlistactivity", "onCancelled", databaseError.toException());
            }
        });
    }
}
