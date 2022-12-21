package dev.jacbes.phonebookandroid;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
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
        Button callButton = rowView.findViewById(R.id.call_button);
        Button addContactButton = rowView.findViewById(R.id.add_contact_button);

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
            Intent toInfo = new Intent(context, InfoActivity.class);
            if (users.get(position) instanceof Person) {
                toInfo.putExtra("name", ((Person) users.get(position)).getFirstName() + " "
                        + ((Person) users.get(position)).getSecondName());
                toInfo.putExtra("phone", users.get(position).getPhone());
                toInfo.putExtra("type", "Person");
            }
            if (users.get(position) instanceof Company) {
                toInfo.putExtra("name", ((Company) users.get(position)).getOrganization());
                toInfo.putExtra("phone", users.get(position).getPhone());
                toInfo.putExtra("type", "Company");
            }
            context.startActivity(toInfo);
        });

        callButton.setOnClickListener(v -> {
            Intent call = new Intent(Intent.ACTION_CALL, Uri.parse("tel:" + users.get(position).getPhone()));
            context.startActivity(call);
        });

        return rowView;
    }
}
