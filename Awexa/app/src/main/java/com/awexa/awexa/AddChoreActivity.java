package com.awexa.awexa;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

public class AddChoreActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_chore);
    }

    public void addChore(View view) {
        // Instantiate fields and respective variables
        EditText choreNameField = (EditText)findViewById(R.id.newChoreName);
        String choreName = choreNameField.getText().toString();
        EditText rewardPointsField = (EditText)findViewById(R.id.reward);
        int rewardPoints = Integer.parseInt(rewardPointsField.getText().toString());
        
        CheckBox weeklyRepeatCheckbox = (CheckBox)findViewById(R.id.repeatCheck);
        boolean weeklyRepeat = weeklyRepeatCheckbox.isChecked();
        CheckBox sunCheckbox = (CheckBox)findViewById(R.id.sunCheck);
        boolean sunRepeat = sunCheckbox.isChecked();
        CheckBox monCheckbox = (CheckBox)findViewById(R.id.monCheck);
        boolean monRepeat = monCheckbox.isChecked();
        CheckBox tuesCheckbox = (CheckBox)findViewById(R.id.tueCheck);
        boolean tuesRepeat = tuesCheckbox.isChecked();
        CheckBox wedCheckbox = (CheckBox)findViewById(R.id.wedCheck);
        boolean wedRepeat = wedCheckbox.isChecked();
        CheckBox thursCheckbox = (CheckBox)findViewById(R.id.thuCheck);
        boolean thursRepeat = thursCheckbox.isChecked();
        CheckBox friCheckbox = (CheckBox)findViewById(R.id.friCheck);
        boolean friRepeat = friCheckbox.isChecked();
        CheckBox satCheckbox = (CheckBox)findViewById(R.id.satCheck);
        boolean satRepeat = satCheckbox.isChecked();

        EditText descriptionField = (EditText)findViewById(R.id.description);
        String description = descriptionField.getText().toString();

        //TODO: implementation for adding chore to db/list/whatever
        Toast.makeText(getApplicationContext(), choreName + " was added...",
                Toast.LENGTH_SHORT).show();
    }
}
