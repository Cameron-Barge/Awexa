package com.awexa.awexa;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.mikepenz.fontawesome_typeface_library.FontAwesome;
import com.mikepenz.materialdrawer.Drawer;
import com.mikepenz.materialdrawer.DrawerBuilder;
import com.mikepenz.materialdrawer.model.PrimaryDrawerItem;
import com.mikepenz.materialdrawer.model.SecondaryDrawerItem;
import com.mikepenz.materialdrawer.model.interfaces.IDrawerItem;

public class AddChoreActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_chore);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle(R.string.title_activity_add_chore);

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
                            startActivity(new Intent(AddChoreActivity.this, MainActivity.class));
                            finish();
                        } else if (position == 1) {
                            startActivity(new Intent(AddChoreActivity.this, SettingsActivity.class));
                        } else {
                            FirebaseAuth.getInstance().signOut();
                            startActivity(new Intent(AddChoreActivity.this, LoginActivity.class));
                            finish();
                        }
                        return true;
                    }
                })
                .build();
        getSupportActionBar().setDisplayHomeAsUpEnabled(false);
        result.getActionBarDrawerToggle().setDrawerIndicatorEnabled(true);
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
