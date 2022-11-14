package dev.jacbes.phonebookandroid;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import dev.jacbes.phonebookandroid.model.Company;
import dev.jacbes.phonebookandroid.model.Person;
import dev.jacbes.phonebookandroid.model.User;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        User[] users = {
                new Person("Van", "Ban", "88006005588", "NSK"),
                new Company("Eltex", "89007778899", "MSK"),
                new Company("Yandex", "89002221199", "MSK"),
                new Person("Gan", "Win", "89006008888", "NSK"),
        };

        ListView mainList = findViewById(R.id.main_list);

        PhoneAdapter adapter = new PhoneAdapter(this, R.layout.item, users);
        mainList.setAdapter(adapter);
    }
}