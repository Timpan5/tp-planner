package tim.Planner;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.Date;
import java.util.regex.Pattern;

import System.*;
import CalendarObject.*;

public class CreateMeeting extends AppCompatActivity {

    CalendarBase c;
    String courseName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_meeting);
        Intent intent = getIntent();
        c = (CalendarBase) intent.getSerializableExtra("calendar");
        courseName = (String) intent.getSerializableExtra("name");
    }
    public void clickAdd(View view) {

        EditText name = (EditText) findViewById(R.id.nameField);
        String nameS = name.getText().toString();
        if (nameS.length() == 0)
            return;

        EditText dueDate = (EditText) findViewById(R.id.dueDate);
        String dueDateS = dueDate.getText().toString();
        if (!Pattern.matches("\\d{1,2}-\\d{1,2}-\\d{4}", dueDateS))
            return;

        EditText dueTime = (EditText) findViewById(R.id.dueTime);
        String dueTimeS = dueTime.getText().toString();
        if (!Pattern.matches("\\d{1,2}:\\d{1,2}", dueTimeS))
            return;

        String []convertDate = dueDateS.split("-");
        int year = Integer.parseInt(convertDate[2]) - 1900;
        int month = Integer.parseInt(convertDate[0]) - 1;
        int day = Integer.parseInt(convertDate[1]);
        Date due = new Date(year,month,day);

        String []convertTime = dueTimeS.split(":");
        int hour = Integer.parseInt(convertTime[0]);
        int min = Integer.parseInt(convertTime[1]);
        due.setHours(hour);
        due.setMinutes(min);

        EditText contact = (EditText) findViewById(R.id.contactInfo);
        String contactString = contact.getText().toString();

        EditText location = (EditText) findViewById(R.id.locationInfo);
        String locationString = location.getText().toString();

        EditText notes = (EditText) findViewById(R.id.notes);
        String notesString = notes.getText().toString();

        Meeting newM;
        newM = new Meeting(due, courseName, nameS, contactString, locationString);
        newM.setNotes(notesString);

        c.addMeeting(newM);
        c.addTask((Task) newM);

        SerializeIO.writeCalendarBase(c, CreateMeeting.this);

        Intent intent = new Intent(this,MainActivity.class);
        startActivity(intent);

    }
}
