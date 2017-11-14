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

public class ChoreAdapter extends ArrayAdapter {
    private final Activity activity;
    private final int resource;
    private final List choreNames;
    private final List choreStatus;

    public ChoreAdapter(@NonNull Activity activity, int resource, @NonNull List choreNames, List choreStatus) {
        super(activity, resource, choreNames);
        this.activity = activity;
        this.resource = resource;
        this.choreNames = choreNames;
        this.choreStatus = choreStatus;
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
            view.choreName = (TextView) rowView.findViewById(R.id.choreOrReward);
            view.choreStatus = (TextView) rowView.findViewById(R.id.statusOrPurchases);

            rowView.setTag(view);
        } else {
            view = (ViewHolder) rowView.getTag();
        }

        Chore someChore = (Chore) choreNames.get(position);
        String someStatus = (String) choreStatus.get(position);
        view.choreName.setText(someChore.getName());
        view.choreStatus.setText(someStatus);

        return rowView;
    }

    protected static class ViewHolder {
        protected TextView choreName;
        protected TextView choreStatus;
    }
}
