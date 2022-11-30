package dev.jacbes.phonebookandroid;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.List;

import dev.jacbes.phonebookandroid.model.Company;
import dev.jacbes.phonebookandroid.model.Person;
import dev.jacbes.phonebookandroid.model.User;

public class PhoneAdapter extends ArrayAdapter<User> {

    private final Context context;
    private final List<User> users;
    private final int layout;

    public PhoneAdapter(Context context, int layout, List<User> users) {
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

        if (users.get(position) instanceof Person) {
            nameView.setText(((Person) users.get(position)).getFirstName() + " " + ((Person) users.get(position)).getSecondName());
            avatarView.setImageResource(R.drawable.ic_baseline_person_24);
        }
        if (users.get(position) instanceof Company) {
            nameView.setText(((Company) users.get(position)).getOrganization());
            avatarView.setImageResource(R.drawable.ic_baseline_corporate_fare_24);
        }
        addressView.setText(users.get(position).getAddress());

        rowView.setOnClickListener(v -> {
            Intent toDev = new Intent(context, InfoActivity.class);
            if (users.get(position) instanceof Person) {
                toDev.putExtra("name", ((Person) users.get(position)).getFirstName() + " "
                        + ((Person) users.get(position)).getSecondName());
                toDev.putExtra("phone", users.get(position).getPhone());
                toDev.putExtra("type", "Person");
            }
            if (users.get(position) instanceof Company) {
                toDev.putExtra("name", ((Company) users.get(position)).getOrganization());
                toDev.putExtra("phone", users.get(position).getPhone());
                toDev.putExtra("type", "Company");
            }
            context.startActivity(toDev);
        });

        return rowView;
    }
}
