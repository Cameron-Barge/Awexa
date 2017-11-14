package com.awexa.awexa;

import android.app.Activity;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.TextView;

import java.util.List;

/**
 * Created by Kath on 11/13/2017.
 */

public class RewardStatusListAdapter extends ArrayAdapter {
    private final Activity activity;
    private final int resource;
    private final List<Reward> rewards;
    private final List<Boolean> statuses;

    public RewardStatusListAdapter(@NonNull Activity activity, int resource,
                                   @NonNull List<Reward> rewards, List<Boolean> statuses) {
        super(activity, resource, rewards);
        this.activity = activity;
        this.resource = resource;
        this.rewards = rewards;
        this.statuses = statuses;
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

        Reward someReward = rewards.get(position);
        view.reward.setText(someReward.getName());
        view.status.setChecked(statuses.get(position));

        return rowView;
    }

    protected static class ViewHolder {
        protected TextView reward;
        protected CheckBox status;
    }
}
