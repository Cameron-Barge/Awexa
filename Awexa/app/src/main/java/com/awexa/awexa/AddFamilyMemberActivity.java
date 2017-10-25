package com.awexa.awexa;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

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
    }

    /** Called when the user taps the Submit button */
    public void addFamilyMember(View view) {
        name = findViewById(R.id.familyMemberName);
        String familyMemberName = name.getText().toString();
        radioFamilyMemberGroup = findViewById(R.id.radioFamilyMember);
        int selectedId = radioFamilyMemberGroup.getCheckedRadioButtonId();
        radioFamilyMemberButton = findViewById(selectedId);
        familyMemberType = radioFamilyMemberButton.getText().toString();
        if (radioFamilyMemberButton.getText().toString().equals("Child")) {
            Child child = new Child(familyMemberName, currentFamily);
            DatabaseReference childRef = db.child("children");
            childRef.push().setValue(child);
            DatabaseReference keyRef = childRef.push();
            String childID = keyRef.getKey();
            DatabaseReference childNamesRef = db.child("families/" + currentFamily + "/child_names/" + familyMemberName);
            childNamesRef.setValue(childID);
            DatabaseReference childrenRef = db.child("families/" + currentFamily + "/children/" + childID);
            childrenRef.setValue(true);
            Toast.makeText(getApplicationContext(), familyMemberType + " " + familyMemberName + " was added...",
                    Toast.LENGTH_SHORT).show();
        } else if (radioFamilyMemberButton.getText().toString().equals("Parent")) {
            //TODO: implementation for adding parent to db
            Toast.makeText(getApplicationContext(), familyMemberType + " " + familyMemberName + " was added...",
                    Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(getApplicationContext(), "Please select a radio button.",
                    Toast.LENGTH_SHORT).show();
        }
    }
}