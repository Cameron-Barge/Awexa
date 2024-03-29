package com.awexa.awexa;

import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Build;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.PopupWindow;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.mikepenz.fontawesome_typeface_library.FontAwesome;
import com.mikepenz.materialdrawer.Drawer;
import com.mikepenz.materialdrawer.DrawerBuilder;
import com.mikepenz.materialdrawer.model.PrimaryDrawerItem;
import com.mikepenz.materialdrawer.model.SecondaryDrawerItem;
import com.mikepenz.materialdrawer.model.interfaces.IDrawerItem;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "MainActivity";
    DatabaseReference db = FirebaseDatabase.getInstance().getReference();
    String currentFamily = "";
    DatabaseReference ref;
    public List<String> family = new ArrayList<>();
    public List<String> parents = new ArrayList<>();
    public List<String> childIds = new ArrayList<>();
    public String familyPass = "";
    public boolean validParent = false;
    ArrayAdapter adapter = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle(R.string.title_activity_main);
        currentFamily = FirebaseAuth.getInstance().getCurrentUser().getUid();
        ref = db.child("families/" + currentFamily);
        adapter = new ArrayAdapter<String>(this,
                R.layout.activity_listview, family);

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
                            startActivity(new Intent(MainActivity.this, MainActivity.class));
                            finish();
                        } else if (position == 1) {
                            startActivity(new Intent(MainActivity.this, SettingsActivity.class));
                        } else {
                            FirebaseAuth.getInstance().signOut();
                            startActivity(new Intent(MainActivity.this, LoginActivity.class));
                            finish();
                        }
                        return true;
                    }
                })
                .build();
        getSupportActionBar().setDisplayHomeAsUpEnabled(false);
        result.getActionBarDrawerToggle().setDrawerIndicatorEnabled(true);

        DatabaseReference familyPassRef = ref.child("/familyPass");
        familyPassRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                familyPass = dataSnapshot.getValue().toString();
            }
            @Override
            public void onCancelled(DatabaseError databaseError) {
                Log.e(TAG, "onCancelled", databaseError.toException());
            }
        });

        DatabaseReference parentIDRef = db.child("families/" + currentFamily + "/parents");
        parentIDRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                for(DataSnapshot singleSnapshot : dataSnapshot.getChildren()){
                    DatabaseReference parentRef = db.child("parents/" + singleSnapshot.getKey() + "/name");
                    parentRef.addListenerForSingleValueEvent(new ValueEventListener() {
                        @Override
                        public void onDataChange(DataSnapshot parentSnapshot) {
                            String parentName = (String)parentSnapshot.getValue();
                            if (!parents.contains(parentName)) {
                                family.add(parentName);
                                parents.add(parentName);
                                Log.i(TAG, "parents array size: " + String.valueOf(parents.size()));
                                adapter.notifyDataSetChanged();
                            }
                        }
                        @Override
                        public void onCancelled(DatabaseError databaseError) {
                            Log.e(TAG, "onCancelled", databaseError.toException());
                        }
                    });
                }
            }
            @Override
            public void onCancelled(DatabaseError databaseError) {
                Log.e(TAG, "onCancelled", databaseError.toException());
            }
        });

        DatabaseReference childRef = db.child("families/" + currentFamily + "/child_names");
        childRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                for(DataSnapshot singleSnapshot : dataSnapshot.getChildren()){
                    String childName = singleSnapshot.getKey();
                    String childId = (String) singleSnapshot.getValue();
                    if (!childIds.contains(childId)) {
                        family.add(childName);
                        childIds.add(childId);
                        Log.i(TAG, childId);
                        Log.i(TAG, "childIds size: " + String.valueOf(childIds.size()));
                    }
                }
                Collections.sort(family);
                adapter.notifyDataSetChanged();
            }
            @Override
            public void onCancelled(DatabaseError databaseError) {
                Log.e(TAG, "onCancelled", databaseError.toException());
            }
        });

        final ListView listView = (ListView) findViewById(R.id.children_list);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String name = ((TextView) view).getText().toString();
                if (parents.contains(name)) {
                    showPopupWindow(view);
                } else {
                    if (validParent) {
                        Intent intent = new Intent(MainActivity.this, ChildProgressActivity.class);
                        intent.putExtra("name", name);
                        intent.putExtra("childId", childIds.get(position));
                        intent.putExtra("validParent", validParent);
                        startActivity(intent);
                    } else {
                        Intent intent = new Intent(MainActivity.this, ChildProgressActivity.class);
                        intent.putExtra("name", name);
                        intent.putExtra("childId", childIds.get(position));
                        startActivity(intent);
                    }
                }
            }
        });

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, AddFamilyMemberActivity.class));
            }
        });

        SharedPreferences sp = getSharedPreferences("AWEXA_APP", 0);
        if (sp.getBoolean("TokenIDUpdated", true)) {
            String token = sp.getString("IDToken", "default");
            DatabaseReference familyDb = FirebaseDatabase.getInstance().getReference("families/"
                + currentFamily + "/device_ids");
            familyDb.child(token).setValue(true);
        }
    }

    public void showPopupWindow(View view) {
        // get a reference to the already created main layout
        RelativeLayout mainLayout = (RelativeLayout) findViewById(R.id.activity_main_layout);

        // inflate the layout of the popup window
        LayoutInflater inflater = (LayoutInflater) getSystemService(LAYOUT_INFLATER_SERVICE);
        View popupView = inflater.inflate(R.layout.popup_window, null);


        final EditText password = popupView.findViewById(R.id.password);
        Button submit = popupView.findViewById(R.id.popup_submit);
        Button cancel = popupView.findViewById(R.id.popup_cancel);

        // create the popup window
        int width = RelativeLayout.LayoutParams.WRAP_CONTENT;
        int height = RelativeLayout.LayoutParams.WRAP_CONTENT;
        boolean focusable = true; // lets taps outside the popup also dismiss it
        final PopupWindow popupWindow = new PopupWindow(popupView, width, height, focusable);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            popupWindow.setElevation(10);
        }
        popupWindow.setBackgroundDrawable(new ColorDrawable(Color.WHITE));

        // show the popup window
        popupWindow.showAtLocation(mainLayout, Gravity.CENTER, 0, 0);

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (familyPass.equals(password.getText().toString())) {
                    toastMessage("Passwords match!");
                    validParent = true;
                } else {
                    toastMessage("Incorrect password.");
                }
            }
        });

        cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                popupWindow.dismiss();
            }
        });
    }

    private void toastMessage(String message){
        Toast.makeText(this,message,Toast.LENGTH_SHORT).show();
    }
}