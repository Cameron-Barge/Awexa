package com.awexa.awexa;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.HashMap;
import java.util.Map;

public class AddChildActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_child);
    }

    /** Called when the user taps the Submit button */
    public void addChild(View view) {
        EditText text = (EditText)findViewById(R.id.childName);
        String childName = text.getText().toString();
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference childDb = database.getReference("children");
        Map<String, Object> childUpdates = new HashMap<>();
        Child c = new Child();
        c.name = childName;
        c.childId = childDb.push().getKey();
        childUpdates.put("children/" + c.childId, c);
        childUpdates.put("families/family1/children/" + c.childId, true);
        database.getReference().updateChildren(childUpdates);
        Toast.makeText(getApplicationContext(), childName + " was added...",
            Toast.LENGTH_SHORT).show();
        finish();
    }

    @Override
    public void onBackPressed() {
        finish();
    }
}