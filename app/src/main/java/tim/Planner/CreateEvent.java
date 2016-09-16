package tim.Planner;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.EditText;


import java.util.Date;
import java.util.regex.Pattern;

import System.*;
import CalendarObject.*;

public class CreateEvent extends AppCompatActivity {

    CalendarBase c;
    String categoryName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_event);

        Intent intent = getIntent();
        c = (CalendarBase) intent.getSerializableExtra("calendar");
        categoryName = (String) intent.getSerializableExtra("name");
    }

    public void clickAdd(View view) {

        Log.d("Add", "Start");

        EditText name = (EditText) findViewById(R.id.nameField);
        String nameS = name.getText().toString();

        Task t = null;
        for (int i=0; i < c.getcTask().size(); i++) {
            if (c.getcTask().get(i).getName().equals(name))
                t = c.getcTask().get(i);
        }

        if (nameS.length() == 0 || t != null )
            return;


        EditText dueDate = (EditText) findViewById(R.id.dueDate);
        String dueDateS = dueDate.getText().toString();
        if (!Pattern.matches("\\d{1,2}-\\d{1,2}-\\d{4}",dueDateS))
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

        EditText notes = (EditText) findViewById(R.id.notes);
        String notesString = notes.getText().toString();

        Event newE;
        newE = new Event(due, categoryName,nameS);
        newE.setNotes(notesString);

        c.addEvent(newE);
        c.addTask((Task) newE);
        Log.d("Click", "Added Event");


        SerializeIO.writeCalendarBase(c, CreateEvent.this);

        Intent intent = new Intent(this,MainActivity.class);
        startActivity(intent);

    }
}
