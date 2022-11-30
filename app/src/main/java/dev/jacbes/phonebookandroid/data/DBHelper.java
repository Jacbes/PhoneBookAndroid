package dev.jacbes.phonebookandroid.data;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DBHelper extends SQLiteOpenHelper {

    public DBHelper(Context context) {
        super(context, "PHONES", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE users (id NUMBER, type NUMBER, name TEXT, phone TEXT, address TEXT);");

        db.execSQL("INSERT INTO users VALUES (1, 0, 'Van Ban', '88006005588', 'NSK')," +
                "(2, 1, 'Eltex', '89007778899', 'MSK')," +
                "(3, 1, 'Yandex', '89002221199', 'MSK')," +
                "(4, 0, 'Gan Win', '89006008888', 'NSK');");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS users");
        onCreate(db);
    }
}
