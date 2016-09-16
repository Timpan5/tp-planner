package CalendarObject;

import android.graphics.Color;

import java.util.Date;
import java.io.Serializable;

/**
 * Created by Tim on 12/29/2015.
 */
public class Project extends Event implements Serializable {

    public Project(Date d, String c, String n) {
        super(d,c,n);
    }

//    public Project(Date d, String c, String n, double w) {
//        super(d,c,n,w);
//    }

    public int getColor() {
        return Color.DKGRAY;
    }

}
