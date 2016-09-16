package CalendarObject;

import java.io.Serializable;
import java.util.Date;
import android.graphics.Color;

/**
 * Created by Tim on 12/29/2015.
 */
public class Event extends Task implements Serializable{

    private String notes = "";

    public Event(Date d, String c, String n) {
        super(d,c,n);
    }

    public void setNotes(String str) {
        this.notes = str;
    }

    public String getNotes() {
        return this.notes;
    }

    public int getColor() {
        return Color.MAGENTA;
    }

    public int getFields() {
        return 3;
    }

}

