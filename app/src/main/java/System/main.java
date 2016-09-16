package System;

import android.util.Log;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.LinkedList;
import java.util.regex.Pattern;
import CalendarObject.*;

/**
 * Created by Tim on 12/29/2015.
 */
public class main {

    public static void main (String args[]) {

/*      Date d = new Date();
        System.out.println(d.getYear()); //1900 + v
        System.out.println(d.getMonth()); //v-1
        System.out.println(d.getDate()); //v
*/

        //System.out.println(Pattern.matches("\\d{1,2}\\.?\\d*", "12"));

        CalendarBase e = new CalendarBase();
        e.addCourses("Test");

        try {
            FileOutputStream fileOut = new FileOutputStream("C:/Calandar/cal.ser");
            ObjectOutputStream out = new ObjectOutputStream(fileOut);
            out.writeObject(e);
            out.close();
            fileOut.close();
        }catch(IOException i) {
        }
//
//        CalendarBase c = null;
//        try
//        {
//            FileInputStream fileIn = new FileInputStream("C:/Calandar/cal.ser");
//            ObjectInputStream in = new ObjectInputStream(fileIn);
//            c = (CalendarBase) in.readObject();
//            in.close();
//            fileIn.close();
//        }catch(IOException i)
//        {
//            System.out.println("C1");
//        }catch(ClassNotFoundException ex)
//        { System.out.println("C2");
//        }
////
//        Date d0 = new Date(0,5,5);
//        Event e1 = new Event(d0, "Test", "E1" );
//        c.addEvent(e1);
//
//        Date d1 = new Date(0,5,6);
//        Event e2 = new Event(d1, "Test", "E2" );
//        c.addEvent(e2);
//
//        Date d2 = new Date(0,5,2);
//        Event e3 = new Event(d2, "Test", "E3" );
//        c.addEvent(e3);
//
//        c.addTask(e1);
//        c.addTask(e2);
//        c.addTask(e3);
//
//        //System.out.println(c.getCalendarExercise().size());
//        //System.out.println(a.getCalendarExercise().get(0));
//
//        try {
//            FileOutputStream fileOut = new FileOutputStream("C:/Calandar/cal.ser");
//            ObjectOutputStream out = new ObjectOutputStream(fileOut);
//            out.writeObject(c);
//            out.close();
//            fileOut.close();
//        }catch(IOException i) {
//        }
//
//        c = null;
//        try
//        {
//            FileInputStream fileIn = new FileInputStream("C:/Calandar/cal.ser");
//            ObjectInputStream in = new ObjectInputStream(fileIn);
//            c = (CalendarBase) in.readObject();
//            in.close();
//            fileIn.close();
//        }catch(IOException i)
//        {
//            System.out.println("C1");
//        }catch(ClassNotFoundException ex)
//        { System.out.println("C2");
//        }
//
//        LinkedList<Task> mainList = c.getcTask();
//        Collections.sort(mainList, new Comparator<Task>() {
//            @Override
//            public int compare(Task t1, Task t2) {
//                return t1.getDueDate().compareTo(t2.getDueDate());
//            }
//        });
//
//        Date d4 = new Date();
//        d4.setHours(0);
//        d4.setMinutes(0);
//        d4.setSeconds(0);
//        //System.out.println(d4.toString());
//
//        //System.out.println(c.getCalendarExercise().size());
//
//        for (int i=0; i < c.getcTask().size(); i++)
//            System.out.println(c.getcTask().get(i).getDueDate().toString());
//
//
//    }
//
//    public void sortList(CalendarBase c) {
//        LinkedList<Task> mainList = c.getcTask();
//        Collections.sort(mainList, new Comparator<Task>() {
//            @Override
//            public int compare(Task t1, Task t2) {
//                return t1.getDueDate().compareTo(t2.getDueDate());
//            }
//        });
    }


}
