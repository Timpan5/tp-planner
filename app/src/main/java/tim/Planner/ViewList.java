package tim.Planner;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;

import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.LinkedList;

import CalendarObject.*;
import System.*;

public class ViewList extends AppCompatActivity {

    CalendarBase c;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Intent intent = getIntent();
        c = (CalendarBase) intent.getSerializableExtra("calendar");

        ScrollView scrl = new ScrollView(this);
        final LinearLayout ll = new LinearLayout(this);
        ll.setOrientation(LinearLayout.VERTICAL);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.FILL_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT);
        scrl.addView(ll);

        final TextView add_txt = new TextView(this);
        add_txt.setTextSize(24);
        add_txt.setText("Upcoming Tasks");
        add_txt.setGravity(Gravity.CENTER_HORIZONTAL);
        ll.addView(add_txt, layoutParams);

        final Context context = this;
        this.setContentView(scrl);

        sortList();

        LinkedList<Task> tList = c.getcTask();

        Date today = new Date();
        today.setHours(0);
        today.setMinutes(0);
        today.setSeconds(0);

        String []weekday = {"Sun", "Mon", "Tue", "Wed", "Thr", "Fri", "Sat"};
        Task curr;

        for (int i=0; i < tList.size(); i++) {
            curr = tList.get(i);
            if (curr.getDueDate().after(today)) {
                final Button add_btn = new Button(this);
                add_btn.setText(weekday[curr.getDueDate().getDay()] + " " + curr.getDueDate().getDate() + " -- " + curr.getName() + " -- " + curr.getCategory());
                add_btn.setTextColor(curr.getColor());

                ll.addView(add_btn, layoutParams);

                //Create button transition
                add_btn.setOnClickListener(new View.OnClickListener() {

                    @Override
                    public void onClick(View v) {
                        String []tName = add_btn.getText().toString().split("--");
                        Intent intent1 = new Intent(context, ViewEvent.class);
                        intent1.putExtra("calendar", c);
                        intent1.putExtra("name", tName[1].substring(1,tName[1].length() - 1));
                        startActivity(intent1);
                    }
                });
            }
        }
    }

    public void sortList() {
        LinkedList<Task> mainList = c.getcTask();
        Collections.sort(mainList, new Comparator<Task>() {
            @Override
            public int compare(Task t1, Task t2) {
                return t1.getDueDate().compareTo(t2.getDueDate());
            }
        });
    }



}
