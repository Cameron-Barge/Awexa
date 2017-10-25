package com.awexa.awexa;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class AddFamilyMemberActivity extends AppCompatActivity {
    private RadioGroup radioFamilyMemberGroup;
    private RadioButton radioFamilyMemberButton;
    private String familyMemberType;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_family_member);
    }

    /** Called when the user taps the Submit button */
    public void addFamilyMember(View view) {
        EditText text = findViewById(R.id.familyMemberName);
        String familyMember = text.getText().toString();
        radioFamilyMemberGroup = findViewById(R.id.radioFamilyMember);
        int selectedId = radioFamilyMemberGroup.getCheckedRadioButtonId();
        radioFamilyMemberButton = findViewById(selectedId);
        familyMemberType = radioFamilyMemberButton.getText().toString();
        if (radioFamilyMemberButton.getText().toString().equals("Child")) {
            //TODO: implementation for adding child to db
            Toast.makeText(getApplicationContext(), familyMemberType + " " + familyMember + " was added...",
                    Toast.LENGTH_SHORT).show();
        } else if (radioFamilyMemberButton.getText().toString().equals("Parent")) {
            //TODO: implementation for adding parent to db
            Toast.makeText(getApplicationContext(), familyMemberType + " " + familyMember + " was added...",
                    Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(getApplicationContext(), "Please select a radio button.",
                    Toast.LENGTH_SHORT).show();
        }
    }
}