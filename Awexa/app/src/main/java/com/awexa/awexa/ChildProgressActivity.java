package com.awexa.awexa;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.List;

public class ChildProgressActivity extends AppCompatActivity {
    private String childName = null;
    private List<String> rewards = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // check for passed extras from intent
        if (getIntent().getExtras() != null) {
            // set title as child's name
            childName = getIntent().getExtras().getString("name","Child");
            String title = getString(R.string.child_progress_title, childName);
            setTitle(title);
            // check for new reward
            if (getIntent().getExtras().getString("rewardName") != null) {
                ArrayAdapter rewardsAdapter = new ArrayAdapter<String>(this,
                        R.layout.activity_listview, rewards);
                final ListView rewardsListView = (ListView)findViewById(R.id.rewards_list);
                rewardsListView.setAdapter(rewardsAdapter);
                
                /* Todo: implement rewards detail activity on click
                rewardsListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    public void onItemClick(AdapterView<?> parent, View view, int position,
                                            long id) {

                        Intent intent = new Intent(getApplicationContext(),
                                ChildProgressActivity.class);
                        intent.putExtra("name", childName);
                        startActivity(intent);
                    }
                });
                */

            }
        }
        setContentView(R.layout.activity_child_progress);
    }

    /** Called when the user taps the Add New Reward button */
    public void openNewRewardActivity(View view) {
        // pass child's name back to next activity
        Intent intent = new Intent(getApplicationContext(), AddRewardActivity.class);
        intent.putExtra("name", childName);
        startActivity(intent);
    }

    /** Called when the user taps the Add New Chore button */
    public void openNewChoreActivity(View view) {
        startActivity(new Intent(this, AddChoreActivity.class));
    }
}

