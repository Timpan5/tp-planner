package System;


import android.content.Context;
import android.util.Log;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class SerializeIO {

    public static final String SERIALIZE_FILENAME = "cal.ser";

    public static void writeCalendarBase(CalendarBase c, Context context) {
        Log.d("writeCalendarBase", "Creating new .ser");

        try {
            FileOutputStream fileOut = context.openFileOutput(SERIALIZE_FILENAME, Context.MODE_PRIVATE);
            ObjectOutputStream out = new ObjectOutputStream(fileOut);
            out.writeObject(c);
            out.close();
            fileOut.close();
        } catch (IOException e) {
            e.printStackTrace();
            Log.d("Create", "Cannot write to internal storage");
        }
    }


    public static CalendarBase readCalendarBase(Context context) {
        CalendarBase c = new CalendarBase();

        try {
            FileInputStream fileIn = context.openFileInput(SERIALIZE_FILENAME);
            ObjectInputStream in = new ObjectInputStream(fileIn);
            c = (CalendarBase) in.readObject();
            in.close();
            fileIn.close();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException cn) {

        }

        return c;
    }

}
