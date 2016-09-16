package tim.Planner;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import System.*;

public class MainActivity extends AppCompatActivity {

    CalendarBase c;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        c = SerializeIO.readCalendarBase(MainActivity.this);

    }



    public void clickManageCategory(View view) {
        Intent intent = new Intent(this,Categories.class);
        intent.putExtra("calendar", c);
        startActivity(intent);
    }

    public void clickViewCategory(View view){
        Intent intent = new Intent(this,ViewCategories.class);
        intent.putExtra("calendar",c);
        startActivity(intent);
    }

    public void clickNewTask (View view) {
        Intent intent;

        if (c.getCategory().isEmpty()) {
            intent = new Intent(this, Categories.class);
        }
        else {
            intent = new Intent(this, SelectCategory.class);
        }
        intent.putExtra("calendar", c);
        startActivity(intent);
    }

    public void clickViewList (View view) {
        Intent intent = new Intent (this,ViewList.class);
        intent.putExtra("calendar", c);
        startActivity(intent);
    }

    public void clickDeleteData (View view) {
        c = new CalendarBase();
        SerializeIO.writeCalendarBase(c, MainActivity.this);
    }


}
