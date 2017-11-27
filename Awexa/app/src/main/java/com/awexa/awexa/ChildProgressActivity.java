package com.awexa.awexa;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import android.support.v7.widget.Toolbar;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.mikepenz.fontawesome_typeface_library.FontAwesome;
import com.mikepenz.materialdrawer.Drawer;
import com.mikepenz.materialdrawer.DrawerBuilder;
import com.mikepenz.materialdrawer.model.PrimaryDrawerItem;
import com.mikepenz.materialdrawer.model.SecondaryDrawerItem;
import com.mikepenz.materialdrawer.model.interfaces.IDrawerItem;

public class ChildProgressActivity extends AppCompatActivity {
    private static final String TAG = "ChildProgressActivity";
    boolean validParent;

    TextView rewardPts;
    ListView choreList;
    ListView rewardsList;
    FirebaseDatabase database;
    private ChoreAdapter choreAdapter;
    private RewardAdapter rewardAdapter;
    List<Chore> chores = new ArrayList<>();
    List<Reward> rewards = new ArrayList<>();
    List<Integer> rewardCounts = new ArrayList<>();
    List<String> statusList = new ArrayList<>();
    List<Integer> purchaseList = new ArrayList<>();
    Child c;
    AppCompatActivity thisAct = this;
    String childId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_child_progress);
        rewardPts = (TextView) findViewById(R.id.rewardsPoints);
        choreList = (ListView) findViewById(R.id.chores_list);
        rewardsList = (ListView) findViewById(R.id.rewards_list);
        database = FirebaseDatabase.getInstance();

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        if (getIntent().getExtras() != null) {
            validParent = getIntent().getBooleanExtra("validParent", false);
            View btnAddNewReward = findViewById(R.id.addNewReward);
            View btnAddNewChore = findViewById(R.id.addNewChore);
            if (!validParent) {
                btnAddNewReward.setVisibility(View.INVISIBLE);
                btnAddNewChore.setVisibility(View.INVISIBLE);
            } else {
                btnAddNewReward.setVisibility(View.VISIBLE);
                btnAddNewChore.setVisibility(View.VISIBLE);
            }
        }

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
                            startActivity(new Intent(ChildProgressActivity.this, MainActivity.class));
                            finish();
                        } else if (position == 1) {
                            startActivity(new Intent(ChildProgressActivity.this, SettingsActivity.class));
                        } else {
                            FirebaseAuth.getInstance().signOut();
                            startActivity(new Intent(ChildProgressActivity.this, LoginActivity.class));
                            finish();
                        }
                        return true;
                    }
                })
                .build();
        getSupportActionBar().setDisplayHomeAsUpEnabled(false);
        result.getActionBarDrawerToggle().setDrawerIndicatorEnabled(true);

        if (getIntent().getExtras() != null) {
            childId = getIntent().getExtras().getString("childId","defaultKey");
            DatabaseReference childDb = database.getReference("children");
            String title = "Loading";
            getSupportActionBar().setTitle(title);
            childDb.child(childId)
                .addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(DataSnapshot snapshot) {
                        Log.i(TAG, "childId: " + childId);
                        c = snapshot.getValue(Child.class);
                        c.setChildId(childId);
                        for (String status : c.getChores().values()) {
                            statusList.add(status);
                        }
                        for (int purchases : c.getRewards().values()) {
                            purchaseList.add(purchases);
                        }
                        updateView(c);
                    }

                    @Override
                    public void onCancelled(DatabaseError databaseError) {
                    }
                });
            choreList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                    final Intent intent = new Intent(thisAct, EditChoreActivity.class);
                    intent.putExtra("choreId", chores.get(position).choreId);
                    intent.putExtra("childId", childId);
                    intent.putExtra("validParent", validParent);
                    startActivityForResult(intent, 1);
                }
            });
            rewardsList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                    final Intent intent = new Intent(thisAct, EditRewardActivity.class);
                    intent.putExtra("rewardId", rewards.get(position).rewardId);
                    intent.putExtra("childId", childId);
                    intent.putExtra("validParent", validParent);
                    startActivityForResult(intent, 0);
                    Log.d(TAG, "onItemClick: ");
                }
            });
        }
    }

    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        updateView(c);
    }

    private void updateView(final Child c) {
        //update the title
        String title = c.name;
        getSupportActionBar().setTitle(title);
        rewardPts.setText("Points: " + String.valueOf(c.points));
        DatabaseReference choresDb = database.getReference("chores");

        chores = new ArrayList<>();
        for (final String choreId: c.chores.keySet()) {
            Log.d("chore", choreId);
            choresDb.child(choreId)
                .addListenerForSingleValueEvent(new ValueEventListener() {
                    @Override
                    public void onDataChange(DataSnapshot snapshot) {
                        Log.d(snapshot.toString(), "test");
                        Chore chore = snapshot.getValue(Chore.class);
                        chore.setChoreId(choreId);
                        chores.add(chore);
                        choreAdapter = new ChoreAdapter(thisAct,
                            R.layout.activity_reward_chore_listview, chores, statusList);
                        choreList.setAdapter(choreAdapter);
                        choreAdapter.notifyDataSetChanged();
                    }

                    @Override
                    public void onCancelled(DatabaseError databaseError) {
                    }
                });
        }

        DatabaseReference rewardsDb = database.getReference("rewards");
        rewards = new ArrayList<>();
        for (final String rewardId: c.rewards.keySet()) {
            rewardsDb.child(rewardId)
                .addListenerForSingleValueEvent(new ValueEventListener() {
                    @Override
                    public void onDataChange(DataSnapshot snapshot) {
                        Reward reward = snapshot.getValue(Reward.class);
                        reward.setRewardId(rewardId);
                        rewards.add(reward);
                        rewardCounts.add(c.rewards.get(reward.rewardId));
                        rewardAdapter = new RewardAdapter(thisAct,
                            R.layout.activity_reward_chore_listview, rewards, rewardCounts);
                        rewardsList.setAdapter(rewardAdapter);
                        rewardAdapter.notifyDataSetChanged();
                    }

                    @Override
                    public void onCancelled(DatabaseError databaseError) {
                    }
                });
        }
    }

    /** Called when the user taps the Add New Reward button */
    public void openNewRewardActivity(View view) {
        Intent intent = new Intent(this, RewardListActivity.class);
        intent.putExtra("childId", childId);
        startActivityForResult(intent, 0);
    }

    /** Called when the user taps the Add New Chore button */
    public void openNewChoreActivity(View view) {
        Intent intent = new Intent(this, AddChoreActivity.class);
        intent.putExtra("childId", childId);
        startActivityForResult(intent, 1);
    }

    private void toastMessage(String message){
        Toast.makeText(this,message,Toast.LENGTH_SHORT).show();
    }
}
