package haqnawaz.org.navigationdrawer;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.readystatesoftware.sqliteasset.SQLiteAssetHelper;

import java.util.ArrayList;

public class DatabaseAccess {
    private SQLiteOpenHelper openHelper;
    private SQLiteDatabase db;
    private static DatabaseAccess instance;
    Cursor c = null;
    ArrayList<String> Para;
    ArrayList<String> Surah;

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
    //will query for ayah by passing ayah no & surah no
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

    //method to query and return data from database
    //will query for para by passing name
    public ArrayList<String> GetPara(int pId)
    {
        //c = db.rawQuery("select ArabicText from tayah where ParaId = ?", new String[]{String.valueOf(pId)});

        c = db.rawQuery("select ArabicText from tayah where ParaId = ? order by SuraId, ParaId", new String[]{String.valueOf(pId)});

        Para = new ArrayList<>();

        // moving our cursor to first position.
        if (c.moveToFirst()) {
            do {
                Para.add(new String(c.getString(0)));
            } while (c.moveToNext());

        }

        c.close();
        return Para;
    }

    //method to query and return data from database
    //will query for para by passing name
    public ArrayList<String> GetSurah(int pId)
    {
        //c = db.rawQuery("select ArabicText from tayah where ParaId = ?", new String[]{String.valueOf(pId)});

        c = db.rawQuery("select ArabicText from tayah where SuraId = ? order by SuraId, AyaId", new String[]{String.valueOf(pId)});

        Surah = new ArrayList<>();

        // moving our cursor to first position.
        if (c.moveToFirst()) {
            do {
                Surah.add(new String(c.getString(0)));
            } while (c.moveToNext());

        }

        c.close();
        return Surah;
    }
}
