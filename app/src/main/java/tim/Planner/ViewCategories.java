package tim.Planner;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.method.ScrollingMovementMethod;
import android.widget.TextView;

import System.*;

public class ViewCategories extends AppCompatActivity {

    CalendarBase c;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_categories);

        Intent intent = getIntent();
        c = (CalendarBase) intent.getSerializableExtra("calendar");

        ((TextView)findViewById(R.id.categories)).setMovementMethod(new ScrollingMovementMethod());

        ((TextView) findViewById(R.id.categories)).setText(getCoursesText());


    }

    private String getCoursesText() {
        if (c.getCategory().size() == 0)
            return "No Categories";
        else {
            String ret = "";
            for (int i = 0; i < c.getCategory().size(); i++) {
                ret += c.getCategory().get(i) + "\n";
            }
            return ret;
        }
    }

}
