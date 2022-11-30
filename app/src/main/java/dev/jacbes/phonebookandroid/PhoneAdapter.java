package dev.jacbes.phonebookandroid;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import dev.jacbes.phonebookandroid.model.Company;
import dev.jacbes.phonebookandroid.model.Person;
import dev.jacbes.phonebookandroid.model.User;

public class PhoneAdapter extends ArrayAdapter<User> {

    private final Context context;
    private final User[] users;
    private final int layout;

    public PhoneAdapter(Context context, int layout, User[] users) {
        super(context, layout, users);
        this.context = context;
        this.users = users;
        this.layout = layout;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View rowView = inflater.inflate(layout, parent, false);

        TextView nameView = rowView.findViewById(R.id.name);
        TextView addressView = rowView.findViewById(R.id.address);
        ImageView avatarView = rowView.findViewById(R.id.avatar);

        if (users[position] instanceof Person) {
            nameView.setText(((Person) users[position]).getFirstName() + " " + ((Person) users[position]).getSecondName());
            avatarView.setImageResource(R.drawable.ic_baseline_person_24);
        }
        if (users[position] instanceof Company) {
            nameView.setText(((Company) users[position]).getOrganization());
            avatarView.setImageResource(R.drawable.ic_baseline_corporate_fare_24);
        }
        addressView.setText(users[position].getAddress());

        rowView.setOnClickListener(v -> {
            Intent toDev = new Intent(context, DevActivity.class);
            if (users[position] instanceof Person) {
                toDev.putExtra("name", ((Person) users[position]).getFirstName() + " "
                        + ((Person) users[position]).getSecondName());
                toDev.putExtra("phone", users[position].getPhone());
                toDev.putExtra("type", "Person");
            }
            if (users[position] instanceof Company) {
                toDev.putExtra("name", ((Company) users[position]).getOrganization());
                toDev.putExtra("phone", users[position].getPhone());
                toDev.putExtra("type", "Company");
            }
            context.startActivity(toDev);
//            Toast.makeText(context, users[position].getPhone(), Toast.LENGTH_SHORT).show();
        });

        return rowView;
    }
}
