package dev.jacbes.phonebookandroid;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import dev.jacbes.phonebookandroid.model.Company;
import dev.jacbes.phonebookandroid.model.Person;

public class AddActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add);

        ListView typesView = (ListView) findViewById(R.id.add_type);
        typesView.setChoiceMode(ListView.CHOICE_MODE_SINGLE);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(
                this, R.array.types,
                android.R.layout.simple_list_item_single_choice);
        typesView.setAdapter(adapter);

        Button addButton = (Button) findViewById(R.id.add_button);
        addButton.setOnClickListener(v -> {
            String name = ((EditText) findViewById(R.id.add_name)).getText().toString();
            String phone = ((EditText) findViewById(R.id.add_phone)).getText().toString();
            String address = ((EditText) findViewById(R.id.add_address)).getText().toString();
            if (typesView.getCheckedItemPosition() != -1) {
                if (typesView.getCheckedItemPosition() == 0) {
                    Person person;
                    if (name.split(" ").length > 1) {
                        person = new Person(name.split(" ")[0], name.split(" ")[1], phone, address);
                    } else {
                        person = new Person(name, "", phone, address);
                    }
                    MainActivity.users.add(person);
                } else {
                    Company company = new Company(name, phone, address);
                    MainActivity.users.add(company);
                }
                finish();
            }
        });
    }
}