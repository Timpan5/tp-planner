package CalendarObject;

import android.graphics.Color;

import java.util.Date;
import java.io.Serializable;

/**
 * Created by Tim on 12/29/2015.
 */
public class Meeting extends Event implements Serializable {

    private String contact = "";
    private String location = "";

    public Meeting(Date d, String c, String n) {
        super(d, c, n);
    }

    public Meeting(Date d, String c, String n, String co, String l) {
        super(d,c,n);
        this.contact = co;
        this.location = l;
    }

    public void setContact(String co) {this.contact = co; }

    public String getContact() { return  this.contact; }

    public void setLocation(String l) {
        this.location = l;
    }

    public String getLocation(){
        return this.location;
    }

    public int getColor() {
        return Color.RED;
    }

    public int getFields() {
        return 4;
    }


}

