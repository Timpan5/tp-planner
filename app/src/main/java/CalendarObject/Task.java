package CalendarObject;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by Tim on 12/29/2015.
 */
public abstract class Task implements Serializable {

    private Date dueDate;
    private String category;
    private String name;

    public Task (Date d, String c, String n){
        this.dueDate = d;
        this.category = c;
        this.name = n;
    }

    public abstract int getColor();

    public abstract int getFields();

    public void setDueDateDate(Date d) {
        this.dueDate = d;
    }

    public Date getDueDate() {
        return this.dueDate;
    }

    public void setCategory(String c) {
        this.category = c;
    }

    public String getCategory(){
        return this.category;
    }

    public void setName(String n) {
        this.name = n;
    }

    public String getName(){
        return this.name;
    }

}
