package com.awexa.awexa;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.mikepenz.fontawesome_typeface_library.FontAwesome;
import com.mikepenz.materialdrawer.Drawer;
import com.mikepenz.materialdrawer.DrawerBuilder;
import com.mikepenz.materialdrawer.model.PrimaryDrawerItem;
import com.mikepenz.materialdrawer.model.SecondaryDrawerItem;
import com.mikepenz.materialdrawer.model.interfaces.IDrawerItem;

public class AddFamilyMemberActivity extends AppCompatActivity {
    private RadioGroup radioFamilyMemberGroup;
    private RadioButton radioFamilyMemberButton;
    private String familyMemberType;
    DatabaseReference db = FirebaseDatabase.getInstance().getReference();
    String currentFamily = "";
    EditText name;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_family_member);

        currentFamily = FirebaseAuth.getInstance().getCurrentUser().getUid();

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle(R.string.title_activity_add_family_member);

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
                            startActivity(new Intent(AddFamilyMemberActivity.this, MainActivity.class));
                            finish();
                        } else if (position == 1) {
                            startActivity(new Intent(AddFamilyMemberActivity.this, SettingsActivity.class));
                        } else {
                            FirebaseAuth.getInstance().signOut();
                            startActivity(new Intent(AddFamilyMemberActivity.this, LoginActivity.class));
                            finish();
                        }
                        return true;
                    }
                })
                .build();
        getSupportActionBar().setDisplayHomeAsUpEnabled(false);
        result.getActionBarDrawerToggle().setDrawerIndicatorEnabled(true);
    }

    /** Called when the user taps the Submit button */
    public void addFamilyMember(View view) {
        name = (EditText) findViewById(R.id.familyMemberName);
        String familyMemberName = name.getText().toString();
        radioFamilyMemberGroup = (RadioGroup) findViewById(R.id.radioFamilyMember);
        int selectedId = radioFamilyMemberGroup.getCheckedRadioButtonId();
        radioFamilyMemberButton = (RadioButton) findViewById(selectedId);
        familyMemberType = radioFamilyMemberButton.getText().toString();
        if (radioFamilyMemberButton.getText().toString().equals("Child")) {
            Child child = new Child(familyMemberName, currentFamily);
            DatabaseReference childRef = db.child("children");
            String childID = childRef.push().getKey();
            childRef.child(childID).setValue(child);
            DatabaseReference childNamesRef = db.child("families/" + currentFamily + "/child_names/" + familyMemberName);
            childNamesRef.setValue(childID);
            DatabaseReference childrenRef = db.child("families/" + currentFamily + "/children/" + childID);
            childrenRef.setValue(true);
            Toast.makeText(getApplicationContext(), familyMemberType + " " + familyMemberName + " was added...",
                    Toast.LENGTH_SHORT).show();
        } else if (radioFamilyMemberButton.getText().toString().equals("Parent")) {
            Parent parent = new Parent(familyMemberName);
            DatabaseReference parentRef = db.child("parents");
            String parentID = parentRef.push().getKey();
            parentRef.child(parentID).setValue(parent);
            DatabaseReference parentsRef = db.child("families/" + currentFamily + "/parents/" + parentID);
            parentsRef.setValue(true);
            Toast.makeText(getApplicationContext(), familyMemberType + " " + familyMemberName + " was added...",
                    Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(getApplicationContext(), "Please select a radio button.",
                    Toast.LENGTH_SHORT).show();
        }
    }
}