package com.awexa.awexa;

import android.app.Activity;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.TextView;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.List;

/**
 * Created by Kath on 11/13/2017.
 */

public class RewardStatusListAdapter extends ArrayAdapter {
    private final Activity activity;
    private final int resource;
    private final List<Reward> rewards;
    private final List<Boolean> statuses;
    private final DatabaseReference db;
    private final String childId;

    public RewardStatusListAdapter(@NonNull Activity activity, int resource, String childId,
                                   @NonNull List<Reward> rewards, List<Boolean> statuses) {
        super(activity, resource, rewards);
        this.activity = activity;
        this.resource = resource;
        this.rewards = rewards;
        this.statuses = statuses;
        this.db = FirebaseDatabase.getInstance().getReference();
        this.childId = childId;
    }

    @NonNull
    @Override
    public View getView(int position, View convertView, @NonNull ViewGroup parent) {
        View rowView = convertView;
        ViewHolder view;

        if(rowView == null) {
            LayoutInflater inflater = activity.getLayoutInflater();
            rowView = inflater.inflate(resource, null);

            view = new ViewHolder();
            view.reward = (TextView) rowView.findViewById(R.id.choreOrReward);
            view.status = (CheckBox) rowView.findViewById(R.id.status);

            rowView.setTag(view);
        } else {
            view = (ViewHolder) rowView.getTag();
        }

        final Reward someReward = rewards.get(position);
        view.reward.setText(someReward.getName());
        view.status.setChecked(statuses.get(position));
        view.status.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                DatabaseReference rewardRef = db.child("children/" + childId + "/rewards/" + someReward.rewardId);
                if (b) {
                    rewardRef.setValue(0);
                } else {
                    rewardRef.removeValue();
                }
            }
        });

        return rowView;
    }

    protected static class ViewHolder {
        protected TextView reward;
        protected CheckBox status;
    }
}
