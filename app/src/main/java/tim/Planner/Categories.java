package tim.Planner;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import System.*;

public class Categories extends AppCompatActivity {

    CalendarBase c;
    boolean add = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_categories);

        Intent intent = getIntent();
        c = (CalendarBase) intent.getSerializableExtra("calendar");
    }

    public void clickRadioButton(View view) {
        //Check which button is checked

        EditText categoryName = (EditText) findViewById(R.id.categoryName);

        if (view.getId()== R.id.add) {
            add = true;
            categoryName.setHint("Enter Name of Category to Add");
        }
        if (view.getId()== R.id.delete) {
            add = false;
            categoryName.setHint("Enter Name of Category to Delete");
        }
  
    }

    public void clickSubmit(View view) {
        EditText categoryName = (EditText) findViewById(R.id.categoryName);;

        String name = categoryName.getText().toString();
        String confirmation = "";

        if (name.isEmpty()) {
            confirmation = "Enter a name";
        }

        else if (add) {
            if (c.categoryExists(name)) {
                confirmation = "Category with that name already exists";
            } else {
                c.addCourses(name);
                confirmation = "Added " + name;
                Log.d("Change","Added " + name);
            }
        }

        else {
            if (!c.categoryExists(name)) {
                confirmation = "Category with that name does not exist";
            } else {
                c.deleteCategory(name);
                confirmation = "Deleted " + name;
                Log.d("Change", "Deleted " + name);
            }
        }

        ((TextView) findViewById(R.id.changes)).setText(confirmation);
        categoryName.setText("");

        return;
    }

    public void clickSaveChanges(View view) {

        SerializeIO.writeCalendarBase(c, Categories.this);

        Intent intent = new Intent(this,MainActivity.class);
        startActivity(intent);
    }

}

