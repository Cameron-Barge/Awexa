package com.awexa.awexa;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Build;
import android.os.Bundle;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
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
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "MainActivity";
    DatabaseReference db = FirebaseDatabase.getInstance().getReference();
    String currentFamily = "";
    DatabaseReference ref;
    public List<String> family = new ArrayList<>();
    public List<String> parents = new ArrayList<>();
    public String familyPass = "";
    ArrayAdapter adapter = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        currentFamily = FirebaseAuth.getInstance().getCurrentUser().getUid();
        ref = db.child("families/" + currentFamily);
        adapter = new ArrayAdapter<String>(this,
                R.layout.activity_listview, family);

        DatabaseReference familyPassRef = ref.child("/familyPass");
        familyPassRef.addListenerForSingleValueEvent(new ValueEventListener() {
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
        parentIDRef.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                for(DataSnapshot singleSnapshot : dataSnapshot.getChildren()){
                    DatabaseReference parentRef = db.child("parents/" + singleSnapshot.getKey() + "/name");
                    parentRef.addListenerForSingleValueEvent(new ValueEventListener() {
                        @Override
                        public void onDataChange(DataSnapshot parentSnapshot) {
                            family.add((String) parentSnapshot.getValue());
                            parents.add((String) parentSnapshot.getValue());
                            adapter.notifyDataSetChanged();
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
        childRef.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                for(DataSnapshot singleSnapshot : dataSnapshot.getChildren()){
                    family.add(singleSnapshot.getKey());
                    adapter.notifyDataSetChanged();
                }
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
                    Intent intent = new Intent(MainActivity.this, ChildProgressActivity.class);
                    intent.putExtra("name", name);
                    startActivity(intent);
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
    }

    public void showPopupWindow(View view) {
        // get a reference to the already created main layout
        CoordinatorLayout mainLayout = (CoordinatorLayout) findViewById(R.id.activity_main_layout);

        // inflate the layout of the popup window
        LayoutInflater inflater = (LayoutInflater) getSystemService(LAYOUT_INFLATER_SERVICE);
        View popupView = inflater.inflate(R.layout.popup_window, null);


        final EditText password = popupView.findViewById(R.id.password);
        Button submit = popupView.findViewById(R.id.popup_submit);
        Button cancel = popupView.findViewById(R.id.popup_cancel);

        // create the popup window
        int width = CoordinatorLayout.LayoutParams.WRAP_CONTENT;
        int height = CoordinatorLayout.LayoutParams.WRAP_CONTENT;
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
                    //TODO: redirect to relevant parent activity
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
