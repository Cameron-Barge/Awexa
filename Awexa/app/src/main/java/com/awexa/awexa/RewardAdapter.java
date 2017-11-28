package com.awexa.awexa;

import android.app.Activity;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

/**
 * Created by Kath on 11/13/2017.
 */

public class RewardAdapter extends ArrayAdapter {
    private final Activity activity;
    private final int resource;
    private final List<Reward> rewards;
    private final List<Integer> rewardCounts;

    public RewardAdapter(@NonNull Activity activity, int resource, @NonNull List<Reward> rewards,
                         @NonNull List<Integer> rewardCounts) {
        super(activity, resource, rewards);
        this.activity = activity;
        this.resource = resource;
        this.rewards = rewards;
        this.rewardCounts = rewardCounts;
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
            view.purchaseCount = (TextView) rowView.findViewById(R.id.statusOrPurchases);

            rowView.setTag(view);
        } else {
            view = (ViewHolder) rowView.getTag();
        }

        Reward someReward = (Reward) rewards.get(position);
        view.reward.setText(someReward.getName());
        view.purchaseCount.setText(String.valueOf(rewardCounts.get(position)));

        return rowView;
    }

    protected static class ViewHolder {
        protected TextView reward;
        protected TextView purchaseCount;
    }
}
