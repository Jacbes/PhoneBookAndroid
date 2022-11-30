package dev.jacbes.phonebookandroid;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class InfoActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info);

        Intent info = getIntent();
        String type = info.getStringExtra("type");
        String name = info.getStringExtra("name");
        String phone = info.getStringExtra("phone");

        ImageView avatar = findViewById(R.id.info_avatar);

        ((TextView) findViewById(R.id.info_type)).setText(type);
        ((TextView) findViewById(R.id.info_name)).setText(name);
        ((TextView) findViewById(R.id.info_phone)).setText(phone);

        if (type.equals("Person")) {
            avatar.setImageResource(R.drawable.ic_baseline_person_24);
        }
        if (type.equals("Company")) {
            avatar.setImageResource(R.drawable.ic_baseline_corporate_fare_24);
        }
    }
}
