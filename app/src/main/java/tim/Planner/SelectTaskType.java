package tim.Planner;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import System.*;

public class SelectTaskType extends AppCompatActivity {

    CalendarBase c;
    String categoryName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select_task_type);

        Intent intent = getIntent();
        c = (CalendarBase) intent.getSerializableExtra("calendar");
        categoryName = (String) intent.getSerializableExtra("name");
    }

    public void clickEvent(View view) {
        Intent intent = new Intent(this,CreateEvent.class);
        intent.putExtra("calendar", c);
        intent.putExtra("name", categoryName);
        startActivity(intent);
    }

    public void clickAssignment(View view) {
        Intent intent = new Intent(this,CreateAssignment.class);
        intent.putExtra("calendar", c);
        intent.putExtra("name", categoryName);
        startActivity(intent);
    }

    public void clickMeeting(View view) {
        Intent intent = new Intent(this,CreateMeeting.class);
        intent.putExtra("calendar", c);
        intent.putExtra("name", categoryName);
        startActivity(intent);
    }

    public void clickProject(View view) {
        Intent intent = new Intent(this,CreateProject.class);
        intent.putExtra("calendar", c);
        intent.putExtra("name", categoryName);
        startActivity(intent);
    }

}
