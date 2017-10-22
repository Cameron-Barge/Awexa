package com.awexa.awexa;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.InputFilter;
import android.text.Spanned;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.Map;

public class EditChoreActivity extends AppCompatActivity {
    String choreId;
    String childId;
    EditText nameEt;
    EditText rewardEt;
    EditText startTimeEt;
    EditText endTimeEt;
    EditText descriptionEt;
    TextView startTv;
    TextView endTv;
    RadioButton dailyRepeatRadioBtn;
    RadioButton weeklyRepeatRadioBtn;
    RadioButton monthlyRepeatRadioBtn;
    LinearLayout daysLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_chore);

        nameEt = (EditText)findViewById(R.id.choreName);
        rewardEt = (EditText)findViewById(R.id.reward);
        daysLayout = (LinearLayout)findViewById(R.id.weekLayout);
        startTimeEt = (EditText)findViewById(R.id.startTimeET);
        endTimeEt = (EditText)findViewById(R.id.endTimeET);
        descriptionEt = (EditText)findViewById(R.id.description);

        startTv = (TextView)findViewById(R.id.startTime);
        endTv = (TextView)findViewById(R.id.endTime);

        if (getIntent().getExtras() != null) {
            choreId = getIntent().getExtras().getString("choreId", "defaultKey");
            childId = getIntent().getExtras().getString("childId", "defaultKey");
        }

        dailyRepeatRadioBtn = (RadioButton) findViewById(R.id.repeatCheckDaily);
        weeklyRepeatRadioBtn = (RadioButton) findViewById(R.id.repeatCheckWeekly);
        monthlyRepeatRadioBtn = (RadioButton) findViewById(R.id.repeatCheckMontly);

        weeklyRepeatRadioBtn.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean checked) {
                if (checked) {
                    daysLayout.setVisibility(View.VISIBLE);
                } else {
                    daysLayout.setVisibility(View.GONE);
                }
            }
        });

        monthlyRepeatRadioBtn.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean checked) {
                if (!checked) {
                    startTimeEt.setVisibility(View.VISIBLE);
                    endTimeEt.setVisibility(View.VISIBLE);
                    startTv.setVisibility(View.VISIBLE);
                    endTv.setVisibility(View.VISIBLE);
                } else {
                    startTimeEt.setVisibility(View.GONE);
                    endTimeEt.setVisibility(View.GONE);
                    startTv.setVisibility(View.GONE);
                    endTv.setVisibility(View.GONE);
                }
            }
        });

        boolean weeklyRepeat = weeklyRepeatRadioBtn.isChecked();
        if (weeklyRepeat) {
            daysLayout.setVisibility(View.VISIBLE);
        } else {
            daysLayout.setVisibility(View.GONE);
        }


        InputFilter timeFilter  = new InputFilter() {
            @Override
            public CharSequence filter(CharSequence source, int start, int end, Spanned dest,
                                       int dstart, int dend) {
                if (source.length() == 0) {
                    return null;// deleting, keep original editing
                }
                String result = "";
                result += dest.toString().substring(0, dstart);
                result += source.toString().substring(start, end);
                result += dest.toString().substring(dend, dest.length());

                if (result.length() > 5) {
                    return "";// do not allow this edit
                }
                boolean allowEdit = true;
                char c;
                if (result.length() > 0) {
                    c = result.charAt(0);
                    allowEdit &= (c >= '0' && c <= '2');
                }
                if (result.length() > 1) {
                    c = result.charAt(1);
                    if(result.charAt(0) == '0' || result.charAt(0) == '1')
                        allowEdit &= (c >= '0' && c <= '9');
                    else
                        allowEdit &= (c >= '0' && c <= '3');
                }
                if (result.length() > 2) {
                    c = result.charAt(2);
                    allowEdit &= (c == ':');
                }
                if (result.length() > 3) {
                    c = result.charAt(3);
                    allowEdit &= (c >= '0' && c <= '5');
                }
                if (result.length() > 4) {
                    c = result.charAt(4);
                    allowEdit &= (c >= '0' && c <= '9');
                }
                return allowEdit ? null : "";
            }

        };

        endTimeEt.setFilters(new InputFilter[]{timeFilter});

        FirebaseDatabase.getInstance().getReference("chores").child(choreId)
            .addListenerForSingleValueEvent(new ValueEventListener() {
                @Override
                public void onDataChange(DataSnapshot snapshot) {
                    Chore chore = snapshot.getValue(Chore.class);

                    initializeView(chore);
                }

                @Override
                public void onCancelled(DatabaseError databaseError) {
                }
            });
    }

    public void initializeView(Chore c) {
        nameEt.setText(c.name);
        descriptionEt.setText(c.description);
        SimpleDateFormat df = new SimpleDateFormat("hh:mm");
        startTimeEt.setText(df.format(c.start), EditText.BufferType.EDITABLE);
        endTimeEt.setText(df.format(c.due), EditText.BufferType.EDITABLE);
        rewardEt.setText(String.valueOf(c.points));
        switch ((String)c.recurrence.get("repeat")) {
            case "once":
                dailyRepeatRadioBtn.setChecked(false);
                weeklyRepeatRadioBtn.setChecked(false);
                monthlyRepeatRadioBtn.setChecked(false);
                break;
            case "daily":
                dailyRepeatRadioBtn.setChecked(true);
                break;
            case "weekly":
                ((CheckBox)findViewById(R.id.sunCheck)).setChecked(false);
                ((CheckBox)findViewById(R.id.monCheck)).setChecked(false);
                ((CheckBox)findViewById(R.id.tueCheck)).setChecked(false);
                ((CheckBox)findViewById(R.id.wedCheck)).setChecked(false);
                ((CheckBox)findViewById(R.id.thuCheck)).setChecked(false);
                ((CheckBox)findViewById(R.id.friCheck)).setChecked(false);
                ((CheckBox)findViewById(R.id.satCheck)).setChecked(false);
                weeklyRepeatRadioBtn.setChecked(true);
                for (String i: ((HashMap<String, Boolean>)c.recurrence.get("days")).keySet()) {
                    switch (i) {
                        case "Su":
                            ((CheckBox)findViewById(R.id.sunCheck)).setChecked(true);
                            break;
                        case "M":
                            ((CheckBox)findViewById(R.id.monCheck)).setChecked(true);
                            break;
                        case "Tu":
                            ((CheckBox)findViewById(R.id.tueCheck)).setChecked(true);
                            break;
                        case "W":
                            ((CheckBox)findViewById(R.id.wedCheck)).setChecked(true);
                            break;
                        case "Th":
                            ((CheckBox)findViewById(R.id.thuCheck)).setChecked(true);
                            break;
                        case "F":
                            ((CheckBox)findViewById(R.id.friCheck)).setChecked(true);
                            break;
                        case "Sa":
                            ((CheckBox)findViewById(R.id.satCheck)).setChecked(true);
                            break;
                    }
                }
                break;
            case "monthly":
                monthlyRepeatRadioBtn.setChecked(true);
                break;
        }
    }

    public void updateChore(View view) {
        // Instantiate fields and respective variables
        String choreName = nameEt.getText().toString();

        int rewardPoints = Integer.parseInt(rewardEt.getText().toString());

        boolean dailyRepeat = dailyRepeatRadioBtn.isChecked();

        boolean monthlyRepeat = monthlyRepeatRadioBtn.isChecked();

        weeklyRepeatRadioBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (((RadioButton) view).isChecked()) {
                    daysLayout.setVisibility(View.VISIBLE);
                } else {
                    daysLayout.setVisibility(View.GONE);
                }
            }
        });
        boolean weeklyRepeat = weeklyRepeatRadioBtn.isChecked();
        if (weeklyRepeat) {
            daysLayout.setVisibility(View.VISIBLE);
        } else {
            daysLayout.setVisibility(View.GONE);
        }
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
        final DatabaseReference choresDb = FirebaseDatabase.getInstance().getReference("chores/"
            + choreId);
        Map<Object, Object> newChore = new HashMap<>();
        newChore.put("name", choreName);
        newChore.put("childId", childId);
        newChore.put("description", description);
        newChore.put("points", rewardPoints);
        Map<String, Object> recurrence = new HashMap<>();
        if (weeklyRepeat) {
            recurrence.put("repeat", "weekly");
            HashMap<String, Boolean> days = new HashMap<>();
            if (sunRepeat) {
                days.put("0", true);
            }
            if (monRepeat) {
                days.put("1", true);
            }
            if (tuesRepeat) {
                days.put("2", true);
            }
            if (wedRepeat) {
                days.put("3", true);
            }
            if (thursRepeat) {
                days.put("4", true);
            }
            if (friRepeat) {
                days.put("5", true);
            }
            if (satRepeat) {
                days.put("6", true);
            }
            recurrence.put("days", days);
        }
        if (dailyRepeat) {
            recurrence.put("repeat", "daily");
        }
        if (!monthlyRepeat) {
            recurrence.put("startTime", startTimeEt.getText().toString());
            recurrence.put("endTime", endTimeEt.getText().toString());
            if (!dailyRepeat && !weeklyRepeat) {
                recurrence.put("repeat", "once");
            }
        } else {
            recurrence.put("repeat", "monthly");
        }
        newChore.put("recurrence", recurrence);
        Toast.makeText(getApplicationContext(), choreName + " was updated...",
                Toast.LENGTH_SHORT).show();
        choresDb.setValue(newChore);
        final DatabaseReference childDb = FirebaseDatabase.getInstance().getReference("children/"
            + childId + "/chores/" + choreId);
        childDb.setValue(false);
        finish();
    }

    @Override
    public void onBackPressed() {
        finish();
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.home:
                onBackPressed();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
