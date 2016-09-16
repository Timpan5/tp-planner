package tim.Planner;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import java.util.Date;
import java.util.regex.Pattern;

import System.*;
import CalendarObject.*;


public class ViewEvent extends AppCompatActivity {

    CalendarBase c;
    String name;
    Task t = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_event);

        Intent intent = getIntent();
        c = (CalendarBase) intent.getSerializableExtra("calendar");
        name = (String) intent.getSerializableExtra("name");

        setUp();

    }

    public void setUp() {

        for (int i=0; i < c.getcTask().size(); i++) {
            if (c.getcTask().get(i).getName().equals(name))
                t = c.getcTask().get(i);
        }

        if (t == null) {
            Log.d("setUp", "Task not found");
            return;
        }

        TextView title = ((TextView)findViewById(R.id.title));
        title.setText(t.getName());

        EditText f1 = ((EditText)findViewById(R.id.nameField));
        EditText f2 = ((EditText)findViewById(R.id.dueDate));
        EditText f3 = ((EditText)findViewById(R.id.dueTime));
        EditText f4 = ((EditText)findViewById(R.id.notes));

        Date due = t.getDueDate();
        String minOut;

        if (due.getMinutes() < 10)
            minOut = "0" + due.getMinutes();
        else
            minOut = new Integer(due.getMinutes()).toString();


        f1.setText(t.getName());
        f2.setText((due.getMonth() + 1) + "-" + due.getDate() + "-" + (due.getYear() + 1900));
        f3.setText(due.getHours() + ":" + minOut);
        f4.setText(((Event) t).getNotes());

    }

    public void clickUpdate(View view) {

        Log.d("Click", "Update Begin");

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

        t.setDueDateDate(due);
        t.setName(nameS);

        EditText notes = (EditText) findViewById(R.id.notes);
        String notesString = notes.getText().toString();
        ((Event) t).setNotes(notesString);

        SerializeIO.writeCalendarBase(c, ViewEvent.this);

        Intent intent = new Intent(this,MainActivity.class);
        startActivity(intent);

    }

    public void clickDone(View view) {
        Intent intent = new Intent(this,MainActivity.class);
        startActivity(intent);
    }

    public void clickDelete(View view) {
        c.deleteEvent((Event) t);
        SerializeIO.writeCalendarBase(c, ViewEvent.this);
        Intent intent = new Intent(this,MainActivity.class);
        startActivity(intent);
    }

}
