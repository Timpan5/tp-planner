package tim.Planner;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;

import System.*;

public class SelectCategory extends AppCompatActivity {

    CalendarBase c;
    @Override
    public void onCreate(Bundle savedInstanceState) {
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
        add_txt.setText("Select Category");
        add_txt.setGravity(Gravity.CENTER_HORIZONTAL);
        ll.addView(add_txt, layoutParams);

        final Context context = this;
        this.setContentView(scrl);

        for (int i = c.getCategory().size() - 1; i >= 0; i--) {
            final Button add_btn = new Button(this);
            add_btn.setText(c.getCategory().get(i));
            ll.addView(add_btn, layoutParams);

            add_btn.setOnClickListener(new View.OnClickListener() {

                @Override
                public void onClick(View v) {
                    Log.d("Button", add_btn.getText().toString());
                    Intent intent1 = new Intent(context,SelectTaskType.class);
                    intent1.putExtra("calendar",c);
                    intent1.putExtra("name",add_btn.getText().toString());
                    startActivity(intent1);
                }
            });
        }


    }


}
