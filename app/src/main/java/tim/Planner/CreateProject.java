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

public class CreateProject extends AppCompatActivity {

    CalendarBase c;
    String courseName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_project);
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

        EditText weight = (EditText) findViewById(R.id.weight);
        String weightS = weight.getText().toString();
        if (!Pattern.matches("\\d{1,2}\\.?\\d*", weightS))
            return;
        double weightD = Double.parseDouble(weightS);

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

        Project newP;
        if (weightS.length() == 0) {
            newP = new Project(due,courseName,nameS);
        }
        else {
            //newP = new Project(due,categoryName,nameS,weightD);
        }

        //c.addProject(newP);
        //c.addTask((Task) newP);

        try {
            FileOutputStream fileOut = new FileOutputStream("/data/data/tim.calendar/cal.ser");
            ObjectOutputStream out = new ObjectOutputStream(fileOut);
            out.writeObject(c);
            out.close();
            fileOut.close();
        }catch(IOException i) {
        }

        Intent intent = new Intent(this,MainActivity.class);
        startActivity(intent);

    }

}
