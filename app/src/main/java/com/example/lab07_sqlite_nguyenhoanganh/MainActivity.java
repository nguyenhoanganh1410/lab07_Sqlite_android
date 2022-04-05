package com.example.lab07_sqlite_nguyenhoanganh;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private List<User> listLanguage = new ArrayList<>();
    private ListView listView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        DatabaseHandler db = new DatabaseHandler(this);

//        // Inserting Contacts
//
//        db.addContact(new User(1, "Nguyen hoang Anh"));
//        db.addContact(new User(2, "Nguyen hoang Minh"));
//        db.addContact(new User(3, "Nguyen hoang Trung"));

        // Reading all contacts

        List<User> contacts = db.getAllContacts();

        for (User cn : contacts) {
            listLanguage.add(cn);
        }

        listView = (ListView) findViewById(R.id.mobile_list);



        UserAdaper adapter = new UserAdaper(this, R.layout.activity_item_list, listLanguage);
        listView.setAdapter(adapter);
    }
}