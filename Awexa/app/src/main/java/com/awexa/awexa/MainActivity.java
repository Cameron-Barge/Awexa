package com.awexa.awexa;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.GenericTypeIndicator;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    // Array of random fake kids
    public List<Child> children = new ArrayList<>();
    private ListView listView;
    private ArrayAdapter<Child> adapter;
    private Activity thisAct;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView = (ListView) findViewById(R.id.children_list);;
        adapter = new ArrayAdapter<>(this,
            R.layout.activity_listview, children);
        listView.setAdapter(adapter);
        thisAct = this;

        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference myRef = database.getReference("families");

        //TODO: update based on family login
        DatabaseReference dbChildren = myRef.child("family1").child("children");

        ValueEventListener postListener = new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                children = new ArrayList<>();
                for (DataSnapshot messageSnapshot: dataSnapshot.getChildren()) {
                    String name = messageSnapshot.getKey();
                    HashMap<String, String> message = (HashMap<String, String>) messageSnapshot.getValue();
                    Log.e("2", message.get("chores"));
                    children.add(new Child(name, message.get("chores").split(",")));
                }
                Log.d("size", String.valueOf(children.size()));
                adapter = new ArrayAdapter<>(thisAct,
                    R.layout.activity_listview, children);
                listView.setAdapter(adapter);
                adapter.notifyDataSetChanged();
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
                // Getting Post failed, log a message
                Log.w("mainactivity", "loadPost:onCancelled", databaseError.toException());
                // ...
            }
        };
        dbChildren.addValueEventListener(postListener);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String name = ((TextView) view).getText().toString();
                Toast.makeText(getApplicationContext(), name,
                        Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(MainActivity.this, ChildProgressActivity.class);
                intent.putExtra("name", name);
                startActivity(intent);
            }
        });

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, AddChildActivity.class));
            }
        });
    }
}
