package com.example.lab07_sqlite_nguyenhoanganh;

import android.os.Bundle;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;

public class CustomListTravel extends AppCompatActivity {
    private List<Travel> listTravel;
    private ListView listView;
    private Button btnAdd;
    private Button btnDelete;
    private TextView txtAdd;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_custom_list_travel);


        listView = (ListView) findViewById(R.id.list_travel);
        listTravel = new ArrayList<Travel>();
        listTravel.add(new Travel(1, "Da Lat"));
        listTravel.add(new Travel(2, "Hai Phong"));
        TravelAdapter adapter = new TravelAdapter(this, R.layout.activity_item_travel, listTravel);
        listView.setAdapter(adapter);
    }


    //render list user into array
    public List<User> renderData(DatabaseHandler db){
        // Reading all contacts
        List<User> list = new ArrayList<User>();
        List<User> contacts = db.getAllContacts();
        for (User cn : contacts) {
            list.add(cn);
        }

        return list;
    }
}
