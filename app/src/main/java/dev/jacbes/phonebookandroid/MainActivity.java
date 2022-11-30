package dev.jacbes.phonebookandroid;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.AsyncTask;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ListView;

import java.util.LinkedList;
import java.util.List;

import dev.jacbes.phonebookandroid.data.DBHelper;
import dev.jacbes.phonebookandroid.model.Company;
import dev.jacbes.phonebookandroid.model.Person;
import dev.jacbes.phonebookandroid.model.User;

public class MainActivity extends AppCompatActivity {

    static List<User> users;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        users = new LinkedList<>();

        ((Button) findViewById(R.id.main_button)).setOnClickListener(v -> {
            Intent intent = new Intent(getApplicationContext(), AddActivity.class);
            startActivity(intent);
        });
    }

    @Override
    protected void onStart() {
        super.onStart();

        ListView mainList = findViewById(R.id.main_list);

        DatabaseFill databaseFill = new DatabaseFill();
        databaseFill.execute();

        PhoneAdapter adapter = new PhoneAdapter(this, R.layout.item, users);
        mainList.setAdapter(adapter);

    }

    private class DatabaseFill extends AsyncTask<Void, Void, Long> {

        @Override
        protected Long doInBackground(Void... voids) {
            users.clear();

            SQLiteDatabase database = new DBHelper(getApplicationContext()).getReadableDatabase();
            Cursor cursor = database.rawQuery("SELECT * FROM users;", null);
            cursor.moveToFirst();
            while (!cursor.isAfterLast()) {
                if (cursor.getInt(1) == 0) {
                    if (cursor.getString(2).split(" ").length > 1) {
                        users.add(new Person(cursor.getString(2).split(" ")[0],
                                cursor.getString(2).split(" ")[1],
                                cursor.getString(3),
                                cursor.getString(4)));
                    } else {
                        users.add(new Person(cursor.getString(2).split(" ")[0],
                                "",
                                cursor.getString(3),
                                cursor.getString(4)));
                    }
                } else {
                    users.add(new Company(cursor.getString(2),
                            cursor.getString(3),
                            cursor.getString(4)));
                }
                cursor.moveToNext();
                if (isCancelled()) break;
            }
            cursor.close();

            return null;
        }
    }
}
