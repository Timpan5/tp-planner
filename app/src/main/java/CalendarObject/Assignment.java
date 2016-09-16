package CalendarObject;

import android.graphics.Color;

import java.util.Date;
import java.io.Serializable;

/**
 * Created by Tim on 12/29/2015.
 */
public class Assignment extends Event implements Serializable {

    public Assignment(Date d, String c, String n) {
        super(d,c,n);
    }

//    public Assignment(Date d, String c, String n, double w) {
//        super(d,c,n,w);
//    }

    public int getColor() {
        return Color.BLUE;
    }
}
