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

public class ChoreRewardAdapter extends ArrayAdapter {
    private final Activity activity;
    private final int resource;
    private final List choresOrRewards;
    private final List statusOrPurchases;
    private final boolean chore;

    public ChoreRewardAdapter(@NonNull Activity activity, int resource, @NonNull List choresOrRewards, List statusOrPurchases) {
        super(activity, resource, choresOrRewards);
        this.activity = activity;
        this.resource = resource;
        this.choresOrRewards = choresOrRewards;
        this.statusOrPurchases = statusOrPurchases;
        if (choresOrRewards.get(0) instanceof Chore) {
            chore = true;
        } else {
            chore = false;
        }
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View rowView = convertView;
        ViewHolder view;

        if(rowView == null) {
            LayoutInflater inflater = activity.getLayoutInflater();
            rowView = inflater.inflate(resource, null);

            view = new ViewHolder();
            view.choreOrReward= (TextView) rowView.findViewById(R.id.choreOrReward);
            view.statusOrPurchases= (TextView) rowView.findViewById(R.id.statusOrPurchases);

            rowView.setTag(view);
        } else {
            view = (ViewHolder) rowView.getTag();
        }

        if (chore) {
            Chore someChore = (Chore) choresOrRewards.get(position);
            String someStatus = (String) statusOrPurchases.get(position);
            view.choreOrReward.setText(someChore.getName());
            view.statusOrPurchases.setText(someStatus);
        } else {
            Reward someReward = (Reward) choresOrRewards.get(position);
            int somePurchaseAmount = (int) statusOrPurchases.get(position);
            view.choreOrReward.setText(someReward.getName());
            view.statusOrPurchases.setText(Integer.toString(somePurchaseAmount));
        }

        return rowView;
    }

    protected static class ViewHolder{
        protected TextView choreOrReward;
        protected TextView statusOrPurchases;
    }
}
