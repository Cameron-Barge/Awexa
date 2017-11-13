package com.awexa.awexa;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.TextView;

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

/**
 * Created by Corey on 11/12/17.
 */

public class ConfirmChoreActivity extends AppCompatActivity {

    String currentFamily = "";
    DatabaseReference ref;
    DatabaseReference db = FirebaseDatabase.getInstance().getReference();
    private String childId;
    private String choreId;
    private TextView confirmMessageTv;
    private Button confirmButton;
    private Button denyButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_confirm_chore);
        Toolbar toolbar = findViewById(R.id.toolbar);
        confirmMessageTv = (TextView) findViewById(R.id.confirmChoreText);
        confirmButton = (Button) findViewById(R.id.confirm_button);
        denyButton = (Button) findViewById(R.id.dont_confirm_button);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle(R.string.title_activity_confirm_chore);

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
                        startActivity(new Intent(ConfirmChoreActivity.this, MainActivity.class));
                        finish();
                    } else if (position == 1) {
                        startActivity(new Intent(ConfirmChoreActivity.this, SettingsActivity.class));
                    } else {
                        FirebaseAuth.getInstance().signOut();
                        startActivity(new Intent(ConfirmChoreActivity.this, LoginActivity.class));
                        finish();
                    }
                    return true;
                }
            })
            .build();
        getSupportActionBar().setDisplayHomeAsUpEnabled(false);
        result.getActionBarDrawerToggle().setDrawerIndicatorEnabled(true);

        childId = getIntent().getStringExtra("childId");
        choreId = getIntent().getStringExtra("choreId");

        FirebaseDatabase.getInstance().getReference("chores").child(choreId)
            .addListenerForSingleValueEvent(new ValueEventListener() {
                @Override
                public void onDataChange(DataSnapshot snapshot) {
                    final Chore chore = snapshot.getValue(Chore.class);
                    FirebaseDatabase.getInstance().getReference("children").child(childId)
                        .addListenerForSingleValueEvent(new ValueEventListener() {
                            @Override
                            public void onDataChange(DataSnapshot snapshot) {
                                Child child = snapshot.getValue(Child.class);

                                initializeView(chore, child);
                            }

                            @Override
                            public void onCancelled(DatabaseError databaseError) {
                            }
                        });
                }

                @Override
                public void onCancelled(DatabaseError databaseError) {
                }
            });
    }

    private void initializeView(Chore chore, Child child) {
        confirmMessageTv.setText(String.format(getString(R.string.confirm_chore_message)
            + "Is this correct?", child.getName(), chore.getName(), chore.getPoints()));
        confirmButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final DatabaseReference childDb = FirebaseDatabase.getInstance().getReference("children/"
                    + childId);
                childDb.child("chores").child(choreId).setValue("confirmed");
                Intent intent = new Intent(ConfirmChoreActivity.this, MainActivity.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(intent);
            }
        });
        denyButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final DatabaseReference childDb = FirebaseDatabase.getInstance().getReference("children/"
                    + childId);
                childDb.child("chores").child(choreId).setValue("assigned");
                Intent intent = new Intent(ConfirmChoreActivity.this, MainActivity.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(intent);
            }
        });
    }
}
