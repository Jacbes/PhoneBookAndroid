package dev.jacbes.phonebookandroid;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import java.util.LinkedList;
import java.util.List;

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

        users.add(new Person("Van", "Ban", "88006005588", "NSK"));
        users.add(new Company("Eltex", "89007778899", "MSK"));
        users.add(new Company("Yandex", "89002221199", "MSK"));
        users.add(new Person("Gan", "Win", "89006008888", "NSK"));

        ((Button) findViewById(R.id.main_button)).setOnClickListener(v -> {
            Intent intent = new Intent(getApplicationContext(), AddActivity.class);
            startActivity(intent);
        });
    }

    @Override
    protected void onStart() {
        super.onStart();

        ListView mainList = findViewById(R.id.main_list);

        PhoneAdapter adapter = new PhoneAdapter(this, R.layout.item, users);
        mainList.setAdapter(adapter);
    }
}