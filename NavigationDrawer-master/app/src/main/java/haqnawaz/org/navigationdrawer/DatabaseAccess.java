package haqnawaz.org.navigationdrawer;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.readystatesoftware.sqliteasset.SQLiteAssetHelper;

public class DatabaseAccess {
    private SQLiteOpenHelper openHelper;
    private SQLiteDatabase db;
    private static DatabaseAccess instance;
    Cursor c = null;

    //private constructor to avoid object creation from outside class
    private DatabaseAccess(Context context)
    {
        this.openHelper = new DatabaseOpenHelper(context);
    }

    //to return the single instance of database
    public static DatabaseAccess getInstance(Context context)
    {
        if(instance == null)
        {
            instance = new DatabaseAccess(context);
        }
        return instance;
    }

    //to open the database
    public void open()
    {
        this.db = openHelper.getWritableDatabase();
    }

    //to close the database
    public void close()
    {
        if (db != null)
        {
            this.db.close();
        }
    }

    //method to query and return data from database
    //will query for address by passing name
    public String getAyah(int an, int sn)
    {
        c = db.rawQuery("select ArabicText from tayah where AyaNo = ? and SuraId =?", new String[]{String.valueOf(an), String.valueOf(sn)});

        StringBuffer buffer = new StringBuffer();
        while (c.moveToNext())
        {
            String arabicText = c.getString(0);
            buffer.append(""+arabicText);
        }
        return buffer.toString();
    }
}
